package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalAftersale;
import org.linlinjava.internetmedical.db.domain.InternetmedicalAftersaleExample;

public interface InternetmedicalAftersaleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int insert(InternetmedicalAftersale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalAftersale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    InternetmedicalAftersale selectOneByExample(InternetmedicalAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    InternetmedicalAftersale selectOneByExampleSelective(@Param("example") InternetmedicalAftersaleExample example, @Param("selective") InternetmedicalAftersale.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    List<InternetmedicalAftersale> selectByExampleSelective(@Param("example") InternetmedicalAftersaleExample example, @Param("selective") InternetmedicalAftersale.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    List<InternetmedicalAftersale> selectByExample(InternetmedicalAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    InternetmedicalAftersale selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalAftersale.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    InternetmedicalAftersale selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    InternetmedicalAftersale selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalAftersale record, @Param("example") InternetmedicalAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalAftersale record, @Param("example") InternetmedicalAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalAftersale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalAftersale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_aftersale
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}