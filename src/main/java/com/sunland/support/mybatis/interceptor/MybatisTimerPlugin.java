package com.sunland.support.mybatis.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        ),
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
        ),
})
public class MybatisTimerPlugin implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(MybatisTimerPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long begin = System.currentTimeMillis();
        Object ret = invocation.proceed();
        long end = System.currentTimeMillis();

        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        logger.debug("Query costs {} ms\n{}", end - begin, ms.getBoundSql(invocation.getArgs()[1]).getSql());
        return ret;
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
