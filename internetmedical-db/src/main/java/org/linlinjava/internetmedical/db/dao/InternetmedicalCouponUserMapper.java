package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCouponUser;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCouponUserExample;

public interface InternetmedicalCouponUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int insert(InternetmedicalCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    InternetmedicalCouponUser selectOneByExample(InternetmedicalCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    InternetmedicalCouponUser selectOneByExampleSelective(@Param("example") InternetmedicalCouponUserExample example, @Param("selective") InternetmedicalCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    List<InternetmedicalCouponUser> selectByExampleSelective(@Param("example") InternetmedicalCouponUserExample example, @Param("selective") InternetmedicalCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    List<InternetmedicalCouponUser> selectByExample(InternetmedicalCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    InternetmedicalCouponUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    InternetmedicalCouponUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    InternetmedicalCouponUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalCouponUser record, @Param("example") InternetmedicalCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalCouponUser record, @Param("example") InternetmedicalCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_coupon_user
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}