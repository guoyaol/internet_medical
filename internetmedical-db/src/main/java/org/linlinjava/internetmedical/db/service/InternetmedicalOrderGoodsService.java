package org.linlinjava.internetmedical.db.service;

import org.linlinjava.internetmedical.db.dao.InternetmedicalOrderGoodsMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalOrderGoods;
import org.linlinjava.internetmedical.db.domain.InternetmedicalOrderGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalOrderGoodsService {
    @Resource
    private InternetmedicalOrderGoodsMapper orderGoodsMapper;

    public int add(InternetmedicalOrderGoods orderGoods) {
        orderGoods.setAddTime(LocalDateTime.now());
        orderGoods.setUpdateTime(LocalDateTime.now());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<InternetmedicalOrderGoods> queryByOid(Integer orderId) {
        InternetmedicalOrderGoodsExample example = new InternetmedicalOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<InternetmedicalOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        InternetmedicalOrderGoodsExample example = new InternetmedicalOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public InternetmedicalOrderGoods findById(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    public void updateById(InternetmedicalOrderGoods orderGoods) {
        orderGoods.setUpdateTime(LocalDateTime.now());
        orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public Short getComments(Integer orderId) {
        InternetmedicalOrderGoodsExample example = new InternetmedicalOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        long count = orderGoodsMapper.countByExample(example);
        return (short) count;
    }

    public boolean checkExist(Integer goodsId) {
        InternetmedicalOrderGoodsExample example = new InternetmedicalOrderGoodsExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.countByExample(example) != 0;
    }

    public void deleteByOrderId(Integer orderId) {
        InternetmedicalOrderGoodsExample example = new InternetmedicalOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        orderGoodsMapper.logicalDeleteByExample(example);
    }
}
