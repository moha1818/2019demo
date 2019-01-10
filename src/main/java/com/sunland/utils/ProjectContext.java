/*
 * Copyright (c) 2005 Your Corporation. All Rights Reserved.
 */
package com.sunland.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * 一个对ApplicationContext进行封装的类,在程序启动后只会有一个这样的实例,接口的具体定义请参考ApplicationContext
 * Created by lq on 16/02/2.
 */
public class ProjectContext {
    public static ApplicationContext context;

    public static ApplicationContext getParent() {
        return context.getParent();
    }

    public static String getDisplayName() {
        return context.getDisplayName();
    }

    public static long getStartupDate() {
        return context.getStartupDate();
    }

    public static void publishEvent(ApplicationEvent event) {
        context.publishEvent(event);
    }

    public static boolean containsBeanDefinition(String beanName) {
        return context.containsBeanDefinition(beanName);
    }

    public static int getBeanDefinitionCount() {
        return context.getBeanDefinitionCount();
    }

    public static String[] getBeanDefinitionNames() {
        return context.getBeanDefinitionNames();
    }

    public static String[] getBeanNamesForType(Class type) {
        return context.getBeanNamesForType(type);
    }

    public static String[] getBeanNamesForType(Class type, boolean includePrototypes, boolean includeFactoryBeans) {
        return context.getBeanNamesForType(type, includePrototypes, includeFactoryBeans);
    }

    public static Map getBeansOfType(Class type) throws BeansException {
        return context.getBeansOfType(type);
    }

    public static Map getBeansOfType(Class type, boolean includePrototypes, boolean includeFactoryBeans) throws BeansException {
        return context.getBeansOfType(type, includePrototypes, includeFactoryBeans);
    }

    public static Object getBean(String name) throws BeansException {
//        AbstractApplicationContext ctx
//                = new ClassPathXmlApplicationContext(new String []{"srping-beans.xml"});

        return context.getBean(name);
    }

    public static Object getBean(String name, Class type) throws BeansException {
        return context.getBean(name, type);
    }

    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return context.isSingleton(name);
    }

    public static Class getType(String name) throws NoSuchBeanDefinitionException {
        return context.getType(name);
    }

    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return context.getAliases(name);
    }

    public static BeanFactory getParentBeanFactory() {
        return context.getParentBeanFactory();
    }

    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return context.getMessage(code, args, defaultMessage, locale);
    }

    public static String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return context.getMessage(code, args, locale);
    }

    public static String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return context.getMessage(resolvable, locale);
    }

    public static Resource[] getResources(String locationPattern) throws IOException {
        return context.getResources(locationPattern);
    }

    public static Resource getResource(String location) {
        return context.getResource(location);
    }

    /**
     * 获取数据库连接池
     *
     * @return 连接池对象
     */
    public static DataSource getDataSource() {
        return (DataSource) getBean("DataSource");
    }

}
