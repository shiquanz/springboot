package com.djs.springboot.dao;

import com.djs.springboot.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
// 加载dao接口  必须
@Mapper
@Component
public interface AdminDao {
    //查询出所有管理员
    List<Admin> selectAll();
    //添加管理员
    void insert(Admin admin);
    //删除管理员
    void delete(String[] ids);
    //修改管理员
    void update(Admin admin);
    //查询一条数据
    Admin selectOne(String  id);


}
