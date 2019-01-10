package com.sunland.support.mybatis;

import tk.mybatis.mapper.common.base.insert.InsertMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 *
 * <p class="detail">
 * 功能：Mysql数据库的Mapper需要继承此Mapper
 * </p>
 * @ClassName: MybatisMSMapper
 * @version V1.0
 * @param <T>
 */


public interface MybatisMysqlMapper<T> extends AbstractCommonMapper<T>, InsertMapper<T>, InsertSelectiveMapper<T> {
}
