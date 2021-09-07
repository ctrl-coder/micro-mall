package com.mall.service.impl;

import com.mall.dto.UmsAdminParam;
import com.mall.mapper.UmsAdminMapper;
import com.mall.model.UmsAdmin;
import com.mall.service.UmsAdminService;
import com.mall.enums.UmsAdminStatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);

        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(UmsAdminStatusEnum.ENABLED.getStatus());

        // TODO encrypt the password when integrate spring-security
        // String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdminMapper.insert(umsAdmin);

        return umsAdmin;
    }
}
