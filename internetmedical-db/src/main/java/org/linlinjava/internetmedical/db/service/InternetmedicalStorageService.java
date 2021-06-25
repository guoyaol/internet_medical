package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalStorageMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalStorage;
import org.linlinjava.internetmedical.db.domain.InternetmedicalStorageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalStorageService {
    @Autowired
    private InternetmedicalStorageMapper storageMapper;

    public void deleteByKey(String key) {
        InternetmedicalStorageExample example = new InternetmedicalStorageExample();
        example.or().andKeyEqualTo(key);
        storageMapper.logicalDeleteByExample(example);
    }

    public void add(InternetmedicalStorage storageInfo) {
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        storageMapper.insertSelective(storageInfo);
    }

    public InternetmedicalStorage findByKey(String key) {
        InternetmedicalStorageExample example = new InternetmedicalStorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return storageMapper.selectOneByExample(example);
    }

    public int update(InternetmedicalStorage storageInfo) {
        storageInfo.setUpdateTime(LocalDateTime.now());
        return storageMapper.updateByPrimaryKeySelective(storageInfo);
    }

    public InternetmedicalStorage findById(Integer id) {
        return storageMapper.selectByPrimaryKey(id);
    }

    public List<InternetmedicalStorage> querySelective(String key, String name, Integer page, Integer limit, String sort, String order) {
        InternetmedicalStorageExample example = new InternetmedicalStorageExample();
        InternetmedicalStorageExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(key)) {
            criteria.andKeyEqualTo(key);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return storageMapper.selectByExample(example);
    }
}
