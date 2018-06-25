package com.Travel.butler.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUpvoteDao extends PagingAndSortingRepository<Upvote, String>, JpaSpecificationExecutor<Upvote> {
}
