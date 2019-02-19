package com.sunland.dao;

import com.sunland.dto.BussinessInfo;
import com.sunland.pojo.TParkpotBusiness;
import com.sunland.support.mybatis.MybatisMysqlMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TParkpotBusinessMapper extends MybatisMysqlMapper<TParkpotBusiness> {
    void updateBusinessByuuid(Map map);

    List<BussinessInfo> selectparkpotBusinessByuuids(@Param("uuid") String[] uuid);

}