package com.sunland.support.mybatis;

import com.sunland.support.mybatis.provider.CustomSelectProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;


/**
 * <p class="detail">
 * 功能:自定义查询mapper
 * </p>
 * @param <T> the type parameter
 * @ClassName Custom select mapper.
 * @Version V1.0.
 */
public interface CustomSelectMapper<T> {
    /**
     * <p class="detail">
     * 功能:根据主键集合或数组查询,如果传入空值,则返回整张表全部结果
     * </p>
     * @param ids :主键集合
     * @return list
     */
    @SelectProvider (type = CustomSelectProvider.class, method = "dynamicSQL")
    List<T> selectByPrimaryKeys(@Param("ids") Object ids);
}
