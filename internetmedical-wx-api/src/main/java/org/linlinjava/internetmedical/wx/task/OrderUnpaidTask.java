package org.linlinjava.internetmedical.wx.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.internetmedical.core.system.SystemConfig;
import org.linlinjava.internetmedical.core.task.Task;
import org.linlinjava.internetmedical.core.util.BeanUtil;
import org.linlinjava.internetmedical.db.domain.InternetmedicalOrder;
import org.linlinjava.internetmedical.db.domain.InternetmedicalOrderGoods;
import org.linlinjava.internetmedical.db.service.InternetmedicalGoodsProductService;
import org.linlinjava.internetmedical.db.service.InternetmedicalOrderGoodsService;
import org.linlinjava.internetmedical.db.service.InternetmedicalOrderService;
import org.linlinjava.internetmedical.db.util.OrderUtil;
import org.linlinjava.internetmedical.wx.service.WxOrderService;

import java.time.LocalDateTime;
import java.util.List;

public class OrderUnpaidTask extends Task {
    private final Log logger = LogFactory.getLog(OrderUnpaidTask.class);
    private int orderId = -1;

    public OrderUnpaidTask(Integer orderId, long delayInMilliseconds){
        super("OrderUnpaidTask-" + orderId, delayInMilliseconds);
        this.orderId = orderId;
    }

    public OrderUnpaidTask(Integer orderId){
        super("OrderUnpaidTask-" + orderId, SystemConfig.getOrderUnpaid() * 60 * 1000);
        this.orderId = orderId;
    }

    @Override
    public void run() {
        logger.info("系统开始处理延时任务---订单超时未付款---" + this.orderId);

        InternetmedicalOrderService orderService = BeanUtil.getBean(InternetmedicalOrderService.class);
        InternetmedicalOrderGoodsService orderGoodsService = BeanUtil.getBean(InternetmedicalOrderGoodsService.class);
        InternetmedicalGoodsProductService productService = BeanUtil.getBean(InternetmedicalGoodsProductService.class);
        WxOrderService wxOrderService = BeanUtil.getBean(WxOrderService.class);

        InternetmedicalOrder order = orderService.findById(this.orderId);
        if(order == null){
            return;
        }
        if(!OrderUtil.isCreateStatus(order)){
            return;
        }

        // 设置订单已取消状态
        order.setOrderStatus(OrderUtil.STATUS_AUTO_CANCEL);
        order.setEndTime(LocalDateTime.now());
        if (orderService.updateWithOptimisticLocker(order) == 0) {
            throw new RuntimeException("更新数据已失效");
        }

        // 商品货品数量增加
        Integer orderId = order.getId();
        List<InternetmedicalOrderGoods> orderGoodsList = orderGoodsService.queryByOid(orderId);
        for (InternetmedicalOrderGoods orderGoods : orderGoodsList) {
            Integer productId = orderGoods.getProductId();
            Short number = orderGoods.getNumber();
            if (productService.addStock(productId, number) == 0) {
                throw new RuntimeException("商品货品库存增加失败");
            }
        }

        //返还优惠券
        wxOrderService.releaseCoupon(orderId);

        logger.info("系统结束处理延时任务---订单超时未付款---" + this.orderId);
    }
}
