package com.sunland.service;

import com.sunland.pojo.Account;
import com.sunland.pojo.AccountVehicle;
import com.sunland.support.mybatis.BaseCRUDService;

import java.util.List;

public interface AccountService extends BaseCRUDService<Account> {
    Account selectAccountByToken(String token, Integer type);
}
