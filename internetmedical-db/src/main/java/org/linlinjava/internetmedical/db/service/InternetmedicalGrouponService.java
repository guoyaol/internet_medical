package org.linlinjava.internetmedical.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalGrouponMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGroupon;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGrouponExample;
import org.linlinjava.internetmedical.db.util.GrouponConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalGrouponService {
    @Resource
    private InternetmedicalGrouponMapper mapper;

    /**
     * 获取用户发起的团购记录
     *
     * @param userId
     * @return
     */
    public List<InternetmedicalGroupon> queryMyGroupon(Integer userId) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andUserIdEqualTo(userId).andCreatorUserIdEqualTo(userId).andGrouponIdEqualTo(0).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 获取用户参与的团购记录
     *
     * @param userId
     * @return
     */
    public List<InternetmedicalGroupon> queryMyJoinGroupon(Integer userId) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andUserIdEqualTo(userId).andGrouponIdNotEqualTo(0).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据OrderId查询团购记录
     *
     * @param orderId
     * @return
     */
    public InternetmedicalGroupon queryByOrderId(Integer orderId) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 获取某个团购活动参与的记录
     *
     * @param id
     * @return
     */
    public List<InternetmedicalGroupon> queryJoinRecord(Integer id) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andGrouponIdEqualTo(id).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public InternetmedicalGroupon queryById(Integer id) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 根据ID查询记录
     *
     * @param userId
     * @param id
     * @return
     */
    public InternetmedicalGroupon queryById(Integer userId, Integer id) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 返回某个发起的团购参与人数
     *
     * @param grouponId
     * @return
     */
    public int countGroupon(Integer grouponId) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andGrouponIdEqualTo(grouponId).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        return (int) mapper.countByExample(example);
    }

    public boolean hasJoin(Integer userId, Integer grouponId) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andUserIdEqualTo(userId).andGrouponIdEqualTo(grouponId).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        return  mapper.countByExample(example) != 0;
    }

    public int updateById(InternetmedicalGroupon groupon) {
        groupon.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(groupon);
    }

    /**
     * 创建或参与一个团购
     *
     * @param groupon
     * @return
     */
    public int createGroupon(InternetmedicalGroupon groupon) {
        groupon.setAddTime(LocalDateTime.now());
        groupon.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(groupon);
    }


    /**
     * 查询所有发起的团购记录
     *
     * @param rulesId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<InternetmedicalGroupon> querySelective(String rulesId, Integer page, Integer size, String sort, String order) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        InternetmedicalGrouponExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(rulesId)) {
            criteria.andRulesIdEqualTo(Integer.parseInt(rulesId));
        }
        criteria.andDeletedEqualTo(false);
        criteria.andStatusNotEqualTo(GrouponConstant.STATUS_NONE);
        criteria.andGrouponIdEqualTo(0);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public List<InternetmedicalGroupon> queryByRuleId(int grouponRuleId) {
        InternetmedicalGrouponExample example = new InternetmedicalGrouponExample();
        example.or().andRulesIdEqualTo(grouponRuleId).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
