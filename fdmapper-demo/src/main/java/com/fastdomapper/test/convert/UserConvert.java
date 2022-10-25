package com.fastdomapper.test.convert;

import org.springframework.stereotype.Component;

import com.dance.coding.fastdomapper.mapper.Mapper;
import com.fastdomapper.test.model.UserModel;
import com.fastdomapper.test.vo.UserVO;

@Component
public class UserConvert extends Mapper<UserVO, UserModel> {

	@Override
	public UserVO mapper(UserModel source, UserVO target) {
		return super.mapper(source, target);
	}
}
