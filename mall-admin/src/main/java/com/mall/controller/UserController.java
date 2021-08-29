package com.mall.controller;

import com.mall.mapper.UmsAdminMapper;
import com.mall.model.UmsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @GetMapping("")
    public List<UmsAdmin> list() {
        return umsAdminMapper.queryAll();
    }
}
