package com.Travel.butler.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRewardRecordDao extends PagingAndSortingRepository<RewardRecord, String>, JpaSpecificationExecutor<RewardRecord> {
}
