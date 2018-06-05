package com.Travel.butler.service.impl;

import com.Travel.butler.domain.ISysuserroleRepository;
import com.Travel.butler.domain.Sysuserrole;
import com.Travel.butler.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zy on 2017/10/10.
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private ISysuserroleRepository iSysuserroleRepository;

    public List<Sysuserrole> findByUid(long uid){
        return iSysuserroleRepository.findByUid(uid);
    }
}
