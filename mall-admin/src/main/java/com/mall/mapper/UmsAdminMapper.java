package com.mall.mapper;

import com.mall.model.UmsAdmin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UmsAdminMapper {
    public List<UmsAdmin> queryAll();
    public Long insert(UmsAdmin umsAdmin);
    public UmsAdmin findByUsername(String username);
}
