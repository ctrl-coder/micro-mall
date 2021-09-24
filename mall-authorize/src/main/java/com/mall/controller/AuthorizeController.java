package com.mall.controller;

import com.mall.api.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class AuthorizeController {

//    @PostMapping("/authentication")
//    public CommonResult authentication(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        return CommonResult.unauthorized();
//    }

    @GetMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public CommonResult requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        return CommonResult.unauthorized();
    }
}
