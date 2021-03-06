/*
 * 版权所有(C) 浙江大道网络科技有限公司2011-2020
 * Copyright 2009-2020 Zhejiang GreatTao Factoring Co., Ltd.
 *   
 * This software is the confidential and proprietary information of
 * Zhejiang GreatTao Corporation ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Zhejiang GreatTao
 */
package com.sunland.support.mybatis;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p class="detail">
 * 功能:dbservice
 * </p>
 * @param <T> the type parameter
 *
 * @ClassName Abstract db base crud service.
 * @Version V1.0.
 */
@SuppressWarnings(value = "unchecked")
@Service
public abstract class AbstractDBBaseCRUDServiceImpl<T> implements BaseCRUDService<T> {

    private static final int PAGE_SIZE_LIMIT = 9999;
    
    /** The constant logger. */
    private static final Logger logger = Logger.getLogger(AbstractDBBaseCRUDServiceImpl.class);
    
    /**
     * <p class="detail">
     * 功能:处理成制定的页码
     * </p>
     * @param pageSize :传入页码
     *
     * @return int
     */
    private int dealPageSize(int pageSize){
        if (pageSize > PAGE_SIZE_LIMIT) {
            return PAGE_SIZE_LIMIT;
        } else {
            return pageSize;
        }
    }
    
    @Override
    public PageInfo selectPage(PageInfo pageInfo, T record) throws Exception {
        try {
            int pageNum = pageInfo.getPageNum() == 0 ? 1 : pageInfo.getPageNum();//处理空值
            String pageSizeStr = "";
            int pageSize = pageInfo.getPageSize() == 0 ? Integer.parseInt(StringUtils.isBlank(pageSizeStr) ? "15" : pageSizeStr) : dealPageSize(pageInfo.getPageSize());
            PageHelper.startPage(pageNum, pageSize);
            Method methodReflect = getMapper().getClass().getInterfaces()[0].getMethod("select", Object.class);
            List<T> list = (List<T>) methodReflect.invoke(getMapper(), record);
            BeanUtils.copyProperties(pageInfo, new PageInfo<>(list));
            return pageInfo;
        } catch (Exception e) {
            logger.error("com.gttown.common.support.mybatis.AbstractDBBaseCRUDServiceImpl", e);
            throw e;
        }
    }
    
    @Override
    public PageInfo selectPage(PageInfo pageInfo, T record, String orderbyString) throws Exception {
        try {
            
            int pageNum = pageInfo.getPageNum() == 0 ? 1 : pageInfo.getPageNum();//处理空值
            String pageSizeStr = "";
            int pageSize = pageInfo.getPageSize() == 0 ? Integer.parseInt(StringUtils.isBlank(pageSizeStr) ? "15" : pageSizeStr) : dealPageSize(pageInfo.getPageSize());
            
            PageHelper.startPage(pageNum, pageSize);
            PageHelper.orderBy(orderbyString);
            Method methodReflect = getMapper().getClass().getInterfaces()[0].getMethod("select", Object.class);
            
            List<T> list = (List<T>) methodReflect.invoke(getMapper(), record);
            BeanUtils.copyProperties(pageInfo, new PageInfo<>(list));
            return pageInfo;
        } catch (Exception e) {
            logger.error("com.gttown.common.support.mybatis.AbstractDBBaseCRUDServiceImpl", e);
            throw e;
        }
    }
    
    @Override
    public PageInfo selectPage(PageInfo pageInfo, String method, Map<String, Object> param, boolean count, String orderBy) throws Exception {
        int pageNum = pageInfo.getPageNum() == 0 ? 1 : pageInfo.getPageNum();//处理空值
        String pageSizeStr = "";
        int pageSize = pageInfo.getPageSize() == 0 ? Integer.parseInt(StringUtils.isBlank(pageSizeStr) ? "15" : pageSizeStr) : dealPageSize(pageInfo.getPageSize());
        //Spring4支持泛型注入
        Class[] cArg = new Class[1];
        cArg[0] = Map.class;
        Method methodReflect = getMapper().getClass().getInterfaces()[0].getDeclaredMethod(method, cArg);
        PageHelper.startPage(pageNum, pageSize, orderBy).setCount(count);
        List list = (List) methodReflect.invoke(getMapper(), param);
        BeanUtils.copyProperties(pageInfo, new PageInfo<Map>(list));
        return pageInfo;
    }
    
    @Override
    @SuppressWarnings ( {"unchecked", "rawtypes"})
    public PageInfo selectPage(PageInfo pageInfo, String method, Map<String, Object> param) throws Exception {
        int pageNum = pageInfo.getPageNum() == 0 ? 1 : pageInfo.getPageNum();//处理空值
        String pageSizeStr = "";
        int pageSize = pageInfo.getPageSize() == 0 ? Integer.parseInt(StringUtils.isBlank(pageSizeStr) ? "15" : pageSizeStr) : dealPageSize(pageInfo.getPageSize());
        //Spring4支持泛型注入
        Class[] cArg = new Class[1];
        cArg[0] = Map.class;
        Method methodReflect = getMapper().getClass().getInterfaces()[0].getDeclaredMethod(method, cArg);
        PageHelper.startPage(pageNum, pageSize);
        List list = (List) methodReflect.invoke(getMapper(), param);
        BeanUtils.copyProperties(pageInfo, new PageInfo<Map>(list));
        return pageInfo;
    }
    
