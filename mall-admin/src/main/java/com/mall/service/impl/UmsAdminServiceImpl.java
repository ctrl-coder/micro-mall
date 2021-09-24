package com.mall.service.impl;

import com.mall.dto.UmsAdminParam;
import com.mall.mapper.UmsAdminMapper;
import com.mall.model.UmsAdmin;
import com.mall.service.UmsAdminService;
import com.mall.enums.UmsAdminStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        if (umsAdminMapper.findByUsername(umsAdminParam.getUsername()) != null) {
            return null;
        }

        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setEmail(umsAdminParam.getEmail());
        umsAdmin.setUsername(umsAdminParam.getUsername());
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(UmsAdminStatusEnum.ENABLED.getStatus());

        umsAdmin.setPassword(passwordEncoder.encode(umsAdminParam.getPassword()));

        umsAdminMapper.insert(umsAdmin);

        return umsAdmin;
    }
}
