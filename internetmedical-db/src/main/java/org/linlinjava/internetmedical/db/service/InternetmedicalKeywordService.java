package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalKeywordMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalKeyword;
import org.linlinjava.internetmedical.db.domain.InternetmedicalKeywordExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalKeywordService {
    @Resource
    private InternetmedicalKeywordMapper keywordsMapper;

    public InternetmedicalKeyword queryDefault() {
        InternetmedicalKeywordExample example = new InternetmedicalKeywordExample();
        example.or().andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return keywordsMapper.selectOneByExample(example);
    }

    public List<InternetmedicalKeyword> queryHots() {
        InternetmedicalKeywordExample example = new InternetmedicalKeywordExample();
        example.or().andIsHotEqualTo(true).andDeletedEqualTo(false);
        return keywordsMapper.selectByExample(example);
    }

    public List<InternetmedicalKeyword> queryByKeyword(String keyword, Integer page, Integer limit) {
        InternetmedicalKeywordExample example = new InternetmedicalKeywordExample();
        example.setDistinct(true);
        example.or().andKeywordLike("%" + keyword + "%").andDeletedEqualTo(false);
        PageHelper.startPage(page, limit);
        return keywordsMapper.selectByExampleSelective(example, InternetmedicalKeyword.Column.keyword);
    }

    public List<InternetmedicalKeyword> querySelective(String keyword, String url, Integer page, Integer limit, String sort, String order) {
        InternetmedicalKeywordExample example = new InternetmedicalKeywordExample();
        InternetmedicalKeywordExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        if (!StringUtils.isEmpty(url)) {
            criteria.andUrlLike("%" + url + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return keywordsMapper.selectByExample(example);
    }

    public void add(InternetmedicalKeyword keywords) {
        keywords.setAddTime(LocalDateTime.now());
        keywords.setUpdateTime(LocalDateTime.now());
        keywordsMapper.insertSelective(keywords);
    }

    public InternetmedicalKeyword findById(Integer id) {
        return keywordsMapper.selectByPrimaryKey(id);
    }

    public int updateById(InternetmedicalKeyword keywords) {
        keywords.setUpdateTime(LocalDateTime.now());
        return keywordsMapper.updateByPrimaryKeySelective(keywords);
    }

    public void deleteById(Integer id) {
        keywordsMapper.logicalDeleteByPrimaryKey(id);
    }
}
