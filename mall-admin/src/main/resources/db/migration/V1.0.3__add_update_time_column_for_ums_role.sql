ALTER TABLE ums_role
    ADD COLUMN update_time datetime DEFAULT NULL COMMENT '更新时间' AFTER create_time;
