package com.fruit.service.product;

import com.fruit.common.utils.Servlets;
import com.fruit.dao.product.CategoryDao;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.product.CategoryEntity;
import com.fruit.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * 产品品种
 * Created by zcf on 2017/6/28.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    /**
     * 品种信息分页查询
     * @param page 分页
     * @return
     */
    public IfPage<CategoryEntity> getCategoryList(Page page){
        IfPage<CategoryEntity> categoryListIfPage = new IfPage<CategoryEntity>();
        categoryListIfPage.setPageNum(page.getCurrentPage());
        if(page.getCurrentPage() == 1){
            page.setBegin(0);
        }

        List<CategoryEntity> dictList = categoryDao.findPageList(page);
        categoryListIfPage.setDates(dictList);

        //数据总数
        int total = categoryDao.findTotal();
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        categoryListIfPage.setPageTotal(totalPage);
        return  categoryListIfPage;

    }

    public CategoryEntity findById(int categoryId){
        return categoryDao.findById(categoryId);
    }

    public void save(CategoryEntity category){
        int id = category.getId();
        if(id == 0){
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "字典信息新增");
            categoryDao.insert(category);
        }else{
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "字典信息更新");
            categoryDao.update(category);
        }
    }

    public void delete(String categoryIds){
        String[] categoryIdArr = categoryIds.split(",");
        for(String categoryId : categoryIdArr){
            //数据删除
            categoryDao.delete(Integer.parseInt(categoryId));
        }
    }

    public List<CategoryEntity> findCateByCode(int typeId){
        return categoryDao.findCateByCode(typeId);
    }
}
