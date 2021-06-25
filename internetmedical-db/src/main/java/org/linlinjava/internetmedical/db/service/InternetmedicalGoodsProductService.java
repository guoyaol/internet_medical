package org.linlinjava.internetmedical.db.service;

import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.dao.GoodsProductMapper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalGoodsProductMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsProduct;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalGoodsProductService {
    @Resource
    private InternetmedicalGoodsProductMapper internetmedicalGoodsProductMapper;
    @Resource
    private GoodsProductMapper goodsProductMapper;

    public List<InternetmedicalGoodsProduct> queryByGid(Integer gid) {
        InternetmedicalGoodsProductExample example = new InternetmedicalGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return internetmedicalGoodsProductMapper.selectByExample(example);
    }

    public InternetmedicalGoodsProduct findById(Integer id) {
        return internetmedicalGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        internetmedicalGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(InternetmedicalGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        internetmedicalGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        InternetmedicalGoodsProductExample example = new InternetmedicalGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) internetmedicalGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        InternetmedicalGoodsProductExample example = new InternetmedicalGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        internetmedicalGoodsProductMapper.logicalDeleteByExample(example);
    }

    public int addStock(Integer id, Short num){
        return goodsProductMapper.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProductMapper.reduceStock(id, num);
    }

    public void updateById(InternetmedicalGoodsProduct product) {
        product.setUpdateTime(LocalDateTime.now());
        internetmedicalGoodsProductMapper.updateByPrimaryKeySelective(product);
    }
}