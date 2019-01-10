package com.sunland.support.mybatis;

import com.sunland.support.mybatis.provider.CustomDeleteProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Param;


/**
 * <p class="detail">
 * 功能:自定义删除mapper
 * </p>
 * @param <T> the type parameter
 * @ClassName Custom delete mapper.
 * @Version V1.0.
 */
public interface CustomDeleteMapper<T> {
    /**
     * <p class="detail">
     * 功能:根据主键集合或者数组删除
     * </p>
     * @param key :主键
     * @return int
     */
    @DeleteProvider(type = CustomDeleteProvider.class, method = "dynamicSQL")
    int deleteByPrimaryKeys(@Param("ids") Object key);
}
