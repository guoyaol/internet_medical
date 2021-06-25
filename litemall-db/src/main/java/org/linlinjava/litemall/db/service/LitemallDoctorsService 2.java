package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.LitemallDoctorsMapper;
import org.linlinjava.litemall.db.domain.LitemallDoctors;
import org.linlinjava.litemall.db.domain.LitemallDoctorsExample;
import org.linlinjava.litemall.db.domain.DoctorsVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallDoctorsService {
    @Resource
    private LitemallDoctorsMapper doctorsMapper;

    public LitemallDoctors findById(Integer Id) {
        return doctorsMapper.selectByPrimaryKey(Id);
    }

    //资质审核
    public void qualify(Integer Id)
    {
        LitemallDoctors doc = findById(Id);
        doc.setQualification(true);
    }

    //失去资质
    public void Unqualify(Integer Id)
    {
        LitemallDoctors doc = findById(Id);
        doc.setQualification(false);
    }

    
    public DoctorsVo findDoctorsVoById(Integer Id) {
        LitemallDoctors doc = findById(Id);
        DoctorsVo docVo = new DoctorsVo();
        docVo.setName(doc.getName());
        docVo.setAvatar(doc.getAvatar());
        return docVo;
    }


    public void add(LitemallDoctors doc) {
        doc.setAddTime(LocalDateTime.now());
        doc.setUpdateTime(LocalDateTime.now());
        doctorsMapper.insertSelective(doc);
    }

    public int updateById(LitemallDoctors doc) {
        doc.setUpdateTime(LocalDateTime.now());
        return doctorsMapper.updateByPrimaryKeySelective(doc);
    }

    public List<LitemallDoctors> querySelective(String name, String mobile, Integer page, Integer size, String sort, String order) {
        LitemallDoctorsExample example = new LitemallDoctorsExample();
        LitemallDoctorsExample.Criteria criteria = example.createCriteria();

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
        LitemallDoctorsExample example = new LitemallDoctorsExample();
        example.or().andDeletedEqualTo(false);

        return (int) doctorsMapper.countByExample(example);
    }

    public List<LitemallDoctors> queryByName(String name) {
        LitemallDoctorsExample example = new LitemallDoctorsExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return doctorsMapper.selectByExample(example);
    }

    public boolean checkByName(String name) {
        LitemallDoctorsExample example = new LitemallDoctorsExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return doctorsMapper.countByExample(example) != 0;
    }

    public List<LitemallDoctors> queryByMobile(String mobile) {
        LitemallDoctorsExample example = new LitemallDoctorsExample();
        example.or().andMobileEqualTo(mobile).andDeletedEqualTo(false);
        return doctorsMapper.selectByExample(example);
    }

    /*
    public List<LitemallDoctors> queryByOpenid(String openid) {
        LitemallDoctorsExample example = new LitemallDoctorsExample();
        example.or().andWeixinOpenidEqualTo(openid).andDeletedEqualTo(false);
        return doctorsMapper.selectByExample(example);
    }*/

    public void deleteById(Integer id) {
        doctorsMapper.logicalDeleteByPrimaryKey(id);
    }
}