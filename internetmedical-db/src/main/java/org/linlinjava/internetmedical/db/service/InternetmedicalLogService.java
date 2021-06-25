package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalLogMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalAd;
import org.linlinjava.internetmedical.db.domain.InternetmedicalLog;
import org.linlinjava.internetmedical.db.domain.InternetmedicalLogExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalLogService {
    @Resource
    private InternetmedicalLogMapper logMapper;

    public void deleteById(Integer id) {
        logMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(InternetmedicalLog log) {
        log.setAddTime(LocalDateTime.now());
        log.setUpdateTime(LocalDateTime.now());
        logMapper.insertSelective(log);
    }

    public List<InternetmedicalLog> querySelective(String name, Integer page, Integer size, String sort, String order) {
        InternetmedicalLogExample example = new InternetmedicalLogExample();
        InternetmedicalLogExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andAdminLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return logMapper.selectByExample(example);
    }
}
