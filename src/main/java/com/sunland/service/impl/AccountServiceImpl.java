package com.sunland.service.impl;

import com.sunland.dao.AccountMapper;
import com.sunland.dao.AccountVehicleMapper;
import com.sunland.pojo.Account;
import com.sunland.pojo.AccountVehicle;
import com.sunland.service.AccountService;
import com.sunland.support.mybatis.BaseCRUDServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl extends BaseCRUDServiceImpl<Account> implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private AccountVehicleMapper accountVehicleMapper;

    @Override
    public Account selectAccountByToken(String token, Integer type) {
        Account account = new Account();
        if(type == 0){
            //手机号
            account.setMobilenum(token);
        }else {
            //微信token
            account.setUtoken(token);
        }
        List<Account> accountList = accountMapper.select(account);
        if (accountList!=null && accountList.size()>0){
            account = accountList.get(0);
        }else {
            return null;
        }
        return account;
    }

    private List<AccountVehicle> selectAccountVehicleByAccountId(Integer accountId){
        AccountVehicle accountVehicle = new AccountVehicle();
        accountVehicle.setAccountid(accountId);
        List<AccountVehicle> result = accountVehicleMapper.select(accountVehicle);
        return result;
    }
}
