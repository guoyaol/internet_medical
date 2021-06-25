package org.linlinjava.internetmedical.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.internetmedical.db.dao.InternetmedicalRegionMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRegion;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRegionExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InternetmedicalRegionService {

    @Resource
    private InternetmedicalRegionMapper regionMapper;

    public List<InternetmedicalRegion> getAll(){
        InternetmedicalRegionExample example = new InternetmedicalRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<InternetmedicalRegion> queryByPid(Integer parentId) {
        InternetmedicalRegionExample example = new InternetmedicalRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public InternetmedicalRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public List<InternetmedicalRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        InternetmedicalRegionExample example = new InternetmedicalRegionExample();
        InternetmedicalRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}
