package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalTopicMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGroupon;
import org.linlinjava.internetmedical.db.domain.InternetmedicalTopic;
import org.linlinjava.internetmedical.db.domain.InternetmedicalTopic.Column;
import org.linlinjava.internetmedical.db.domain.InternetmedicalTopicExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternetmedicalTopicService {
    @Resource
    private InternetmedicalTopicMapper topicMapper;
    private Column[] columns = new Column[]{Column.id, Column.title, Column.subtitle, Column.price, Column.picUrl, Column.readCount};

    public List<InternetmedicalTopic> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    public List<InternetmedicalTopic> queryList(int offset, int limit, String sort, String order) {
        InternetmedicalTopicExample example = new InternetmedicalTopicExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotal() {
        InternetmedicalTopicExample example = new InternetmedicalTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    public InternetmedicalTopic findById(Integer id) {
        InternetmedicalTopicExample example = new InternetmedicalTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<InternetmedicalTopic> queryRelatedList(Integer id, int offset, int limit) {
        InternetmedicalTopicExample example = new InternetmedicalTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<InternetmedicalTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit, "add_time", "desc");
        }
        InternetmedicalTopic topic = topics.get(0);

        example = new InternetmedicalTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<InternetmedicalTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit, "add_time", "desc");
    }

    public List<InternetmedicalTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        InternetmedicalTopicExample example = new InternetmedicalTopicExample();
        InternetmedicalTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int updateById(InternetmedicalTopic topic) {
        topic.setUpdateTime(LocalDateTime.now());
        InternetmedicalTopicExample example = new InternetmedicalTopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(InternetmedicalTopic topic) {
        topic.setAddTime(LocalDateTime.now());
        topic.setUpdateTime(LocalDateTime.now());
        topicMapper.insertSelective(topic);
    }


    public void deleteByIds(List<Integer> ids) {
        InternetmedicalTopicExample example = new InternetmedicalTopicExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        InternetmedicalTopic topic = new InternetmedicalTopic();
        topic.setUpdateTime(LocalDateTime.now());
        topic.setDeleted(true);
        topicMapper.updateByExampleSelective(topic, example);
    }
}
