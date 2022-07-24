package com.gcc.advp.oauth2.config;

import com.gcc.advp.system.entity.SysUserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Map;

public class AuthUtil {

    public static SysUserEntity getUserInfo() {
        Authentication authentication
                = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails details =
                (OAuth2AuthenticationDetails)authentication.getDetails();
        Map<String, Object> map = (Map<String, Object>) details.getDecodedDetails();
        Map<String, String>  userInfo = (Map<String, String>) map.get("userInfo");

        SysUserEntity user = new SysUserEntity();
        user.setId(userInfo.get("uid"));
        user.setNickName(userInfo.get("nickName"));
        user.setUsername( userInfo.get("username") );
        user.setEmail( userInfo.get("email") );
        user.setImageUrl( userInfo.get("imageUrl") );
        user.setMobile( userInfo.get("mobile"));

        return user;
    }
}
