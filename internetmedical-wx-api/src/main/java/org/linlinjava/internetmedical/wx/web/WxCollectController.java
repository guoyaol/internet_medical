package org.linlinjava.internetmedical.wx.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.internetmedical.core.util.JacksonUtil;
import org.linlinjava.internetmedical.core.util.ResponseUtil;
import org.linlinjava.internetmedical.core.validator.Order;
import org.linlinjava.internetmedical.core.validator.Sort;
import org.linlinjava.internetmedical.db.domain.InternetmedicalCollect;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoods;
import org.linlinjava.internetmedical.db.domain.InternetmedicalTopic;
import org.linlinjava.internetmedical.db.service.InternetmedicalCollectService;
import org.linlinjava.internetmedical.db.service.InternetmedicalGoodsService;
import org.linlinjava.internetmedical.db.service.InternetmedicalTopicService;
import org.linlinjava.internetmedical.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户收藏服务
 */
@RestController
@RequestMapping("/wx/collect")
@Validated
public class WxCollectController {
    private final Log logger = LogFactory.getLog(WxCollectController.class);

    @Autowired
    private InternetmedicalCollectService collectService;
    @Autowired
    private InternetmedicalGoodsService goodsService;
    @Autowired
    private InternetmedicalTopicService topicService;

    /**
     * 用户收藏列表
     *
     * @param userId 用户ID
     * @param type   类型，如果是0则是商品收藏，如果是1则是专题收藏
     * @param page   分页页数
     * @param limit   分页大小
     * @return 用户收藏列表
     */
    @GetMapping("list")
    public Object list(@LoginUser Integer userId,
                       @NotNull Byte type,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        List<InternetmedicalCollect> collectList = collectService.queryByType(userId, type, page, limit, sort, order);

        List<Object> collects = new ArrayList<>(collectList.size());
        for (InternetmedicalCollect collect : collectList) {
            Map<String, Object> c = new HashMap<String, Object>();
            c.put("id", collect.getId());
            c.put("type", collect.getType());
            c.put("valueId", collect.getValueId());
            if (type == (byte)0){
            	//查询商品信息
                InternetmedicalGoods goods = goodsService.findById(collect.getValueId());
                c.put("name", goods.getName());
                c.put("brief", goods.getBrief());
                c.put("picUrl", goods.getPicUrl());
                c.put("retailPrice", goods.getRetailPrice());
            } else {
            	//查询专题信息
            	InternetmedicalTopic topic = topicService.findById(collect.getValueId());
	            c.put("title", topic.getTitle());
	            c.put("subtitle", topic.getTitle());
	            c.put("price", topic.getPrice());
	            c.put("picUrl", topic.getPicUrl());
            }
            collects.add(c);
        }

        return ResponseUtil.okList(collects, collectList);
    }

    /**
     * 用户收藏添加或删除
     * <p>
     * 如果商品没有收藏，则添加收藏；如果商品已经收藏，则删除收藏状态。
     *
     * @param userId 用户ID
     * @param body   请求内容，{ type: xxx, valueId: xxx }
     * @return 操作结果
     */
    @PostMapping("addordelete")
    public Object addordelete(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        Byte type = JacksonUtil.parseByte(body, "type");
        Integer valueId = JacksonUtil.parseInteger(body, "valueId");
        if (!ObjectUtils.allNotNull(type, valueId)) {
            return ResponseUtil.badArgument();
        }

        InternetmedicalCollect collect = collectService.queryByTypeAndValue(userId, type, valueId);

        if (collect != null) {
            collectService.deleteById(collect.getId());
        } else {
            collect = new InternetmedicalCollect();
            collect.setUserId(userId);
            collect.setValueId(valueId);
            collect.setType(type);
            collectService.add(collect);
        }

        return ResponseUtil.ok();
    }
}