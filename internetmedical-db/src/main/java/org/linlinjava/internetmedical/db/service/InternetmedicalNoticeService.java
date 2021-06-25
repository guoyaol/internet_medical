package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalNoticeMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalNotice;
import org.linlinjava.internetmedical.db.domain.InternetmedicalNoticeAdmin;
import org.linlinjava.internetmedical.db.domain.InternetmedicalNoticeAdminExample;
import org.linlinjava.internetmedical.db.domain.InternetmedicalNoticeExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalNoticeService {
    @Resource
    private InternetmedicalNoticeMapper noticeMapper;


    public List<InternetmedicalNotice> querySelective(String title, String content, Integer page, Integer limit, String sort, String order) {
        InternetmedicalNoticeExample example = new InternetmedicalNoticeExample();
        InternetmedicalNoticeExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return noticeMapper.selectByExample(example);
    }

    public int updateById(InternetmedicalNotice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public void deleteById(Integer id) {
        noticeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(InternetmedicalNotice notice) {
        notice.setAddTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        noticeMapper.insertSelective(notice);
    }

    public InternetmedicalNotice findById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    public void deleteByIds(List<Integer> ids) {
        InternetmedicalNoticeExample example = new InternetmedicalNoticeExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        InternetmedicalNotice notice = new InternetmedicalNotice();
        notice.setUpdateTime(LocalDateTime.now());
        notice.setDeleted(true);
        noticeMapper.updateByExampleSelective(notice, example);
    }
}
