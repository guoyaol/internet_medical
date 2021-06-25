package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalCommentMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalComment;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCommentExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalCommentService {
    @Resource
    private InternetmedicalCommentMapper commentMapper;

    public List<InternetmedicalComment> queryGoodsByGid(Integer id, int offset, int limit) {
        InternetmedicalCommentExample example = new InternetmedicalCommentExample();
        example.setOrderByClause(InternetmedicalComment.Column.addTime.desc());
        example.or().andValueIdEqualTo(id).andTypeEqualTo((byte) 0).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public List<InternetmedicalComment> query(Byte type, Integer valueId, Integer showType, Integer offset, Integer limit) {
        InternetmedicalCommentExample example = new InternetmedicalCommentExample();
        example.setOrderByClause(InternetmedicalComment.Column.addTime.desc());
        if (showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        } else if (showType == 1) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        } else {
            throw new RuntimeException("showType不支持");
        }
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public int count(Byte type, Integer valueId, Integer showType) {
        InternetmedicalCommentExample example = new InternetmedicalCommentExample();
        if (showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        } else if (showType == 1) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        } else {
            throw new RuntimeException("showType不支持");
        }
        return (int) commentMapper.countByExample(example);
    }

    public int save(InternetmedicalComment comment) {
        comment.setAddTime(LocalDateTime.now());
        comment.setUpdateTime(LocalDateTime.now());
        return commentMapper.insertSelective(comment);
    }

    public List<InternetmedicalComment> querySelective(String userId, String valueId, Integer page, Integer size, String sort, String order) {
        InternetmedicalCommentExample example = new InternetmedicalCommentExample();
        InternetmedicalCommentExample.Criteria criteria = example.createCriteria();

        // type=2 是订单商品回复，这里过滤
        criteria.andTypeNotEqualTo((byte) 2);

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(valueId)) {
            criteria.andValueIdEqualTo(Integer.valueOf(valueId)).andTypeEqualTo((byte) 0);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return commentMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        commentMapper.logicalDeleteByPrimaryKey(id);
    }

    public InternetmedicalComment findById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    public int updateById(InternetmedicalComment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }
}
