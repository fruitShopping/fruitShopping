package com.zcf.fruit.service.business;

import com.zcf.fruit.dao.mysqlDao.business.BusinessDao;
import com.zcf.fruit.dao.mysqlDao.content.ContentDao;
import com.zcf.fruit.dao.mysqlDao.sys.UserDao;
import com.zcf.fruit.entity.business.BusinessEntity;
import com.zcf.fruit.entity.content.ContentImgEntity;
import com.zcf.fruit.entity.sys.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * 商家信息
 * Created by zcf on 2017/6/25.
 */
@Service
public class BusinessService {

    /**
     * 查询商家信息
     * @param userId 登录用户ID
     * @return 返回值
     */
    public BusinessEntity getInfo(long userId){
        BusinessEntity business = businessDao.get(userId);
        //查询用户信息
        User user = userDao.findByUserId(userId);
        if(business != null){
            //查询图片
            List<ContentImgEntity> imgList = contentDao.getBusImg(business.getId());
            business.setImgList(imgList);
        }else{
            business = new BusinessEntity();
        }

        business.setUser(user);
        return business;
    }

    /**
     * 更新商户信息
     * @param business 商户信息对象
     */
    public void save(BusinessEntity business){
        //更新用户信息
        userDao.updateBusi(business.getUser());
        //跟新商户信息
        int businessId = business.getId();
        if(businessId == 0){
            //新增
            int newId = businessDao.insert(business);
            List<ContentImgEntity> contentImgList = business.getImgList();
            if(contentImgList.size() > 0){
                //添加图片
                for(ContentImgEntity contentImg : contentImgList){
                    contentImg.setContentId(newId);
                    contentDao.insert(contentImg);
                }
            }
        }else{
            //更新
            businessDao.update(business);

            //添加图片
            List<ContentImgEntity> contentImgList = business.getImgList();
            if(contentImgList.size() > 0){
                //删除相关图片
                contentDao.delete(businessId);
                //添加图片
                for(ContentImgEntity contentImg : contentImgList){
                    contentImg.setContentId(businessId);
                    contentDao.insert(contentImg);
                }
            }

        }
    }

    @Inject
    private BusinessDao businessDao;
    @Inject
    private ContentDao contentDao;
    @Inject
    private UserDao userDao;
}
