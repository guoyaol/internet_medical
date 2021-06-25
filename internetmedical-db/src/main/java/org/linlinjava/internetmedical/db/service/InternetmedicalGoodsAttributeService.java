package org.linlinjava.internetmedical.db.service;

import org.linlinjava.internetmedical.db.dao.InternetmedicalGoodsAttributeMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsAttribute;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalGoodsAttributeService {
    @Resource
    private InternetmedicalGoodsAttributeMapper goodsAttributeMapper;

    public List<InternetmedicalGoodsAttribute> queryByGid(Integer goodsId) {
        InternetmedicalGoodsAttributeExample example = new InternetmedicalGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(InternetmedicalGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public InternetmedicalGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        InternetmedicalGoodsAttributeExample example = new InternetmedicalGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }

    public void deleteById(Integer id) {
        goodsAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(InternetmedicalGoodsAttribute attribute) {
        attribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.updateByPrimaryKeySelective(attribute);
    }
}
