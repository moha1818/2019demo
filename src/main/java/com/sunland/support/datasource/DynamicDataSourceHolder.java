package com.sunland.support.datasource;

/**
 * <p class="detail">
 * 功能:数据源类型管理工具,用于持有当前线程中使用的数据源标识
 * </p>
 * @ClassName Dynamic data source holder.
 * @Version V1.0.
 */
public class DynamicDataSourceHolder {
    /** The constant THREAD_DATA_SOURCE. */
    //考虑多线程，为保证线程之间操作数据源时互不干扰，所以使用ThreadLocal作线程隔离
    protected static final ThreadLocal<String> THREAD_DATA_SOURCE = new ThreadLocal<String>();
    
    public static String getDataSource() {
        return THREAD_DATA_SOURCE.get();
    }
    
    /**
     * Sets data source.
     * @param dataSource the data source
     */
    public static void setDataSource(String dataSource) {
        THREAD_DATA_SOURCE.set(dataSource);
    }
    
    /**
     * <p class="detail">
     * 功能:
     * </p>
     */
    public static void clearDataSource() {
        THREAD_DATA_SOURCE.remove();
    }
}
