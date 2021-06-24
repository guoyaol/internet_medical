package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallDoctors;
import org.linlinjava.litemall.db.domain.LitemallDoctorsExample;

public interface LitemallDoctorsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    long countByExample(LitemallDoctorsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallDoctorsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int insert(LitemallDoctors record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int insertSelective(LitemallDoctors record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    LitemallDoctors selectOneByExample(LitemallDoctorsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    LitemallDoctors selectOneByExampleSelective(@Param("example") LitemallDoctorsExample example, @Param("selective") LitemallDoctors.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    List<LitemallDoctors> selectByExampleSelective(@Param("example") LitemallDoctorsExample example, @Param("selective") LitemallDoctors.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    List<LitemallDoctors> selectByExample(LitemallDoctorsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    LitemallDoctors selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallDoctors.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    LitemallDoctors selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    LitemallDoctors selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallDoctors record, @Param("example") LitemallDoctorsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallDoctors record, @Param("example") LitemallDoctorsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallDoctors record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallDoctors record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallDoctorsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_doctors
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}