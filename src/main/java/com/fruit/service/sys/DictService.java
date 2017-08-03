package com.fruit.service.sys;

import com.fruit.common.utils.Servlets;

import com.fruit.dao.sys.DictDao;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;

import com.fruit.entity.sys.DictEntity;
import com.fruit.entity.sys.User;
import com.fruit.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;


@Service
@Transactional
public class DictService {
    @Autowired
    private DictDao dictDao;
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


}
