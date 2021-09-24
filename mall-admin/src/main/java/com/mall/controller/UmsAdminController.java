package com.mall.controller;

import com.mall.api.CommonResult;
import com.mall.dto.UmsAdminParam;
import com.mall.model.UmsAdmin;
import com.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @PostMapping("/register")
    @ResponseBody
    public CommonResult register(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed("该用户名已被使用");
        }
        return CommonResult.success(umsAdmin);
    }

    @GetMapping("/users")
    @ResponseBody
    public void getUsers() {
        List user = new ArrayList();
    }
}
