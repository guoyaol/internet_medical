package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalDoctorsMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalDoctors;
import org.linlinjava.internetmedical.db.domain.InternetmedicalDoctorsExample;
import org.linlinjava.internetmedical.db.domain.DoctorsVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalDoctorsService {
    @Resource
    private InternetmedicalDoctorsMapper doctorsMapper;

    public InternetmedicalDoctors findById(Integer Id) {
        return doctorsMapper.selectByPrimaryKey(Id);
    }

    //资质审核
    public void qualify(Integer Id)
    {
        InternetmedicalDoctors doc = findById(Id);
        doc.setQualification(true);
    }

    //失去资质
    public void Unqualify(Integer Id)
    {
        InternetmedicalDoctors doc = findById(Id);
        doc.setQualification(false);
    }

    
    public DoctorsVo findDoctorsVoById(Integer Id) {
        InternetmedicalDoctors doc = findById(Id);
        DoctorsVo docVo = new DoctorsVo();
        docVo.setName(doc.getName());
        docVo.setAvatar(doc.getAvatar());
        return docVo;
    }


    public void add(InternetmedicalDoctors doc) {
        doc.setAddTime(LocalDateTime.now());
        doc.setUpdateTime(LocalDateTime.now());
        doctorsMapper.insertSelective(doc);
    }

    public int updateById(InternetmedicalDoctors doc) {
        doc.setUpdateTime(LocalDateTime.now());
        return doctorsMapper.updateByPrimaryKeySelective(doc);
    }

    public List<InternetmedicalDoctors> querySelective(String name, String mobile, Integer page, Integer size, String sort, String order) {
        InternetmedicalDoctorsExample example = new InternetmedicalDoctorsExample();
        InternetmedicalDoctorsExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(mobile)) {
            criteria.andMobileEqualTo(mobile);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return doctorsMapper.selectByExample(example);
    }

    public int count() {
        InternetmedicalDoctorsExample example = new InternetmedicalDoctorsExample();
        example.or().andDeletedEqualTo(false);

        return (int) doctorsMapper.countByExample(example);
    }

    public List<InternetmedicalDoctors> queryByName(String name) {
        InternetmedicalDoctorsExample example = new InternetmedicalDoctorsExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return doctorsMapper.selectByExample(example);
    }

    public boolean checkByName(String name) {
        InternetmedicalDoctorsExample example = new InternetmedicalDoctorsExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return doctorsMapper.countByExample(example) != 0;
    }

    public List<InternetmedicalDoctors> queryByMobile(String mobile) {
        InternetmedicalDoctorsExample example = new InternetmedicalDoctorsExample();
        example.or().andMobileEqualTo(mobile).andDeletedEqualTo(false);
        return doctorsMapper.selectByExample(example);
    }

    /*
    public List<InternetmedicalDoctors> queryByOpenid(String openid) {
        InternetmedicalDoctorsExample example = new InternetmedicalDoctorsExample();
        example.or().andWeixinOpenidEqualTo(openid).andDeletedEqualTo(false);
        return doctorsMapper.selectByExample(example);
    }*/

    public void deleteById(Integer id) {
        doctorsMapper.logicalDeleteByPrimaryKey(id);
    }
}