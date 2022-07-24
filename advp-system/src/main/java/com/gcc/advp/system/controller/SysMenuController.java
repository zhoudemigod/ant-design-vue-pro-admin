package com.gcc.advp.system.controller;

import com.gcc.advp.system.entity.SysMenuEntity;
import com.gcc.advp.utils.base.Result;
import com.gcc.advp.utils.page.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.gcc.advp.system.convert.SysMenuConvert;
import com.gcc.advp.system.service.SysMenuService;
import com.gcc.advp.system.query.SysMenuQuery;
import com.gcc.advp.system.vo.SysMenuVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 菜单信息表
*
* @author zhouwenfang 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@RestController
@RequestMapping("sysmenu")
@Tag(name="菜单信息表")
@AllArgsConstructor
public class SysMenuController {
    private final SysMenuService sysMenuService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('sysmenu:page')")
    public Result page(@Valid SysMenuQuery query){
        PageResult<SysMenuVO> page = sysMenuService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('sysmenu:info')")
    public Result get(@PathVariable("id") Long id){
        SysMenuEntity entity = sysMenuService.getById(id);

        return Result.ok(SysMenuConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('sysmenu:save')")
    public Result save(@RequestBody SysMenuVO vo){
        sysMenuService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('sysmenu:update')")
    public Result update(@RequestBody @Valid SysMenuVO vo){
        sysMenuService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('sysmenu:delete')")
    public Result delete(@RequestBody List<Long> idList){
        sysMenuService.delete(idList);

        return Result.ok();
    }
}