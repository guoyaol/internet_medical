package org.linlinjava.internetmedical.core.system;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统设置
 */
public class SystemConfig {
    // 小程序相关配置
    public final static String internetmedical_WX_INDEX_NEW = "internetmedical_wx_index_new";
    public final static String internetmedical_WX_INDEX_HOT = "internetmedical_wx_index_hot";
    public final static String internetmedical_WX_INDEX_BRAND = "internetmedical_wx_index_brand";
    public final static String internetmedical_WX_INDEX_TOPIC = "internetmedical_wx_index_topic";
    public final static String internetmedical_WX_INDEX_CATLOG_LIST = "internetmedical_wx_catlog_list";
    public final static String internetmedical_WX_INDEX_CATLOG_GOODS = "internetmedical_wx_catlog_goods";
    public final static String internetmedical_WX_SHARE = "internetmedical_wx_share";
    // 运费相关配置
    public final static String internetmedical_EXPRESS_FREIGHT_VALUE = "internetmedical_express_freight_value";
    public final static String internetmedical_EXPRESS_FREIGHT_MIN = "internetmedical_express_freight_min";
    // 订单相关配置
    public final static String internetmedical_ORDER_UNPAID = "internetmedical_order_unpaid";
    public final static String internetmedical_ORDER_UNCONFIRM = "internetmedical_order_unconfirm";
    public final static String internetmedical_ORDER_COMMENT = "internetmedical_order_comment";
    // 商场相关配置
    public final static String internetmedical_MALL_NAME = "internetmedical_mall_name";
    public final static String internetmedical_MALL_ADDRESS = "internetmedical_mall_address";
    public final static String internetmedical_MALL_PHONE = "internetmedical_mall_phone";
    public final static String internetmedical_MALL_QQ = "internetmedical_mall_qq";
    public final static String internetmedical_MALL_LONGITUDE = "internetmedical_mall_longitude";
    public final static String internetmedical_MALL_Latitude = "internetmedical_mall_latitude";

    //所有的配置均保存在该 HashMap 中
    private static Map<String, String> SYSTEM_CONFIGS = new HashMap<>();

    private static String getConfig(String keyName) {
        return SYSTEM_CONFIGS.get(keyName);
    }

    private static Integer getConfigInt(String keyName) {
        return Integer.parseInt(SYSTEM_CONFIGS.get(keyName));
    }

    private static Boolean getConfigBoolean(String keyName) {
        return Boolean.valueOf(SYSTEM_CONFIGS.get(keyName));
    }

    private static BigDecimal getConfigBigDec(String keyName) {
        return new BigDecimal(SYSTEM_CONFIGS.get(keyName));
    }

    public static Integer getNewLimit() {
        return getConfigInt(internetmedical_WX_INDEX_NEW);
    }

    public static Integer getHotLimit() {
        return getConfigInt(internetmedical_WX_INDEX_HOT);
    }

    public static Integer getBrandLimit() {
        return getConfigInt(internetmedical_WX_INDEX_BRAND);
    }

    public static Integer getTopicLimit() {
        return getConfigInt(internetmedical_WX_INDEX_TOPIC);
    }

    public static Integer getCatlogListLimit() {
        return getConfigInt(internetmedical_WX_INDEX_CATLOG_LIST);
    }

    public static Integer getCatlogMoreLimit() {
        return getConfigInt(internetmedical_WX_INDEX_CATLOG_GOODS);
    }

    public static boolean isAutoCreateShareImage() {
        return getConfigBoolean(internetmedical_WX_SHARE);
    }

    public static BigDecimal getFreight() {
        return getConfigBigDec(internetmedical_EXPRESS_FREIGHT_VALUE);
    }

    public static BigDecimal getFreightLimit() {
        return getConfigBigDec(internetmedical_EXPRESS_FREIGHT_MIN);
    }

    public static Integer getOrderUnpaid() {
        return getConfigInt(internetmedical_ORDER_UNPAID);
    }

    public static Integer getOrderUnconfirm() {
        return getConfigInt(internetmedical_ORDER_UNCONFIRM);
    }

    public static Integer getOrderComment() {
        return getConfigInt(internetmedical_ORDER_COMMENT);
    }

    public static String getMallName() {
        return getConfig(internetmedical_MALL_NAME);
    }

    public static String getMallAddress() {
        return getConfig(internetmedical_MALL_ADDRESS);
    }

    public static String getMallPhone() {
        return getConfig(internetmedical_MALL_PHONE);
    }

    public static String getMallQQ() {
        return getConfig(internetmedical_MALL_QQ);
    }

    public static String getMallLongitude() {
        return getConfig(internetmedical_MALL_LONGITUDE);
    }

    public static String getMallLatitude() {
        return getConfig(internetmedical_MALL_Latitude);
    }

    public static void setConfigs(Map<String, String> configs) {
        SYSTEM_CONFIGS = configs;
    }

    public static void updateConfigs(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            SYSTEM_CONFIGS.put(entry.getKey(), entry.getValue());
        }
    }
}