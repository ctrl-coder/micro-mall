package com.mall.service.impl;

import com.mall.dto.UmsRoleParam;
import com.mall.mapper.UmsRoleMapper;
import com.mall.model.UmsRole;
import com.mall.service.UmsRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    private UmsRoleMapper umsRoleMapper;

    @Override
    public int create(UmsRoleParam roleParam) {
        UmsRole umsRole = new UmsRole();
        BeanUtils.copyProperties(roleParam, umsRole);

        umsRole.setAdminCount(0);
        umsRole.setCreateTime(new Date());
        umsRole.setUpdateTime(new Date());

        return umsRoleMapper.insert(umsRole);
    }
}
