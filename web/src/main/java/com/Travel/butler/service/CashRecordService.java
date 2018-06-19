package com.Travel.butler.service;

import com.Travel.butler.domain.CashRecord;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface CashRecordService {

    public Page<CashRecord> findCashRecord(Integer pageIdx,Integer pageSize,String createTime, Integer success, Integer flag);

    public CashRecord save(CashRecord cashRecord);

    public String updata(CashRecord cashRecord);

    public String delete(String id);

}
