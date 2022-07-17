package com.adv.upms.controller;

import com.adv.util.base.base.PageResult;
import com.adv.util.base.base.Result;
import com.adv.upms.convert.SysMenuConvert;
import com.adv.upms.service.SysMenuService;
import com.adv.api.upms.query.SysMenuQuery;
import com.adv.api.upms.vo.SysMenuVO;
import com.adv.api.upms.entity.SysMenu;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 菜单信息表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-17
*/
@RestController
@RequestMapping("sysmenu")
@Tag(name="菜单信息表")
@AllArgsConstructor
public class SysMenuController {
    private final SysMenuService sysMenuService;

    @GetMapping("page")
    @Operation(summary = "分页")
    // @PreAuthorize("hasAuthority('sysmenu:page')")
    public Result<PageResult<SysMenuVO>> page(@Valid SysMenuQuery query){
        PageResult<SysMenuVO> page = sysMenuService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('sysmenu:info')")
    public Result<SysMenuVO> get(@PathVariable("id") Long id){
        SysMenu entity = sysMenuService.getById(id);

        return Result.ok(SysMenuConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('sysmenu:save')")
    public Result<String> save(@RequestBody SysMenuVO vo){
        sysMenuService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('sysmenu:update')")
    public Result<String> update(@RequestBody @Valid SysMenuVO vo){
        sysMenuService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('sysmenu:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysMenuService.delete(idList);

        return Result.ok();
    }
}