package com.djs.springboot.service.impl;

import com.djs.springboot.dao.AdminDao;
import com.djs.springboot.entity.Admin;
import com.djs.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    public List<Admin>  selectAll(){
        return adminDao.selectAll();
    }

    @Override
    @Transactional
    public void delete(String[] ids) {
        adminDao.delete(ids);
    }

    @Override
    @Transactional
    public void update(Admin admin) {
        Admin admin1=adminDao.selectOne(admin.getId());
        System.out.println(admin1);
        admin.setVersion(admin1.getVersion());
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adminDao.update(admin);
    }

    @Override
    @Transactional
    public void insert(Admin admin) {
        //admin.setV("FFFF");
        adminDao.insert(admin);
    }




}
