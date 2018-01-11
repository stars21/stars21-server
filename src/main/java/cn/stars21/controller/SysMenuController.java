package cn.stars21.controller;

import cn.stars21.model.SysMenu;
import cn.stars21.service.SysMenuService;
import cn.stars21.util.HttpResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by super on 2017/11/17.
 * @author super
 */
@RestController
@RequestMapping(value = "api/sys/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "获取分页菜单信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public HttpResponse getSysMenuList(@RequestParam int pageIndex, @RequestParam int pageSize, String name) {
        HttpResponse<Map> result = new HttpResponse<>();
        Map<String, Object> params = new HashMap<String, Object>();
        int page = pageIndex;
        int rows = pageSize;
        int offset = (page - 1) * rows;
        params.put("offset", offset);
        params.put("page", page);
        params.put("rows", rows);
        if (name != null) {
            params.put("name", name);
        }
        long count = sysMenuService.getUserCount(params);
        System.out.println(count);
        Map<String, Object> map = new HashMap<>();
        map.put("totalElements", count);
        map.put("content", sysMenuService.querySysMenuList(params));
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "保存菜单", notes = "根据菜单信息保存菜单")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public HttpResponse saveSysMenu(@RequestBody SysMenu menu) {
        menu.setCreateUserName("admin");
        sysMenuService.saveMenu(menu);
        return new HttpResponse();
    }

    @ApiOperation(value = "根据菜单Id删除用户")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public HttpResponse deleteUser(@RequestParam String id) {
        HttpResponse<Boolean> result = new HttpResponse<>();
        result.setData(sysMenuService.deleteMenuId(Integer.parseInt(id)) == 1 ? true : false);
        return result;
    }

    @ApiOperation(value = "获取菜单树状结构")
    @RequestMapping(value = "tree", method = RequestMethod.GET)
    public HttpResponse getSysMenuTree() {
        return new HttpResponse<List<SysMenu>>().setData(this.sysMenuService.getMenuTree());
    }


}
