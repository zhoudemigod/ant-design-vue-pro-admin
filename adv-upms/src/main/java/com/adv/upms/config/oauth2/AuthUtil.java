package com.adv.upms.config.oauth2;

import com.adv.api.upms.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Map;

public class AuthUtil {

    public static SysUser getUserInfo() {
        Authentication authentication
                = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails details =
                (OAuth2AuthenticationDetails) authentication.getDetails();
        Map<String, Object> map = (Map<String, Object>) details.getDecodedDetails();
        Map<String, String> userInfo = (Map<String, String>) map.get("userInfo");

        SysUser user = new SysUser();
        user.setId(userInfo.get("uid"));
        user.setName(userInfo.get("nickName"));
        user.setUsername(userInfo.get("username"));

        return user;
    }
}
