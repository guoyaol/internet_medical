package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGroupon;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGrouponExample;

public interface InternetmedicalGrouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int insert(InternetmedicalGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    InternetmedicalGroupon selectOneByExample(InternetmedicalGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    InternetmedicalGroupon selectOneByExampleSelective(@Param("example") InternetmedicalGrouponExample example, @Param("selective") InternetmedicalGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    List<InternetmedicalGroupon> selectByExampleSelective(@Param("example") InternetmedicalGrouponExample example, @Param("selective") InternetmedicalGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    List<InternetmedicalGroupon> selectByExample(InternetmedicalGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    InternetmedicalGroupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    InternetmedicalGroupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    InternetmedicalGroupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalGroupon record, @Param("example") InternetmedicalGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalGroupon record, @Param("example") InternetmedicalGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_groupon
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}