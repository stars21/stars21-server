package cn.stars21.controller;

import cn.stars21.util.HttpResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by super on 2017/12/4.
 *
 * @author super
 */
@RestController
public class SysUserController {

    private Logger logger = LoggerFactory.getLogger(SysUserController.class);
    private static final String URL_PREFIX = "/api";

    @ApiOperation(value = "分页获取系统用户列表")
    @RequestMapping(value = URL_PREFIX + "sys/user", method = RequestMethod.GET)
    public HttpResponse list() {
        return new HttpResponse();
    }

}
