package com.djs.springboot.service;

import com.djs.springboot.entity.Admin;


import java.util.List;


public interface AdminService {
    List<Admin> selectAll();
    void delete(String [] ids);
    void update(Admin admin);
    void insert(Admin admin);

}
