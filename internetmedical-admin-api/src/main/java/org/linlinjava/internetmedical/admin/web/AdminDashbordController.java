package org.linlinjava.internetmedical.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.internetmedical.core.util.ResponseUtil;
import org.linlinjava.internetmedical.db.service.InternetmedicalGoodsProductService;
import org.linlinjava.internetmedical.db.service.InternetmedicalGoodsService;
import org.linlinjava.internetmedical.db.service.InternetmedicalOrderService;
import org.linlinjava.internetmedical.db.service.InternetmedicalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/dashboard")
@Validated
public class AdminDashbordController {
    private final Log logger = LogFactory.getLog(AdminDashbordController.class);

    @Autowired
    private InternetmedicalUserService userService;
    @Autowired
    private InternetmedicalGoodsService goodsService;
    @Autowired
    private InternetmedicalGoodsProductService productService;
    @Autowired
    private InternetmedicalOrderService orderService;

    @GetMapping("")
    public Object info() {
        int userTotal = userService.count();
        int goodsTotal = goodsService.count();
        int productTotal = productService.count();
        int orderTotal = orderService.count();
        Map<String, Integer> data = new HashMap<>();
        data.put("userTotal", userTotal);
        data.put("goodsTotal", goodsTotal);
        data.put("productTotal", productTotal);
        data.put("orderTotal", orderTotal);

        return ResponseUtil.ok(data);
    }

}
