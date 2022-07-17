package com.adv.oauth2.service;



import cn.hutool.core.util.ArrayUtil;
import com.adv.api.feign.IFeignSystemController;
import com.adv.api.upms.entity.SysMenu;
import com.adv.api.upms.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IFeignSystemController feignSystemController;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 判断用户名是否为空
        if(StringUtils.isEmpty(username)) {
            throw new BadCredentialsException("用户名不能为空");
        }
        // 2. 通过用户名查询数据库中的用户信息
        SysUser sysUser = feignSystemController.findUserByUsername(username);
        if(sysUser == null) {
            throw new BadCredentialsException("用户名或密码错误");
        }

        // 3. 通过用户id去查询数据库的拥有的权限信息
        List<SysMenu> menuList =
                feignSystemController.findMenuListByUserId(sysUser.getId());

        // 4. 封装权限信息（权限标识符code）
        List<GrantedAuthority> authorities = null;
        if(ArrayUtil.isNotEmpty(menuList)) {
            authorities = new ArrayList<>();
            for(SysMenu menu: menuList) {
                // 权限标识
                String code = menu.getCode();
                authorities.add(new SimpleGrantedAuthority(code));
            }
        }

        // 5. 构建UserDetails接口的实现类JwtUser对象
        JwtUser jwtUser = new JwtUser( sysUser.getId(), sysUser.getUsername(), sysUser.getPassword(),
                sysUser.getName(), sysUser.getAvatar(), sysUser.getTelephone(),
                authorities );

        return jwtUser;
    }
}
