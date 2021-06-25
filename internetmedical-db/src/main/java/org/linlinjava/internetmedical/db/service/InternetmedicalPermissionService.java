package org.linlinjava.internetmedical.db.service;

import org.linlinjava.internetmedical.db.dao.InternetmedicalPermissionMapper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalRoleMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalPermission;
import org.linlinjava.internetmedical.db.domain.InternetmedicalPermissionExample;
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
public class InternetmedicalPermissionService {
    @Resource
    private InternetmedicalPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if(roleIds.length == 0){
            return permissions;
        }

        InternetmedicalPermissionExample example = new InternetmedicalPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<InternetmedicalPermission> permissionList = permissionMapper.selectByExample(example);

        for(InternetmedicalPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if(roleId == null){
            return permissions;
        }

        InternetmedicalPermissionExample example = new InternetmedicalPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<InternetmedicalPermission> permissionList = permissionMapper.selectByExample(example);

        for(InternetmedicalPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        InternetmedicalPermissionExample example = new InternetmedicalPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        InternetmedicalPermissionExample example = new InternetmedicalPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(InternetmedicalPermission internetmedicalPermission) {
        internetmedicalPermission.setAddTime(LocalDateTime.now());
        internetmedicalPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(internetmedicalPermission);
    }
}
