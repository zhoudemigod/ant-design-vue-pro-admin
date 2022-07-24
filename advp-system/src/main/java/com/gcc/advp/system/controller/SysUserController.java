package com.gcc.advp.system.controller;

import com.gcc.advp.system.entity.SysUserEntity;
import com.gcc.advp.utils.base.Result;
import com.gcc.advp.utils.page.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.gcc.advp.system.convert.SysUserConvert;
import com.gcc.advp.system.service.SysUserService;
import com.gcc.advp.system.query.SysUserQuery;
import com.gcc.advp.system.vo.SysUserVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 用户信息表
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@RestController
@RequestMapping("sysuser")
@Tag(name="用户信息表")
@AllArgsConstructor
public class SysUserController {
    private final SysUserService sysUserService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('sysuser:page')")
    public Result page(@Valid SysUserQuery query){
        PageResult<SysUserVO> page = sysUserService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('sysuser:info')")
    public Result get(@PathVariable("id") Long id){
        SysUserEntity entity = sysUserService.getById(id);

        return Result.ok(SysUserConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('sysuser:save')")
    public Result save(@RequestBody SysUserVO vo){
        sysUserService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('sysuser:update')")
    public Result update(@RequestBody @Valid SysUserVO vo){
        sysUserService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('sysuser:delete')")
    public Result delete(@RequestBody List<Long> idList){
        sysUserService.delete(idList);

        return Result.ok();
    }
}