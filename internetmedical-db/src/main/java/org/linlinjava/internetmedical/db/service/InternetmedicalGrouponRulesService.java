package org.linlinjava.internetmedical.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalGoodsMapper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalGrouponRulesMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoods;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGrouponRules;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGrouponRulesExample;
import org.linlinjava.internetmedical.db.util.GrouponConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InternetmedicalGrouponRulesService {
    @Resource
    private InternetmedicalGrouponRulesMapper mapper;
    @Resource
    private InternetmedicalGoodsMapper goodsMapper;
    private InternetmedicalGoods.Column[] goodsColumns = new InternetmedicalGoods.Column[]{InternetmedicalGoods.Column.id, InternetmedicalGoods.Column.name, InternetmedicalGoods.Column.brief, InternetmedicalGoods.Column.picUrl, InternetmedicalGoods.Column.counterPrice, InternetmedicalGoods.Column.retailPrice};

    public int createRules(InternetmedicalGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public InternetmedicalGrouponRules findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<InternetmedicalGrouponRules> queryByGoodsId(Integer goodsId) {
        InternetmedicalGrouponRulesExample example = new InternetmedicalGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    public int countByGoodsId(Integer goodsId) {
        InternetmedicalGrouponRulesExample example = new InternetmedicalGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return (int)mapper.countByExample(example);
    }

    public List<InternetmedicalGrouponRules> queryByStatus(Short status) {
        InternetmedicalGrouponRulesExample example = new InternetmedicalGrouponRulesExample();
        example.or().andStatusEqualTo(status).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购规则列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<InternetmedicalGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<InternetmedicalGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        InternetmedicalGrouponRulesExample example = new InternetmedicalGrouponRulesExample();
        example.or().andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购规则是否已经过期
     *
     * @return
     */
    public boolean isExpired(InternetmedicalGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购规则列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<InternetmedicalGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        InternetmedicalGrouponRulesExample example = new InternetmedicalGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        InternetmedicalGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(InternetmedicalGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}