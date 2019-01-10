package com.sunland.support.datasource;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * <p class="detail">
 * 功能:切换数据源切面
 * </p>
 * @ClassName Data source aspect.
 * @Version V1.0.
 */
@Aspect
public class DataSourceAspect {
    
    private static Logger logger = Logger.getLogger(DataSourceAspect.class);
    
    /**
     * <p class="detail">
     * 功能:切入点切换数据源
     * </p>
     * @param point :JoinPoint
     *
     * @throws Exception the exception
     * @author Kings
     * @date 2017.02.13 11:37:14
     */
    public void intercept(JoinPoint point) throws Exception {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        // 默认使用目标类型的注解，如果没有则使用其实现接口的注解
        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
    }
    
    /**
     * <p class="detail">
     * 功能:切换数据源
     * </p>
     * @param clazz  :类
     * @param method :方法
     *
     * @author Kings
     * @date 2017.02.13 11:37:14
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                DataSource source = clazz.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
            }
            // 方法注解可以覆盖类型注解
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
            }
        } catch (Exception e) {
            logger.error("com.gttown.common.support.datasource.DataSourceAspect",e);
        }
    }
}
