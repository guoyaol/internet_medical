package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRegion;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRegionExample;

public interface InternetmedicalRegionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    int insert(InternetmedicalRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    InternetmedicalRegion selectOneByExample(InternetmedicalRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    InternetmedicalRegion selectOneByExampleSelective(@Param("example") InternetmedicalRegionExample example, @Param("selective") InternetmedicalRegion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    List<InternetmedicalRegion> selectByExampleSelective(@Param("example") InternetmedicalRegionExample example, @Param("selective") InternetmedicalRegion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    List<InternetmedicalRegion> selectByExample(InternetmedicalRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    InternetmedicalRegion selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalRegion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    InternetmedicalRegion selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalRegion record, @Param("example") InternetmedicalRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalRegion record, @Param("example") InternetmedicalRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_region
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalRegion record);
}