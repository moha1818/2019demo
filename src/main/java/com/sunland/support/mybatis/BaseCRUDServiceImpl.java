package com.sunland.support.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p class="detail">
 * 功能:base crud service
 * </p>
 * @param <T> the type parameter
 * @ClassName Base crud service.
 * @Version V1.0.
 */
@SuppressWarnings ("SpringAutowiredFieldsWarningInspection")
@Service
public abstract class BaseCRUDServiceImpl<T> extends AbstractDBBaseCRUDServiceImpl<T> implements BaseCRUDService<T> {
	/** Mapper. */
	@Autowired
    protected MybatisMysqlMapper<T> mapper ;
	
	@Override
	public AbstractCommonMapper<T> getMapper() {
		return mapper;
	}
	
	/**
	 *
	 * <p class="detail">
	 * 功能：插入一条数据
	 * </p>
	 * @param record:实体
	 * @return int
	 */
	@Override
	public int insert(T record){
		return mapper.insert(record);
	}
	
	/**
	 *
	 * <p class="detail">
	 * 功能：插入一条数据,只插入不为null的字段,不会影响有默认值的字段
	 * </p>
	 * @param record:实体
	 * @return int
	 */
	@Override
	public int insertSelective(T record){
		return mapper.insertSelective(record);
	}
	
	
}