package org.linlinjava.internetmedical.admin.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCoupon;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCouponUser;
import org.linlinjava.internetmedical.db.service.InternetmedicalCouponService;
import org.linlinjava.internetmedical.db.service.InternetmedicalCouponUserService;
import org.linlinjava.internetmedical.db.util.CouponConstant;
import org.linlinjava.internetmedical.db.util.CouponUserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 检测优惠券过期情况
 */
@Component
public class CouponJob {
    private final Log logger = LogFactory.getLog(CouponJob.class);

    @Autowired
    private InternetmedicalCouponService couponService;
    @Autowired
    private InternetmedicalCouponUserService couponUserService;

    /**
     * 每隔一个小时检查
     * TODO
     * 注意，因为是相隔一个小时检查，因此导致优惠券真正超时时间可能比设定时间延迟1个小时
     */
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    public void checkCouponExpired() {
        logger.info("系统开启任务检查优惠券是否已经过期");

        List<InternetmedicalCoupon> couponList = couponService.queryExpired();
        for (InternetmedicalCoupon coupon : couponList) {
            coupon.setStatus(CouponConstant.STATUS_EXPIRED);
            couponService.updateById(coupon);
        }

        List<InternetmedicalCouponUser> couponUserList = couponUserService.queryExpired();
        for (InternetmedicalCouponUser couponUser : couponUserList) {
            couponUser.setStatus(CouponUserConstant.STATUS_EXPIRED);
            couponUserService.update(couponUser);
        }

        logger.info("系统结束任务检查优惠券是否已经过期");
    }

}
