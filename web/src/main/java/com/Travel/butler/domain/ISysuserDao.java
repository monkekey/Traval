package com.Travel.butler.domain;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by zy on 2017/10/9.
 */
public interface ISysuserDao extends PagingAndSortingRepository<Sysuser, Long>, JpaSpecificationExecutor<Sysuser> {
}
