package com.sunland.service.impl;

import com.sunland.dao.TBusinessMapper;
import com.sunland.dao.TParkpotBusinessMapper;
import com.sunland.pojo.TBusiness;
import com.sunland.pojo.json.PaymentList;
import com.sunland.service.TBusinessService;
import com.sunland.support.mybatis.BaseCRUDServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TBusinessServiceImpl extends BaseCRUDServiceImpl<TBusiness> implements TBusinessService {
    @Resource
    private TParkpotBusinessMapper tParkpotBusinessMapper;
    @Resource
    private TBusinessMapper tBusinessMapper;

    public List<PaymentList> selecBussinessList(String mobilenum,String utoken,Integer type){
        List<PaymentList> resultList = null;
        if(type == 1){
            //resultList = tBusinessMapper.selectBussinessList(mobilenum,utoken);
        }else if(type == 2){
            //resultList = tParkpotBusinessMapper.selectParkpotBussinessList(mobilenum,utoken);
        }
        return resultList;
    }
}
