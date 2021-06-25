package org.linlinjava.internetmedical.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.linlinjava.internetmedical.core.qcode.QCodeService;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoods;
import org.linlinjava.internetmedical.db.service.InternetmedicalGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateShareImageTest {
    @Autowired
    QCodeService qCodeService;
    @Autowired
    InternetmedicalGoodsService internetmedicalGoodsService;

    @Test
    public void test() {
        InternetmedicalGoods good = internetmedicalGoodsService.findById(1181010);
        qCodeService.createGoodShareImage(good.getId().toString(), good.getPicUrl(), good.getName());
    }
}
