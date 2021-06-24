package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallPatientinfo;
import org.linlinjava.litemall.db.domain.LitemallPatientinfoExample;

public interface LitemallPatientinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    long countByExample(LitemallPatientinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallPatientinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int insert(LitemallPatientinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int insertSelective(LitemallPatientinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    LitemallPatientinfo selectOneByExample(LitemallPatientinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    LitemallPatientinfo selectOneByExampleSelective(@Param("example") LitemallPatientinfoExample example, @Param("selective") LitemallPatientinfo.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    List<LitemallPatientinfo> selectByExampleSelective(@Param("example") LitemallPatientinfoExample example, @Param("selective") LitemallPatientinfo.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    List<LitemallPatientinfo> selectByExample(LitemallPatientinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    LitemallPatientinfo selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallPatientinfo.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    LitemallPatientinfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    LitemallPatientinfo selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallPatientinfo record, @Param("example") LitemallPatientinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallPatientinfo record, @Param("example") LitemallPatientinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallPatientinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallPatientinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallPatientinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_patientinfo
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}