package com.mall.mapper;

import com.mall.model.UmsAdmin;

import java.util.List;

public interface UmsAdminMapper {
    public List<UmsAdmin> queryAll();
    public Long insert(UmsAdmin umsAdmin);
}
