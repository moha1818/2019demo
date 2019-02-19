package com.sunland.dao;

import com.sunland.dto.BussinessInfo;
import com.sunland.pojo.TBusiness;
import com.sunland.pojo.json.PaymentList;
import com.sunland.support.mybatis.MybatisMysqlMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TBusinessMapper extends MybatisMysqlMapper<TBusiness> {
    List<PaymentList> selectBussinessList(Map map);
    List<PaymentList> selectParkpotBussinessList(Map map);

    void updateBusinessByuuid(Map map);

    List<BussinessInfo> selectparkpointBusinessByuuids(@Param("uuid")String[] uuid);
}