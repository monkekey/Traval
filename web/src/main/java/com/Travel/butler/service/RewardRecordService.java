package com.Travel.butler.service;

import com.Travel.butler.domain.RewardRecord;
import org.springframework.data.domain.Page;

public interface RewardRecordService {

    public Page<RewardRecord> findRewardRecord(Integer pageIdx, Integer pageSize, String createTime, Integer isPay, Integer flag);

    public RewardRecord save(RewardRecord cashRecord);

    public String updata(RewardRecord cashRecord);

    public String delete(String id);

}
