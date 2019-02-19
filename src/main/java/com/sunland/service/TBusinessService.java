package com.sunland.service;

import com.sunland.pojo.Account;
import com.sunland.pojo.TBusiness;
import com.sunland.pojo.json.PaymentList;
import com.sunland.support.mybatis.BaseCRUDService;

import java.util.List;

public interface TBusinessService extends BaseCRUDService<TBusiness> {
    List<PaymentList> selecBussinessList(String mobilenum, String utoken, Integer type);
}
