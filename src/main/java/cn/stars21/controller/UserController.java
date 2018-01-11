package cn.stars21.controller;

import cn.stars21.model.User;
import cn.stars21.service.UserService;
import cn.stars21.util.HttpResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by super on 2017/10/12.
 * @author super
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Value("${token.header}")
    private String tokenHeader;

    @ApiOperation(value = "保存用户", notes = "根据用户信息保存用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public HttpResponse saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new HttpResponse();
    }

    @ApiOperation(value = "修改用户", notes = "根据用户Id相关信息修改用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public HttpResponse updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new HttpResponse();
    }


    @ApiOperation(value = "判断是否名是否存在")
    @RequestMapping(value = "/checkIsExist", method = RequestMethod.GET)
    public HttpResponse checkUserIsExist(@RequestParam String name, String id) {
        return new HttpResponse<Boolean>().setData(userService.checkNameIsExist(name, id));
    }

    @ApiOperation(value = "根据用户Id删除用户")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public HttpResponse deleteUser(@RequestParam String id) {
        return new HttpResponse<Boolean>().setData(userService.deleteUserId(Integer.parseInt(id)) == 1 ? true : false);
    }

    @ApiOperation(value = "获取所有用户信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public HttpResponse getUserList(@RequestParam int pageIndex, @RequestParam int pageSize, String name) {
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
        long count = userService.getUserCount(params);
        Map<String, Object> map = new HashMap<>();
        map.put("totalElements", count);
        map.put("content", userService.queryUserList(params));
        return new HttpResponse<Map>().setData(map);
    }


}
