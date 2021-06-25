package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalUserMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalUser;
import org.linlinjava.internetmedical.db.domain.InternetmedicalUserExample;
import org.linlinjava.internetmedical.db.domain.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.linlinjava.internetmedical.db.dao.InternetmedicalPatientinfoMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalPatientinfo;
import org.linlinjava.internetmedical.db.domain.InternetmedicalPatientinfoExample;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalUserService {
    @Resource
    private InternetmedicalUserMapper userMapper;
    private InternetmedicalPatientinfoMapper patientinfoMapper;

    //用于获取患者信息，可以考虑更改前端的json格式。嵌套的records可能比较困难
    public InternetmedicalPatientinfo findpatientinfo(Integer userId)
    {
        InternetmedicalPatientinfoExample example = new InternetmedicalPatientinfoExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return patientinfoMapper.selectOneByExample(example);
    }

    public InternetmedicalUser findById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public UserVo findUserVoById(Integer userId) {
        InternetmedicalUser user = findById(userId);
        UserVo userVo = new UserVo();
        userVo.setNickname(user.getNickname());
        userVo.setAvatar(user.getAvatar());
        return userVo;
    }

    public InternetmedicalUser queryByOid(String openId) {
        InternetmedicalUserExample example = new InternetmedicalUserExample();
        example.or().andWeixinOpenidEqualTo(openId).andDeletedEqualTo(false);
        return userMapper.selectOneByExample(example);
    }

    public void add(InternetmedicalUser user) {
        user.setAddTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insertSelective(user);
    }

    public int updateById(InternetmedicalUser user) {
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<InternetmedicalUser> querySelective(String username, String mobile, Integer page, Integer size, String sort, String order) {
        InternetmedicalUserExample example = new InternetmedicalUserExample();
        InternetmedicalUserExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        if (!StringUtils.isEmpty(mobile)) {
            criteria.andMobileEqualTo(mobile);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return userMapper.selectByExample(example);
    }

    public int count() {
        InternetmedicalUserExample example = new InternetmedicalUserExample();
        example.or().andDeletedEqualTo(false);

        return (int) userMapper.countByExample(example);
    }

    public List<InternetmedicalUser> queryByUsername(String username) {
        InternetmedicalUserExample example = new InternetmedicalUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public boolean checkByUsername(String username) {
        InternetmedicalUserExample example = new InternetmedicalUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return userMapper.countByExample(example) != 0;
    }

    public List<InternetmedicalUser> queryByMobile(String mobile) {
        InternetmedicalUserExample example = new InternetmedicalUserExample();
        example.or().andMobileEqualTo(mobile).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public List<InternetmedicalUser> queryByOpenid(String openid) {
        InternetmedicalUserExample example = new InternetmedicalUserExample();
        example.or().andWeixinOpenidEqualTo(openid).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        userMapper.logicalDeleteByPrimaryKey(id);
    }
}
