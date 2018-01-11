package cn.stars21.service;

import cn.stars21.dao.UserMapper;
import cn.stars21.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by super on 2017/10/12.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer saveUser(User user) {
        return userMapper.insert(user);
    }

    public Integer updateUser(User user) { return userMapper.updateByPrimaryKey(user); }

    public int getUserCount(Map <String,Object> params) {
        return userMapper.selectCount(params);
    }

    public boolean checkNameIsExist(String name, String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        String result =  userMapper.selectUserIsExist(params);
        if (id != null) {
            params.put("id", id);
            String resultName = userMapper.selectUserIsExist(params);
            return resultName != null ? false : result != null ? true : false;
        } else {
            return result == null ? false : true;
        }
    }

    public List<User> queryUserList(Map <String,Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        List<User> list = userMapper.queryUserList(params);
        return list;
    }

    public Integer deleteUserId(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

}
