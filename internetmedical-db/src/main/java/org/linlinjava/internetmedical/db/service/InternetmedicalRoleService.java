package org.linlinjava.internetmedical.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalRoleMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRole;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRoleExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InternetmedicalRoleService {
    @Resource
    private InternetmedicalRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        InternetmedicalRoleExample example = new InternetmedicalRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<InternetmedicalRole> roleList = roleMapper.selectByExample(example);

        for(InternetmedicalRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<InternetmedicalRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        InternetmedicalRoleExample example = new InternetmedicalRoleExample();
        InternetmedicalRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public InternetmedicalRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(InternetmedicalRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(InternetmedicalRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        InternetmedicalRoleExample example = new InternetmedicalRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<InternetmedicalRole> queryAll() {
        InternetmedicalRoleExample example = new InternetmedicalRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
