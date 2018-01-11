package cn.stars21.dao;

import cn.stars21.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    int selectCount(Map<String, Object> params);

    List<SysMenu> querySysMenuList(Map<String, Object> params);

    List<SysMenu> queryTreeList();
}