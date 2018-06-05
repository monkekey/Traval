package com.Travel.butler.service;

import com.Travel.butler.domain.Sysuserrole;

import java.util.List;

/**
 * Created by zy on 2017/10/10.
 */
public interface SysUserRoleService {
    public List<Sysuserrole> findByUid(long uid);
}
