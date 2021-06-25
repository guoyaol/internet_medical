package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRole;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRoleExample;

public interface InternetmedicalRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int insert(InternetmedicalRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    InternetmedicalRole selectOneByExample(InternetmedicalRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    InternetmedicalRole selectOneByExampleSelective(@Param("example") InternetmedicalRoleExample example, @Param("selective") InternetmedicalRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    List<InternetmedicalRole> selectByExampleSelective(@Param("example") InternetmedicalRoleExample example, @Param("selective") InternetmedicalRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    List<InternetmedicalRole> selectByExample(InternetmedicalRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    InternetmedicalRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    InternetmedicalRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    InternetmedicalRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalRole record, @Param("example") InternetmedicalRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalRole record, @Param("example") InternetmedicalRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_role
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}