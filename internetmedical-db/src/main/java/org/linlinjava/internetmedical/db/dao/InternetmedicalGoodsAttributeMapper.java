package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsAttribute;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsAttributeExample;

public interface InternetmedicalGoodsAttributeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int insert(InternetmedicalGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    InternetmedicalGoodsAttribute selectOneByExample(InternetmedicalGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    InternetmedicalGoodsAttribute selectOneByExampleSelective(@Param("example") InternetmedicalGoodsAttributeExample example, @Param("selective") InternetmedicalGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    List<InternetmedicalGoodsAttribute> selectByExampleSelective(@Param("example") InternetmedicalGoodsAttributeExample example, @Param("selective") InternetmedicalGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    List<InternetmedicalGoodsAttribute> selectByExample(InternetmedicalGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    InternetmedicalGoodsAttribute selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    InternetmedicalGoodsAttribute selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    InternetmedicalGoodsAttribute selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalGoodsAttribute record, @Param("example") InternetmedicalGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalGoodsAttribute record, @Param("example") InternetmedicalGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods_attribute
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}