    @Override
    @SuppressWarnings ( {"unchecked", "rawtypes"})
    public PageInfo<T> selectPage(PageInfo pageInfo, String method, T record) throws Exception {
        try {
            int pageNum = pageInfo.getPageNum() == 0 ? 1 : pageInfo.getPageNum();//处理空值
            String pageSizeStr = "";
            int pageSize = pageInfo.getPageSize() == 0 ? Integer.parseInt(StringUtils.isBlank(pageSizeStr) ? "15" : pageSizeStr) : dealPageSize(pageInfo.getPageSize());
            PageHelper.startPage(pageNum, pageSize);
            //Spring4支持泛型注入
            Class[] cArg = new Class[1];
            cArg[0] = record.getClass();
            Method methodReflect = getMapper().getClass().getInterfaces()[0].getDeclaredMethod(method, cArg);
            List<T> list = (List<T>) methodReflect.invoke(getMapper(), record);
            BeanUtils.copyProperties(pageInfo, new PageInfo<>(list));
            return pageInfo;
        } catch (Exception e) {
            logger.error("com.gttown.common.support.mybatis.AbstractDBBaseCRUDServiceImpl", e);
            throw e;
        }
    }
    
    @Override
    public PageInfo selectPage(PageInfo pageInfo, String method, Map<String, Object> param, String orderBy) throws Exception {
        int pageNum = pageInfo.getPageNum() == 0 ? 1 : pageInfo.getPageNum();//处理空值
        String pageSizeStr = "";
        int pageSize = pageInfo.getPageSize() == 0 ? Integer.parseInt(StringUtils.isBlank(pageSizeStr) ? "15" : pageSizeStr) : dealPageSize(pageInfo.getPageSize());
        //Spring4支持泛型注入
        Class[] cArg = new Class[1];
        cArg[0] = Map.class;
        Method methodReflect = getMapper().getClass().getInterfaces()[0].getDeclaredMethod(method, cArg);
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy(orderBy);
        List list = (List) methodReflect.invoke(getMapper(), param);
        BeanUtils.copyProperties(pageInfo, new PageInfo<Map>(list));
        return pageInfo;
    }
    
    @Override
    @SuppressWarnings ( {"unchecked", "rawtypes"})
    public PageInfo<T> selectPage(PageInfo pageInfo, String method, T record, String orderBy) throws Exception {
        try {
            int pageNum = pageInfo.getPageNum() == 0 ? 1 : pageInfo.getPageNum();//处理空值
            String pageSizeStr = "";
            int pageSize = pageInfo.getPageSize() == 0 ? Integer.parseInt(StringUtils.isBlank(pageSizeStr) ? "15" : pageSizeStr) : dealPageSize(pageInfo.getPageSize());
            PageHelper.startPage(pageNum, pageSize);
            PageHelper.orderBy(orderBy);
            //Spring4支持泛型注入
            Class[] cArg = new Class[1];
            cArg[0] = record.getClass();
            Method methodReflect = getMapper().getClass().getInterfaces()[0].getDeclaredMethod(method, cArg);
            List<T> list = (List<T>) methodReflect.invoke(getMapper(), record);
            BeanUtils.copyProperties(pageInfo, new PageInfo<>(list));
            return pageInfo;
        } catch (Exception e) {
            logger.error("com.gttown.common.support.mybatis.AbstractDBBaseCRUDServiceImpl", e);
            throw e;
        }
    }
    
    @Override
    public T selectOne(T record) {
        return getMapper().selectOne(record);
        
    }
    
    @Override
    public T selectByPrimaryKey(Object obj) {
        return getMapper().selectByPrimaryKey(obj);
    }
    
    @Override
    public List<T> select(T record) {
        return getMapper().select(record);
    }
    
    @Override
    public int selectCount(T record) {
        return getMapper().selectCount(record);
    }
    
    @Override
    public List<T> selectByPrimaryKeys(@SuppressWarnings ("rawtypes") Object ids) {
        return getMapper().selectByPrimaryKeys(ids);
    }
    
    @Override
    public List<T> selectByExample(Object example) {
        return getMapper().selectByExample(example);
    }
    
    @Override
    public int delete(T record) {
        return getMapper().delete(record);
    }
    
    @Override
    public int deleteByPrimaryKey(Object key) {
        return getMapper().deleteByPrimaryKey(key);
    }
    
    @Override
    public int deleteAll(Collection<T> record) {
        int idx = 0;
        for (T t : record) {
            getMapper().delete(t);
            idx++;
        }
        return idx;
    }
    
    @Override
    public int deleteByPrimaryKeys(Object ids) {
        return getMapper().deleteByPrimaryKeys(ids);
    }
    
    @Override
    public int updateByPrimaryKey(T record) {
        return getMapper().updateByPrimaryKey(record);
    }
    
    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }
    
    @Override
    public int updateByExample(@Param ("record") T record, @Param ("example") Object example) {
        return getMapper().updateByExample(record, example);
    }
    
    @Override
    public int updateByExampleSelective(@Param ("record") T record, @Param ("example") Object example) {
        return getMapper().updateByExampleSelective(record, example);
    }
    
    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }
    
    protected abstract AbstractCommonMapper<T> getMapper();

    @Override
    public int selectCountByExample(Object example){
        return getMapper().selectCountByExample(example);
    }

    @Override
    public int deleteByExample(Object example){
        return getMapper().deleteByExample(example);
    }
}
