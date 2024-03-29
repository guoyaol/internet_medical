package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalBrandMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalBrand;
import org.linlinjava.internetmedical.db.domain.InternetmedicalBrand.Column;
import org.linlinjava.internetmedical.db.domain.InternetmedicalBrandExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalBrandService {
    @Resource
    private InternetmedicalBrandMapper brandMapper;
    private Column[] columns = new Column[]{Column.id, Column.name, Column.desc, Column.picUrl, Column.floorPrice};

    public List<InternetmedicalBrand> query(Integer page, Integer limit, String sort, String order) {
        InternetmedicalBrandExample example = new InternetmedicalBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public List<InternetmedicalBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public InternetmedicalBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public List<InternetmedicalBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        InternetmedicalBrandExample example = new InternetmedicalBrandExample();
        InternetmedicalBrandExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return brandMapper.selectByExample(example);
    }

    public int updateById(InternetmedicalBrand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(InternetmedicalBrand brand) {
        brand.setAddTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insertSelective(brand);
    }

    public List<InternetmedicalBrand> all() {
        InternetmedicalBrandExample example = new InternetmedicalBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }
}
