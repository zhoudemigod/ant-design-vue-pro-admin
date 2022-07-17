package com.adv.upms.feign;

import com.adv.api.feign.IFeignSystemController;
import com.adv.api.upms.entity.SysMenu;
import com.adv.api.upms.entity.SysUser;
import com.adv.upms.service.SysMenuService;
import com.adv.upms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignSystemController implements IFeignSystemController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return
     */
    @Override
    public SysUser findUserByUsername(String username) {
        return sysUserService.findByUsername(username);
    }

    /**
     *通过用户ID查询拥有权限
     * @param userId 用户id
     * @return
     */
    @Override
    public List<SysMenu> findMenuListByUserId(String userId) {
        return sysMenuService.findByUserId(userId);
    }
}
