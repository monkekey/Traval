package com.Travel.butler.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface ReleaseInfoRepository extends JpaRepository<ReleaseInfo,String> {

}
