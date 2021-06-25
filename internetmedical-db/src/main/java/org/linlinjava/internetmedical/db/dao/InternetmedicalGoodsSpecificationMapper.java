package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsSpecification;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsSpecificationExample;

public interface InternetmedicalGoodsSpecificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int insert(InternetmedicalGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    InternetmedicalGoodsSpecification selectOneByExample(InternetmedicalGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    InternetmedicalGoodsSpecification selectOneByExampleSelective(@Param("example") InternetmedicalGoodsSpecificationExample example, @Param("selective") InternetmedicalGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    List<InternetmedicalGoodsSpecification> selectByExampleSelective(@Param("example") InternetmedicalGoodsSpecificationExample example, @Param("selective") InternetmedicalGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    List<InternetmedicalGoodsSpecification> selectByExample(InternetmedicalGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    InternetmedicalGoodsSpecification selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    InternetmedicalGoodsSpecification selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    InternetmedicalGoodsSpecification selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalGoodsSpecification record, @Param("example") InternetmedicalGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalGoodsSpecification record, @Param("example") InternetmedicalGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_specification
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}