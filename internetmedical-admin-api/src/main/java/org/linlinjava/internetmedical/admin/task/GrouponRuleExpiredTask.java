package org.linlinjava.internetmedical.admin.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.internetmedical.core.task.Task;
import org.linlinjava.internetmedical.core.util.BeanUtil;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGroupon;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGrouponRules;
import org.linlinjava.internetmedical.db.domain.InternetmedicalOrder;
import org.linlinjava.internetmedical.db.service.*;
import org.linlinjava.internetmedical.db.util.GrouponConstant;
import org.linlinjava.internetmedical.db.util.OrderUtil;

import java.util.List;

public class GrouponRuleExpiredTask extends Task {
    private final Log logger = LogFactory.getLog(GrouponRuleExpiredTask.class);
    private int grouponRuleId = -1;

    public GrouponRuleExpiredTask(Integer grouponRuleId, long delayInMilliseconds){
        super("GrouponRuleExpiredTask-" + grouponRuleId, delayInMilliseconds);
        this.grouponRuleId = grouponRuleId;
    }

    @Override
    public void run() {
        logger.info("系统开始处理延时任务---团购规则过期---" + this.grouponRuleId);

        InternetmedicalOrderService orderService = BeanUtil.getBean(InternetmedicalOrderService.class);
        InternetmedicalGrouponService grouponService = BeanUtil.getBean(InternetmedicalGrouponService.class);
        InternetmedicalGrouponRulesService grouponRulesService = BeanUtil.getBean(InternetmedicalGrouponRulesService.class);

        InternetmedicalGrouponRules grouponRules = grouponRulesService.findById(grouponRuleId);
        if(grouponRules == null){
            return;
        }
        if(!grouponRules.getStatus().equals(GrouponConstant.RULE_STATUS_ON)){
            return;
        }

        // 团购活动取消
        grouponRules.setStatus(GrouponConstant.RULE_STATUS_DOWN_EXPIRE);
        grouponRulesService.updateById(grouponRules);

        List<InternetmedicalGroupon> grouponList = grouponService.queryByRuleId(grouponRuleId);
        // 用户团购处理
        for(InternetmedicalGroupon groupon : grouponList){
            Short status = groupon.getStatus();
            InternetmedicalOrder order = orderService.findById(groupon.getOrderId());
            if(status.equals(GrouponConstant.STATUS_NONE)){
                groupon.setStatus(GrouponConstant.STATUS_FAIL);
                grouponService.updateById(groupon);
            }
            else if(status.equals(GrouponConstant.STATUS_ON)){
                // 如果团购进行中
                // (1) 团购设置团购失败等待退款状态
                groupon.setStatus(GrouponConstant.STATUS_FAIL);
                grouponService.updateById(groupon);
                // (2) 团购订单申请退款
                if(OrderUtil.isPayStatus(order)) {
                    order.setOrderStatus(OrderUtil.STATUS_REFUND);
                    orderService.updateWithOptimisticLocker(order);
                }
            }
        }
        logger.info("系统结束处理延时任务---团购规则过期---" + this.grouponRuleId);
    }
}
