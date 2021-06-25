package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalAddressMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalAddress;
import org.linlinjava.internetmedical.db.domain.InternetmedicalAddressExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalAddressService {
    @Resource
    private InternetmedicalAddressMapper addressMapper;

    public List<InternetmedicalAddress> queryByUid(Integer uid) {
        InternetmedicalAddressExample example = new InternetmedicalAddressExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        return addressMapper.selectByExample(example);
    }

    public InternetmedicalAddress query(Integer userId, Integer id) {
        InternetmedicalAddressExample example = new InternetmedicalAddressExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public int add(InternetmedicalAddress address) {
        address.setAddTime(LocalDateTime.now());
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.insertSelective(address);
    }

    public int update(InternetmedicalAddress address) {
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public void delete(Integer id) {
        addressMapper.logicalDeleteByPrimaryKey(id);
    }

    public InternetmedicalAddress findDefault(Integer userId) {
        InternetmedicalAddressExample example = new InternetmedicalAddressExample();
        example.or().andUserIdEqualTo(userId).andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public void resetDefault(Integer userId) {
        InternetmedicalAddress address = new InternetmedicalAddress();
        address.setIsDefault(false);
        address.setUpdateTime(LocalDateTime.now());
        InternetmedicalAddressExample example = new InternetmedicalAddressExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        addressMapper.updateByExampleSelective(address, example);
    }

    public List<InternetmedicalAddress> querySelective(Integer userId, String name, Integer page, Integer limit, String sort, String order) {
        InternetmedicalAddressExample example = new InternetmedicalAddressExample();
        InternetmedicalAddressExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return addressMapper.selectByExample(example);
    }
}
