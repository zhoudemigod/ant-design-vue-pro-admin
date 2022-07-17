package com.adv.upms.service.impl;


import com.adv.api.upms.req.RegisterREQ;
import com.adv.upms.convert.SysUserConvert;
import com.adv.upms.dao.SysUserDao;
import com.adv.api.upms.entity.SysUser;
import com.adv.api.upms.query.SysUserQuery;
import com.adv.api.upms.vo.SysUserVO;
import com.adv.upms.service.SysUserService;
import com.adv.util.base.base.PageResult;
import com.adv.util.base.base.Result;
import com.adv.util.base.base.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表
 *
 * @author zhouwenfang.com
 * @since 1.0.0 2022-07-16
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        IPage<SysUser> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private QueryWrapper<SysUser> getWrapper(SysUserQuery query) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        return wrapper;
    }

    @Override
    public void save(SysUserVO vo) {
        SysUser entity = SysUserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysUserVO vo) {
        SysUser entity = SysUserConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public SysUser findByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public Result checkUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        SysUser sysUser = baseMapper.selectOne(wrapper);
        // 查询到则存在，存在 data=true 已被注册，不存在 data=false 未被注册
        return Result.ok(sysUser == null ? false : true);
    }

    @Override
    public Result register(RegisterREQ req) {
        if (StringUtils.isEmpty(req.getUsername())) {
            return Result.error("用户名不能为空");
        }

        if (StringUtils.isEmpty(req.getPassword())) {
            return Result.error("密码不能为空");
        }

        if (StringUtils.isEmpty(req.getRepPassword())) {
            return Result.error("确认密码不能为空");
        }

        if (!StringUtils.equals(req.getPassword(), req.getRepPassword())) {
            return Result.error("两次输入的密码不一致");
        }

        // 校验用户名是否存在
        Result result = checkUsername(req.getUsername());
        // 存在 data=true 已被注册，不存在 data=false 未被注册
        if ((Boolean) result.getData()) {
            return Result.error("用户名已经被注册，请更换一个用户名");
        }

        // 将新用户信息保存到数据库
        SysUser sysUser = new SysUser();
        sysUser.setUsername(req.getUsername());
        sysUser.setName(req.getUsername());
        sysUser.setPassword(passwordEncoder.encode(req.getPassword()));
        // 新增操作
        this.save(sysUser);
        return Result.ok();
    }

}