package com.zcf.fruit.service.sys;

import com.zcf.fruit.dao.mysqlDao.user.MenuDao;
import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.user.Menu;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by zcf on 2017/6/16.
 */
@Service
public class MenuService {
    @Inject
    private MenuDao menuDao;

    public IfPage<Menu> findList(Page page){
        IfPage<Menu> menuIfPage = new IfPage<Menu>();
        menuIfPage.setPageNum(page.getCurrentPage());

        List<Menu> menuList = menuDao.findList(page);
        menuIfPage.setDates(menuList);

        //查询数据总数
        int total = menuDao.getMenuTotal();
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        menuIfPage.setPageTotal(totalPage);
        return menuIfPage;
    }
}
