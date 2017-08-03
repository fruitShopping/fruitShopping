package com.fruit.service.menu;

import com.fruit.common.utils.CacheUtils;
import com.fruit.dao.menu.MenuDao;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.sys.Menu;
import com.fruit.util.LogUtils;
import com.fruit.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by zcf on 2017/6/16.
 */
@Service
@Transactional
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    public IfPage<Menu> findList(Page page){
        IfPage<Menu> menuIfPage = new IfPage<Menu>();
        menuIfPage.setPageNum(page.getCurrentPage());
        if(page.getCurrentPage() == 1){
            page.setBegin(0);
        }

        List<Menu> menuList = menuDao.findList(page);
        menuIfPage.setDates(menuList);

        //查询数据总数
        int total = menuDao.getMenuTotal();
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        menuIfPage.setPageTotal(totalPage);
        return menuIfPage;
    }

    public List<Menu> findAllList(String username){
        return menuDao.findAllList(username);
    }

    public Menu selectById(int id){
        return menuDao.get(id);
    }

    public void save(Menu menu){
        int menuId = menu.getId();
        // 获取修改前的parentIds，用于更新子节点的parentIds
        String oldParentIds = menu.getParentIds();

        // 设置新的父节点串
        menu.setParentIds(menu.getParent().getParentIds()+menu.getParent().getId()+",");
        if(menuId == 0){
            //新增
            menu.preInsert();
            menuDao.insert(menu);
        }else{
            //修改
            menu.preUpdate();
            menuDao.update(menu);
        }

        // 更新子节点 parentIds
        Menu m = new Menu();
        m.setParentIds("%,"+menu.getId()+",%");
        List<Menu> list = menuDao.findByParentIdsLike(m);
        for (Menu e : list){
            e.setParentIds(e.getParentIds().replace(oldParentIds, menu.getParentIds()));
            menuDao.updateParentIds(e);
        }
        // 清除用户菜单缓存
        UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);

        // 清除日志相关缓存
        CacheUtils.remove(LogUtils.CACHE_MENU_NAME_PATH_MAP);
    }

    public void delete(String ids){
        String idss= ids.substring(0,ids.length()-1);
        String[] idsArr = idss.split(",");
        for(String id : idsArr){
            menuDao.delete(Integer.parseInt(id));
        }
    }

    /**
     * 角色赋权查询菜单树形结构
     * @param roleId 角色ID
     * @return 返回值
     */
    public List<Map<Object,Object>> getMenuTree(int roleId){
        return menuDao.getMenuTree(roleId);
    }
}
