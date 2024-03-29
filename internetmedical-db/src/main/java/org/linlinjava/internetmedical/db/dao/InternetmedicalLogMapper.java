package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalLog;
import org.linlinjava.internetmedical.db.domain.InternetmedicalLogExample;

public interface InternetmedicalLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int insert(InternetmedicalLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    InternetmedicalLog selectOneByExample(InternetmedicalLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    InternetmedicalLog selectOneByExampleSelective(@Param("example") InternetmedicalLogExample example, @Param("selective") InternetmedicalLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    List<InternetmedicalLog> selectByExampleSelective(@Param("example") InternetmedicalLogExample example, @Param("selective") InternetmedicalLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    List<InternetmedicalLog> selectByExample(InternetmedicalLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    InternetmedicalLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    InternetmedicalLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    InternetmedicalLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalLog record, @Param("example") InternetmedicalLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalLog record, @Param("example") InternetmedicalLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_log
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}