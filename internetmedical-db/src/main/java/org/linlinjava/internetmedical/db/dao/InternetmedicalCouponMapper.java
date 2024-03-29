package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCoupon;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCouponExample;

public interface InternetmedicalCouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int insert(InternetmedicalCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    InternetmedicalCoupon selectOneByExample(InternetmedicalCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    InternetmedicalCoupon selectOneByExampleSelective(@Param("example") InternetmedicalCouponExample example, @Param("selective") InternetmedicalCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    List<InternetmedicalCoupon> selectByExampleSelective(@Param("example") InternetmedicalCouponExample example, @Param("selective") InternetmedicalCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    List<InternetmedicalCoupon> selectByExample(InternetmedicalCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    InternetmedicalCoupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    InternetmedicalCoupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    InternetmedicalCoupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalCoupon record, @Param("example") InternetmedicalCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalCoupon record, @Param("example") InternetmedicalCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}