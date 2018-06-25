package com.Travel.butler.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISuggesstionDao extends PagingAndSortingRepository<Suggesstion, String>, JpaSpecificationExecutor<Suggesstion> {
}
