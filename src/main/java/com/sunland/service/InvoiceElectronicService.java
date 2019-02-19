package com.sunland.service;

import com.sunland.dto.InvoiceDate;
import com.sunland.pojo.InvoiceElectronic;
import com.sunland.pojo.InvoiceElectronicInfo;
import com.sunland.pojo.json.CreateInvoiceJson;
import com.sunland.pojo.json.HeaderInfo;
import com.sunland.support.mybatis.BaseCRUDService;

import java.util.List;

public interface InvoiceElectronicService extends BaseCRUDService<InvoiceElectronic> {
    HeaderInfo selectHeaderInfoByAccountId(Integer accountId);

    List<HeaderInfo> selectHeaderInfoByname(String name);

    InvoiceDate saveInvoice(CreateInvoiceJson createInvoiceJson,InvoiceElectronicInfo invoiceElectronicInfo);

}
