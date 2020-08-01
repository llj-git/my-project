package com.llj.service.impl;

import com.llj.dao.IRoleDao;
import com.llj.domain.Permission;
import com.llj.domain.Role;
import com.llj.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public void deleteRoleById(String roleId) {

        roleDao.deleteFromUser_RoleByRoleId(roleId);

        roleDao.deleteFromRole_PermissionByRoleId(roleId);

        roleDao.deleteRoleById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findAll() throws Exception{
        return roleDao.findAll();
    }
}
