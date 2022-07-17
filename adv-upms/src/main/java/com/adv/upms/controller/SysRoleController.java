package com.adv.upms.controller;

import com.adv.util.base.base.PageResult;
import com.adv.util.base.base.Result;
import com.adv.upms.convert.SysRoleConvert;
import com.adv.upms.service.SysRoleService;
import com.adv.api.upms.entity.SysRole;
import com.adv.api.upms.query.SysRoleQuery;
import com.adv.api.upms.vo.SysRoleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 角色信息表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-17
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
    public Result<PageResult<SysRoleVO>> page(@Valid SysRoleQuery query){
        PageResult<SysRoleVO> page = sysRoleService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('sysrole:info')")
    public Result<SysRoleVO> get(@PathVariable("id") Long id){
        SysRole entity = sysRoleService.getById(id);

        return Result.ok(SysRoleConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('sysrole:save')")
    public Result<String> save(@RequestBody SysRoleVO vo){
        sysRoleService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('sysrole:update')")
    public Result<String> update(@RequestBody @Valid SysRoleVO vo){
        sysRoleService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('sysrole:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysRoleService.delete(idList);

        return Result.ok();
    }
}