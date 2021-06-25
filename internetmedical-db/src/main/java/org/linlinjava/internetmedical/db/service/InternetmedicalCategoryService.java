package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalCategoryMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCategory;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCategoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalCategoryService {
    @Resource
    private InternetmedicalCategoryMapper categoryMapper;
    private InternetmedicalCategory.Column[] CHANNEL = {InternetmedicalCategory.Column.id, InternetmedicalCategory.Column.name, InternetmedicalCategory.Column.iconUrl};

    public List<InternetmedicalCategory> queryL1WithoutRecommend(int offset, int limit) {
        InternetmedicalCategoryExample example = new InternetmedicalCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<InternetmedicalCategory> queryL1(int offset, int limit) {
        InternetmedicalCategoryExample example = new InternetmedicalCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<InternetmedicalCategory> queryL1() {
        InternetmedicalCategoryExample example = new InternetmedicalCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<InternetmedicalCategory> queryByPid(Integer pid) {
        InternetmedicalCategoryExample example = new InternetmedicalCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<InternetmedicalCategory> queryL2ByIds(List<Integer> ids) {
        InternetmedicalCategoryExample example = new InternetmedicalCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public InternetmedicalCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<InternetmedicalCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        InternetmedicalCategoryExample example = new InternetmedicalCategoryExample();
        InternetmedicalCategoryExample.Criteria criteria = example.createCriteria();

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
        return categoryMapper.selectByExample(example);
    }

    public int updateById(InternetmedicalCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(InternetmedicalCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<InternetmedicalCategory> queryChannel() {
        InternetmedicalCategoryExample example = new InternetmedicalCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
