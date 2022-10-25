package com.fastdomapper.test;

import com.dance.coding.fastdomapper.thread.IMulThreadService;
import com.dance.coding.fastdomapper.thread.TaskMulThreadService;
import com.fastdomapper.test.convert.UserConvert;
import com.fastdomapper.test.model.UserModel;
import com.fastdomapper.test.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FastdomapperApplication implements CommandLineRunner {
	@Autowired
	UserConvert userMapping;
	@Autowired
	BatchUserMapping batchUserMapping;

	public static void main(String[] args) {
		SpringApplication.run(FastdomapperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserModel us = new UserModel();
		us.setName("abc");
		UserVO vo = new UserVO();
		System.out.println(userMapping.mapper(us, vo).getUserName());

		List<UserModel> userModelList = new ArrayList<>();
		UserModel userModel1 = new UserModel();
		userModel1.setName("测试1");

		UserModel userModel2 = new UserModel();
		userModel2.setName("测试2");

		UserModel userModel3 = new UserModel();
		userModel3.setName("测试3");

		UserModel userModel4 = new UserModel();
		userModel4.setName("测试4");
		userModelList.add(userModel1);
		userModelList.add(userModel2);
		userModelList.add(userModel3);
		userModelList.add(userModel4);

		//多线程
		IMulThreadService<UserModel, UserVO> mulThreadService = new TaskMulThreadService(batchUserMapping);
		long start = System.currentTimeMillis();
		List<UserVO> result = mulThreadService.execute(userModelList);
		for (UserVO e : result){
			System.out.println("result:" +  e.getUserName());
		}
		System.out.println("所有任务处理完成，耗时"+(System.currentTimeMillis()-start)+",任务成功数"+result.size());
	}

}
