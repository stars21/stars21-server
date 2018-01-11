package cn.stars21.service;

import cn.stars21.dao.SysUserMapper;
import cn.stars21.model.SysUser;
import cn.stars21.security.SecurityModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by super on 2017/12/4.
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = this.sysUserMapper.getUserFromDatabase(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return SecurityModelFactory.create(user);
        }
    }

    public SysUser queryUserByUsername(String username) {
        return  this.sysUserMapper.nameQueryUser(username);
    }

}
