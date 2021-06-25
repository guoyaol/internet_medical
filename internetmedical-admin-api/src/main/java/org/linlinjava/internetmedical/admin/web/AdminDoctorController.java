package org.linlinjava.internetmedical.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.internetmedical.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.internetmedical.core.util.ResponseUtil;
import org.linlinjava.internetmedical.core.validator.Order;
import org.linlinjava.internetmedical.core.validator.Sort;
import org.linlinjava.internetmedical.db.domain.InternetmedicalDoctors;
import org.linlinjava.internetmedical.db.service.InternetmedicalDoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/admin/doctor")
@Validated
public class AdminDoctorController {
    private final Log logger = LogFactory.getLog(AdminDoctorController.class);

    @Autowired
    private InternetmedicalDoctorsService DoctorService;

    @RequiresPermissions("admin:doctor:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "医生管理"}, button = "查询")
    @GetMapping("/list")
    public Object list(String doctorname, String mobile,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<InternetmedicalDoctors> doctorList = DoctorService.querySelective(doctorname, mobile, page, limit, sort, order);
        return ResponseUtil.okList(doctorList);
    }
    @RequiresPermissions("admin:doctor:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "医生管理"}, button = "详情")
    @GetMapping("/detail")
    public Object doctorDetail(@NotNull Integer id) {
    	InternetmedicalDoctors doctor=DoctorService.findById(id);
        return ResponseUtil.ok(doctor);
    }
    @RequiresPermissions("admin:doctor:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "医生管理"}, button = "编辑")
    @PostMapping("/update")
    public Object doctorUpdate(@RequestBody InternetmedicalDoctors doctor) {
        return ResponseUtil.ok(DoctorService.updateById(doctor));
    }
}
