package org.linlinjava.internetmedical.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoods;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsExample;

public interface InternetmedicalGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    long countByExample(InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int deleteByExample(InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int insert(InternetmedicalGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int insertSelective(InternetmedicalGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    InternetmedicalGoods selectOneByExample(InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    InternetmedicalGoods selectOneByExampleSelective(@Param("example") InternetmedicalGoodsExample example, @Param("selective") InternetmedicalGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    InternetmedicalGoods selectOneByExampleWithBLOBs(InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    List<InternetmedicalGoods> selectByExampleSelective(@Param("example") InternetmedicalGoodsExample example, @Param("selective") InternetmedicalGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    List<InternetmedicalGoods> selectByExampleWithBLOBs(InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    List<InternetmedicalGoods> selectByExample(InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    InternetmedicalGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") InternetmedicalGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    InternetmedicalGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    InternetmedicalGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InternetmedicalGoods record, @Param("example") InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") InternetmedicalGoods record, @Param("example") InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InternetmedicalGoods record, @Param("example") InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InternetmedicalGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(InternetmedicalGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InternetmedicalGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") InternetmedicalGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table internetmedical_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}