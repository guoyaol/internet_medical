package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalAdMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalAd;
import org.linlinjava.internetmedical.db.domain.InternetmedicalAdExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalAdService {
    @Resource
    private InternetmedicalAdMapper adMapper;

    public List<InternetmedicalAd> queryIndex() {
        InternetmedicalAdExample example = new InternetmedicalAdExample();
        example.or().andPositionEqualTo((byte) 1).andDeletedEqualTo(false).andEnabledEqualTo(true);
        return adMapper.selectByExample(example);
    }

    public List<InternetmedicalAd> querySelective(String name, String content, Integer page, Integer limit, String sort, String order) {
        InternetmedicalAdExample example = new InternetmedicalAdExample();
        InternetmedicalAdExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adMapper.selectByExample(example);
    }

    public int updateById(InternetmedicalAd ad) {
        ad.setUpdateTime(LocalDateTime.now());
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    public void deleteById(Integer id) {
        adMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(InternetmedicalAd ad) {
        ad.setAddTime(LocalDateTime.now());
        ad.setUpdateTime(LocalDateTime.now());
        adMapper.insertSelective(ad);
    }

    public InternetmedicalAd findById(Integer id) {
        return adMapper.selectByPrimaryKey(id);
    }
}
