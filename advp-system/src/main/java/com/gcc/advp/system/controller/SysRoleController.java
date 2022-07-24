package com.gcc.advp.system.controller;

import com.gcc.advp.system.entity.SysRoleEntity;
import com.gcc.advp.utils.base.Result;
import com.gcc.advp.utils.page.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.gcc.advp.system.convert.SysRoleConvert;
import com.gcc.advp.system.service.SysRoleService;
import com.gcc.advp.system.query.SysRoleQuery;
import com.gcc.advp.system.vo.SysRoleVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 角色信息表
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@RestController
@RequestMapping("sysrole")
@Tag(name="角色信息表")
@AllArgsConstructor
public class SysRoleController {
    private final SysRoleService sysRoleService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('sysrole:page')")
    public Result page(@Valid SysRoleQuery query){
        PageResult<SysRoleVO> page = sysRoleService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('sysrole:info')")
    public Result get(@PathVariable("id") Long id){
        SysRoleEntity entity = sysRoleService.getById(id);

        return Result.ok(SysRoleConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('sysrole:save')")
    public Result save(@RequestBody SysRoleVO vo){
        sysRoleService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('sysrole:update')")
    public Result update(@RequestBody @Valid SysRoleVO vo){
        sysRoleService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('sysrole:delete')")
    public Result delete(@RequestBody List<Long> idList){
        sysRoleService.delete(idList);

        return Result.ok();
    }
}