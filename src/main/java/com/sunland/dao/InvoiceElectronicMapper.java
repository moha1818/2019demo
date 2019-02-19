package com.sunland.dao;

import com.sunland.pojo.InvoiceElectronic;
import com.sunland.pojo.json.HeaderInfo;
import com.sunland.support.mybatis.MybatisMysqlMapper;

public interface InvoiceElectronicMapper extends MybatisMysqlMapper<InvoiceElectronic> {

    HeaderInfo selectHeaderInfoByAccountId(Integer accountId);
}