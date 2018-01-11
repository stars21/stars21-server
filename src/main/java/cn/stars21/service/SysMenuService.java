package cn.stars21.service;

import cn.stars21.dao.SysMenuMapper;
import cn.stars21.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by super on 2017/11/17.
 * @author super
 */
@Service
public class SysMenuService {


    @Autowired
    private SysMenuMapper sysMenuMapper;

    public int getUserCount(Map <String,Object> params) {
        return sysMenuMapper.selectCount(params);
    }

    public List<SysMenu> querySysMenuList(Map<String, Object> params) {
        return sysMenuMapper.querySysMenuList(params);
    }

    public Integer saveMenu(SysMenu menu) {
        return sysMenuMapper.insert(menu);
    }

    public Integer deleteMenuId(Integer id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    public List<SysMenu> getMenuTree() {
        List<SysMenu> list = sysMenuMapper.queryTreeList();
        List<SysMenu> result = new ArrayList<>();
        for (SysMenu menu: list) {
            if (menu.getLevel() == 1) {
                menu.setChildren(new ArrayList<>());
                result.add(menu);
            } else {
                for (int i = 0; i < result.size(); i ++) {
                    SysMenu child = result.get(i);
                    if (!menu.getPid().equals(child.getId())) {
                        this.parseMenu(result, menu);
                    } else {
                        child.getChildren().add(menu);
                    }
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 无限遍历添加节点
     * @param list
     * @param menu
     */
    private void parseMenu(List<SysMenu> list, SysMenu menu) {
        for (int i = 0; i < list.size(); i ++) {
            SysMenu sysMenu = list.get(i);
            if (!sysMenu.getId().equals(menu.getPid())) {
                if (sysMenu.getChildren() != null && sysMenu.getChildren().size() > 0) {
                    this.parseMenu(sysMenu.getChildren(), menu);
                    break;
                } else {
                    continue;
                }
            } else {
                if (sysMenu.getChildren() == null) {
                    sysMenu.setChildren(new ArrayList<SysMenu>(){{
                        add(menu);
                    }});
                } else {
                    sysMenu.getChildren().add(menu);
                }
                break;
            }
        }
    }

}
