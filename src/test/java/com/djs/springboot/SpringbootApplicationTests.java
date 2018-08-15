package com.djs.springboot;

import com.djs.springboot.dao.AdminDao;
import com.djs.springboot.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	AdminDao adminDao;

	@Test
	public void contextLoads() {
/*
		// 1. 指定分页策略
		PageHelper.startPage(1,2);
		// 2. 查询所有数据
		List<Admin> admins = adminDao.selectAll();
		// 3. 有pageInfo 完成分页处理
		PageInfo<Admin> info = new PageInfo<Admin>(admins);
		// 4. 拿分页后的结果  获取总条数
		//long total = info.getTotal();
		//System.out.println("总条数："+total);
		List<Admin> list = info.getList();
		for (Admin a:list) {
			System.out.println(a);
		}*/
		// 数据库分页：  内存分页  将数据查询读取至内存中进行分页。 每次每页都是 查询所有数据
		// 物理分页： 需要多少条数据，在数据库中，查询多少条数据。 每次查询。
        Admin admin =new Admin();
        //admin.setV("FFFF");

		adminDao.insert(admin);

	}



}
