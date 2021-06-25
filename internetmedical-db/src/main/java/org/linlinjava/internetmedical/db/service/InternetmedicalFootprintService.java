package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalFootprintMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalFootprint;
import org.linlinjava.internetmedical.db.domain.InternetmedicalFootprintExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalFootprintService {
    @Resource
    private InternetmedicalFootprintMapper footprintMapper;

    public List<InternetmedicalFootprint> queryByAddTime(Integer userId, Integer page, Integer size) {
        InternetmedicalFootprintExample example = new InternetmedicalFootprintExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        example.setOrderByClause(InternetmedicalFootprint.Column.addTime.desc());
        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }

    public InternetmedicalFootprint findById(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    public InternetmedicalFootprint findById(Integer userId, Integer id) {
        InternetmedicalFootprintExample example = new InternetmedicalFootprintExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return footprintMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        footprintMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(InternetmedicalFootprint footprint) {
        footprint.setAddTime(LocalDateTime.now());
        footprint.setUpdateTime(LocalDateTime.now());
        footprintMapper.insertSelective(footprint);
    }

    public List<InternetmedicalFootprint> querySelective(String userId, String goodsId, Integer page, Integer size, String sort, String order) {
        InternetmedicalFootprintExample example = new InternetmedicalFootprintExample();
        InternetmedicalFootprintExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }
}
