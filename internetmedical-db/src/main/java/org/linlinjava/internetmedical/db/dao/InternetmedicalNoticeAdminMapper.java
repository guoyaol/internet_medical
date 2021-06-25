package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalNoticeAdmin;
import org.linlinjava.internetmedical.db.domain.InternetmedicalNoticeAdminExample;

public interface InternetmedicalNoticeAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int insert(InternetmedicalNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    InternetmedicalNoticeAdmin selectOneByExample(InternetmedicalNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    InternetmedicalNoticeAdmin selectOneByExampleSelective(@Param("example") InternetmedicalNoticeAdminExample example, @Param("selective") InternetmedicalNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    List<InternetmedicalNoticeAdmin> selectByExampleSelective(@Param("example") InternetmedicalNoticeAdminExample example, @Param("selective") InternetmedicalNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    List<InternetmedicalNoticeAdmin> selectByExample(InternetmedicalNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    InternetmedicalNoticeAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    InternetmedicalNoticeAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    InternetmedicalNoticeAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalNoticeAdmin record, @Param("example") InternetmedicalNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalNoticeAdmin record, @Param("example") InternetmedicalNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_notice_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}