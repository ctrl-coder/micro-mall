DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation`
(
    `id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `admin_id` bigint(20) DEFAULT NULL,
    `role_id`  bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = utf8 COMMENT ='后台用户-角色关系表';
