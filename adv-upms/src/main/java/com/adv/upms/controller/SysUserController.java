package com.adv.upms.controller;

import com.adv.util.base.base.PageResult;
import com.adv.upms.service.SysUserService;
import com.adv.api.upms.vo.SysUserVO;
import com.adv.api.upms.entity.SysUser;
import com.adv.util.base.base.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.adv.upms.convert.SysUserConvert;
import com.adv.api.upms.query.SysUserQuery;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 用户表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-16
*/
@RestController
@RequestMapping("user")
@Tag(name="用户表")
@AllArgsConstructor
public class SysUserController {
    private final SysUserService sysUserService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('sysuser:page')")
    public Result<PageResult<SysUserVO>> page(@Valid SysUserQuery query){
        PageResult<SysUserVO> page = sysUserService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('sysuser:info')")
    public Result<SysUserVO> get(@PathVariable("id") String id){
        SysUser entity = sysUserService.getById(id);

        return Result.ok(SysUserConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('sysuser:save')")
    public Result<String> save(@RequestBody SysUserVO vo){
        sysUserService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('sysuser:update')")
    public Result<String> update(@RequestBody @Valid SysUserVO vo){
        sysUserService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('sysuser:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysUserService.delete(idList);

        return Result.ok();
    }
}