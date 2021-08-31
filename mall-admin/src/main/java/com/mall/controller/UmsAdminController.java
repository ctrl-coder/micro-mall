package com.mall.controller;

import com.mall.dto.UmsAdminParams;
import com.mall.mapper.UmsAdminMapper;
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

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @PostMapping("/register")
    @ResponseBody
    public void register(@Validated @RequestBody UmsAdminParams umsAdminParams) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParams);
    }
}
