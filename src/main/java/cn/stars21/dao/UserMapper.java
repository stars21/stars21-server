package cn.stars21.dao;

import cn.stars21.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> queryUserList(Map<String, Object> params);

    int selectCount(Map<String, Object> params);

    String selectUserIsExist(Map<String, Object> params);

}