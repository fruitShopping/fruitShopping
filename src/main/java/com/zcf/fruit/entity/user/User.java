package com.zcf.fruit.entity.user;

import com.google.common.collect.Lists;
import com.zcf.fruit.common.base.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 874713307359614625L;
    private Long id;
    private String username;
    private String password;
    private String telephone;
    private String realName;
    private String identityCardNum;
    private Date addTime;
    private String salt;
    private String loginIp;	// 最后登陆IP
    private Date loginDate;	// 最后登陆日期
    private String photo;	// 头像
    private String email; //邮箱

    private String oldLoginName;// 原登录名
    private String oldPassword;	// 新密码

    private String oldLoginIp;	// 上次登陆IP
    private Date oldLoginDate;	// 上次登陆日期
    private String roleNames;//用户角色字符串
    private String roleIdsStr;//用户角色ID字符串
    private List<Integer> roleIds; //拥有的角色列表
    private  Boolean locked = Boolean.FALSE;//锁
    private String isShow;

    private Role role;	// 根据角色查询用户条件
    private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdentityCardNum() {
        return identityCardNum;
    }

    public void setIdentityCardNum(String identityCardNum) {
        this.identityCardNum = identityCardNum;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getRoleIds() {
        if(roleIds == null) {
            roleIds = new ArrayList<Integer>();
        }
        return roleIds;
    }

    public String getCredentialsSalt() {
        return salt;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOldLoginName() {
        return oldLoginName;
    }

    public void setOldLoginName(String oldLoginName) {
        this.oldLoginName = oldLoginName;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getOldLoginIp() {
        return oldLoginIp;
    }

    public void setOldLoginIp(String oldLoginIp) {
        this.oldLoginIp = oldLoginIp;
    }

    public Date getOldLoginDate() {
        return oldLoginDate;
    }

    public void setOldLoginDate(Date oldLoginDate) {
        this.oldLoginDate = oldLoginDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getRoleIdsStr() {
        return roleIdsStr;
    }

    public void setRoleIdsStr(String roleIdsStr) {
        this.roleIdsStr = roleIdsStr;
    }

    public boolean isAdmin(){
        return isAdmin(this.id);
    }

    public static boolean isAdmin(long id){
        return id != 0 && id == 1;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }
}
