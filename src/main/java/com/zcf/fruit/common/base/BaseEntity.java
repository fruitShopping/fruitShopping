package com.zcf.fruit.common.base;

import com.zcf.fruit.entity.user.User;
import com.zcf.fruit.util.UserUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * Created by zcf on 2017/6/13.
 */
public abstract class BaseEntity {
    private static final long serialVersionUID = 1L;

    protected String remarks;	// 备注
    protected String createBy;	// 创建者
    protected Date createDate;	// 创建日期
    protected String updateBy;	// 更新者
    protected Date updateDate;	// 更新日期
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        User user = UserUtils.getUser();
        this.updateBy = user.getRealName();
        this.createBy = user.getRealName();
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(){
        User user = UserUtils.getUser();
        this.updateBy = user.getRealName();
        this.updateDate = new Date();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JsonIgnore
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonIgnore
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @JsonIgnore
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
}
