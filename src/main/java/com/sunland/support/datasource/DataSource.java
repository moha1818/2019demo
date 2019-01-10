package com.sunland.support.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p class="detail">
 * 功能:Datasource注解,用于切面
 * </p>
 * @ClassName Data source.
 * @Version V1.0.
 */
@Retention (RetentionPolicy.RUNTIME)
@Target ({ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {
    //key 值
    String value();
}
