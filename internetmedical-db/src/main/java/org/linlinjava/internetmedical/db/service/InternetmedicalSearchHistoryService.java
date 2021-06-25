package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalSearchHistoryMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalSearchHistory;
import org.linlinjava.internetmedical.db.domain.InternetmedicalSearchHistoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalSearchHistoryService {
    @Resource
    private InternetmedicalSearchHistoryMapper searchHistoryMapper;

    public void save(InternetmedicalSearchHistory searchHistory) {
        searchHistory.setAddTime(LocalDateTime.now());
        searchHistory.setUpdateTime(LocalDateTime.now());
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<InternetmedicalSearchHistory> queryByUid(int uid) {
        InternetmedicalSearchHistoryExample example = new InternetmedicalSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, InternetmedicalSearchHistory.Column.keyword);
    }

    public void deleteByUid(int uid) {
        InternetmedicalSearchHistoryExample example = new InternetmedicalSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }

    public List<InternetmedicalSearchHistory> querySelective(String userId, String keyword, Integer page, Integer size, String sort, String order) {
        InternetmedicalSearchHistoryExample example = new InternetmedicalSearchHistoryExample();
        InternetmedicalSearchHistoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return searchHistoryMapper.selectByExample(example);
    }
}
