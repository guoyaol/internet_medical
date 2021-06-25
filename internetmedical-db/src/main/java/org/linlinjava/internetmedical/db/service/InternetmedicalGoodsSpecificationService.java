package org.linlinjava.internetmedical.db.service;

import org.linlinjava.internetmedical.db.dao.InternetmedicalGoodsSpecificationMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsSpecification;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsSpecificationExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InternetmedicalGoodsSpecificationService {
    @Resource
    private InternetmedicalGoodsSpecificationMapper goodsSpecificationMapper;

    public List<InternetmedicalGoodsSpecification> queryByGid(Integer id) {
        InternetmedicalGoodsSpecificationExample example = new InternetmedicalGoodsSpecificationExample();
        example.or().andGoodsIdEqualTo(id).andDeletedEqualTo(false);
        return goodsSpecificationMapper.selectByExample(example);
    }

    public InternetmedicalGoodsSpecification findById(Integer id) {
        return goodsSpecificationMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        InternetmedicalGoodsSpecificationExample example = new InternetmedicalGoodsSpecificationExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsSpecificationMapper.logicalDeleteByExample(example);
    }

    public void add(InternetmedicalGoodsSpecification goodsSpecification) {
        goodsSpecification.setAddTime(LocalDateTime.now());
        goodsSpecification.setUpdateTime(LocalDateTime.now());
        goodsSpecificationMapper.insertSelective(goodsSpecification);
    }

    /**
     * [
     * {
     * name: '',
     * valueList: [ {}, {}]
     * },
     * {
     * name: '',
     * valueList: [ {}, {}]
     * }
     * ]
     *
     * @param id
     * @return
     */
    public Object getSpecificationVoList(Integer id) {
        List<InternetmedicalGoodsSpecification> goodsSpecificationList = queryByGid(id);

        Map<String, VO> map = new HashMap<>();
        List<VO> specificationVoList = new ArrayList<>();

        for (InternetmedicalGoodsSpecification goodsSpecification : goodsSpecificationList) {
            String specification = goodsSpecification.getSpecification();
            VO goodsSpecificationVo = map.get(specification);
            if (goodsSpecificationVo == null) {
                goodsSpecificationVo = new VO();
                goodsSpecificationVo.setName(specification);
                List<InternetmedicalGoodsSpecification> valueList = new ArrayList<>();
                valueList.add(goodsSpecification);
                goodsSpecificationVo.setValueList(valueList);
                map.put(specification, goodsSpecificationVo);
                specificationVoList.add(goodsSpecificationVo);
            } else {
                List<InternetmedicalGoodsSpecification> valueList = goodsSpecificationVo.getValueList();
                valueList.add(goodsSpecification);
            }
        }

        return specificationVoList;
    }

    public void updateById(InternetmedicalGoodsSpecification specification) {
        specification.setUpdateTime(LocalDateTime.now());
        goodsSpecificationMapper.updateByPrimaryKeySelective(specification);
    }

    private class VO {
        private String name;
        private List<InternetmedicalGoodsSpecification> valueList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<InternetmedicalGoodsSpecification> getValueList() {
            return valueList;
        }

        public void setValueList(List<InternetmedicalGoodsSpecification> valueList) {
            this.valueList = valueList;
        }
    }

}
