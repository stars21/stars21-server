package cn.stars21.controller;

import cn.stars21.security.TokenUtils;
import cn.stars21.model.SysUser;
import cn.stars21.model.request.RequestLongUser;
import cn.stars21.service.SysUserService;
import cn.stars21.util.HttpResponse;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author super
 * Created by 2017/12/6.
 */
@RestController
@RequestMapping(value = "public")
public class SysLoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private TokenUtils tokenUtils;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public HttpResponse logon(@RequestBody RequestLongUser user) {
        HttpResponse<String> result = new HttpResponse<>();
        if (user.getUsername() != null && user.getPassword() != null) {
            SysUser sysUser = sysUserService.queryUserByUsername(user.getUsername());
            if (sysUser != null) {
                if (user.getPassword().equals(sysUser.getPassword())) {
                    String token = this.tokenUtils.generateToken(sysUser);
                    result.setData(token);
                } else {
                    result.setErrorMessage("密码不对");
                }
            } else {
                result.setErrorMessage("用户不存在");
            }
        } else {
            result.setErrorMessage("参数错误");
        }
        return result;
    }

}
