package com.gcc.advp.system.feign;

import com.gcc.advp.feign.IFeignSystemController;
import com.gcc.advp.system.entity.SysMenuEntity;
import com.gcc.advp.system.entity.SysUserEntity;
import com.gcc.advp.system.service.SysMenuService;
import com.gcc.advp.system.service.SysUserService;
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
    public SysUserEntity findUserByUsername(String username) {
        return sysUserService.findByUsername(username);
    }

    /**
     *通过用户ID查询拥有权限
     * @param userId 用户id
     * @return
     */
    @Override
    public List<SysMenuEntity> findMenuListByUserId(String userId) {
        return sysMenuService.findByUserId(userId);
    }
}
