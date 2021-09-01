package com.mall.service;

import com.mall.dto.UmsAdminParam;
import com.mall.model.UmsAdmin;

public interface UmsAdminService {
    UmsAdmin register(UmsAdminParam adminParams);
}
