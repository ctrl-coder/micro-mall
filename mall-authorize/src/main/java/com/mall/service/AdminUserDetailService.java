package com.mall.service;

import com.mall.domain.MallAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MallAdmin user = new MallAdmin();
        user.setUserName(username);
        user.setPassword(passwordEncoder.encode("123456"));
        // 输出加密后的密码
        System.out.println(user.toString());
        System.out.println(user.getPassword());

        System.out.println(username);
        System.out.println(user.getPassword());
        System.out.println(user.isEnabled());
        System.out.println(user.isAccountNonExpired());
        System.out.println(user.isCredentialsNonExpired());
        System.out.println(user.isAccountNonLocked());
        System.out.println(AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return new User(username, user.getPassword(), user.isEnabled(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
