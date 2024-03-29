package org.linlinjava.internetmedical.admin.web;

import io.swagger.models.auth.In;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.linlinjava.internetmedical.core.util.JacksonUtil;
import org.linlinjava.internetmedical.core.util.ResponseUtil;
import org.linlinjava.internetmedical.core.util.bcrypt.BCryptPasswordEncoder;
import org.linlinjava.internetmedical.core.validator.Order;
import org.linlinjava.internetmedical.core.validator.Sort;
import org.linlinjava.internetmedical.db.domain.InternetmedicalAdmin;
import org.linlinjava.internetmedical.db.domain.InternetmedicalIssue;
import org.linlinjava.internetmedical.db.domain.InternetmedicalNotice;
import org.linlinjava.internetmedical.db.domain.InternetmedicalNoticeAdmin;
import org.linlinjava.internetmedical.db.service.InternetmedicalAdminService;
import org.linlinjava.internetmedical.db.service.InternetmedicalNoticeAdminService;
import org.linlinjava.internetmedical.db.service.InternetmedicalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.linlinjava.internetmedical.admin.util.AdminResponseCode.ADMIN_INVALID_ACCOUNT;

@RestController
@RequestMapping("/admin/profile")
@Validated
public class AdminProfileController {
    private final Log logger = LogFactory.getLog(AdminProfileController.class);

    @Autowired
    private InternetmedicalAdminService adminService;
    @Autowired
    private InternetmedicalNoticeService noticeService;
    @Autowired
    private InternetmedicalNoticeAdminService noticeAdminService;

    @RequiresAuthentication
    @PostMapping("/password")
    public Object create(@RequestBody String body) {
        String oldPassword = JacksonUtil.parseString(body, "oldPassword");
        String newPassword = JacksonUtil.parseString(body, "newPassword");
        if (StringUtils.isEmpty(oldPassword)) {
            return ResponseUtil.badArgument();
        }
        if (StringUtils.isEmpty(newPassword)) {
            return ResponseUtil.badArgument();
        }

        Subject currentUser = SecurityUtils.getSubject();
        InternetmedicalAdmin admin = (InternetmedicalAdmin) currentUser.getPrincipal();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(oldPassword, admin.getPassword())) {
            return ResponseUtil.fail(ADMIN_INVALID_ACCOUNT, "账号密码不对");
        }

        String encodedNewPassword = encoder.encode(newPassword);
        admin.setPassword(encodedNewPassword);

        adminService.updateById(admin);
        return ResponseUtil.ok();
    }

    private Integer getAdminId(){
        Subject currentUser = SecurityUtils.getSubject();
        InternetmedicalAdmin admin = (InternetmedicalAdmin) currentUser.getPrincipal();
        return admin.getId();
    }

    @RequiresAuthentication
    @GetMapping("/nnotice")
    public Object nNotice() {
        int count = noticeAdminService.countUnread(getAdminId());
        return ResponseUtil.ok(count);
    }

    @RequiresAuthentication
    @GetMapping("/lsnotice")
    public Object lsNotice(String title, String type,
                            @RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer limit,
                            @Sort @RequestParam(defaultValue = "add_time") String sort,
                            @Order @RequestParam(defaultValue = "desc") String order) {
        List<InternetmedicalNoticeAdmin> noticeList = noticeAdminService.querySelective(title, type, getAdminId(), page, limit, sort, order);
        return ResponseUtil.okList(noticeList);
    }

    @RequiresAuthentication
    @PostMapping("/catnotice")
    public Object catNotice(@RequestBody String body) {
        Integer noticeId = JacksonUtil.parseInteger(body, "noticeId");
        if(noticeId == null){
            return ResponseUtil.badArgument();
        }

        InternetmedicalNoticeAdmin noticeAdmin = noticeAdminService.find(noticeId, getAdminId());
        if(noticeAdmin == null){
           return ResponseUtil.badArgumentValue();
        }
        // 更新通知记录中的时间
        noticeAdmin.setReadTime(LocalDateTime.now());
        noticeAdminService.update(noticeAdmin);

        // 返回通知的相关信息
        Map<String, Object> data = new HashMap<>();
        InternetmedicalNotice notice = noticeService.findById(noticeId);
        data.put("title", notice.getTitle());
        data.put("content", notice.getContent());
        data.put("time", notice.getUpdateTime());
        Integer adminId = notice.getAdminId();
        if(adminId.equals(0)){
            data.put("admin", "系统");
        }
        else{
            InternetmedicalAdmin admin = adminService.findById(notice.getAdminId());
            data.put("admin", admin.getUsername());
            data.put("avatar", admin.getAvatar());
        }
        return ResponseUtil.ok(data);
    }

    @RequiresAuthentication
    @PostMapping("/bcatnotice")
    public Object bcatNotice(@RequestBody String body) {
        List<Integer> ids = JacksonUtil.parseIntegerList(body, "ids");
        noticeAdminService.markReadByIds(ids, getAdminId());
        return ResponseUtil.ok();
    }

    @RequiresAuthentication
    @PostMapping("/rmnotice")
    public Object rmNotice(@RequestBody String body) {
        Integer id = JacksonUtil.parseInteger(body, "id");
        if(id == null){
            return ResponseUtil.badArgument();
        }
        noticeAdminService.deleteById(id, getAdminId());
        return ResponseUtil.ok();
    }

    @RequiresAuthentication
    @PostMapping("/brmnotice")
    public Object brmNotice(@RequestBody String body) {
        List<Integer> ids = JacksonUtil.parseIntegerList(body, "ids");
        noticeAdminService.deleteByIds(ids, getAdminId());
        return ResponseUtil.ok();
    }

}
