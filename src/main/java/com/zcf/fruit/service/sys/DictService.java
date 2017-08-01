package com.zcf.fruit.service.sys;

import com.zcf.fruit.common.utils.Servlets;
import com.zcf.fruit.dao.mysqlDao.sys.DictDao;
import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.product.CategoryEntity;
import com.zcf.fruit.entity.sys.DictEntity;
import com.zcf.fruit.entity.sys.User;
import com.zcf.fruit.util.LogUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by zcf on 2017/6/27.
 */
@Service
public class DictService {
    /**
     * 字典信息分页查询
     * @param page 分页
     * @return
     */
    public IfPage<DictEntity> getDictList(Page page){
        IfPage<DictEntity> dictListIfPage = new IfPage<DictEntity>();
        dictListIfPage.setPageNum(page.getCurrentPage());
        if(page.getCurrentPage() == 1){
            page.setBegin(0);
        }

        List<DictEntity> dictList = dictDao.findPageList(page);
        dictListIfPage.setDates(dictList);

        //数据总数
        int total = dictDao.findTotal();
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        dictListIfPage.setPageTotal(totalPage);
        return  dictListIfPage;

    }

    public DictEntity findById(int dictId){
        return dictDao.findById(dictId);
    }

    public void save(DictEntity dict){
        int id = dict.getId();
        if(id == 0){
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "字典信息新增");
            dictDao.insert(dict);
        }else{
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "字典信息更新");
            dictDao.update(dict);
        }
    }

    public void delete(String dictIds){
        String[] dictIdArr = dictIds.split(",");
        for(String dictId : dictIdArr){
            //字典信息删除
            dictDao.delete(Integer.parseInt(dictId));
        }
    }

    public List<DictEntity> findByCode(String code){
        return dictDao.findByCode(code);
    }

    @Inject
    private DictDao dictDao;
}
