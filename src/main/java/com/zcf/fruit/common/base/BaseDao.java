package com.zcf.fruit.common.base;

import com.zcf.fruit.entity.Page;

import java.util.List;

/**
 * Created by zcf on 2017/6/13.
 */
public interface BaseDao<T> {
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(long id);

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T get(T entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     * @param entity
     * @return
     */
    public List<T> findList(T entity);

    /**
     * 分页查询
     * @param page
     * @return
     */
    public List<T> findPageList(Page page);

    /**
     * 查询全部数据
     * @return
     */
    public int findTotal();

    /**
     * 查询所有数据列表
     * @param entity
     * @return
     */
    public List<T> findAllList(T entity);

    /**
     * 查询所有数据列表
     * @see public List<T> findAllList(T entity)
     * @return
     */
    @Deprecated
    public List<T> findAllList();

    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * @param id
     * @see public int delete(T entity)
     * @return
     */
    @Deprecated
    public int delete(int id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * @param entity
     * @return
     */
    public int delete(T entity);

}
