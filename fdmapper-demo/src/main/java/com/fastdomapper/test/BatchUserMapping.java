package com.fastdomapper.test;

import com.dance.coding.fastdomapper.thread.ITaskHandle;
import com.fastdomapper.test.convert.UserConvert;
import com.fastdomapper.test.model.UserModel;
import com.fastdomapper.test.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatchUserMapping implements ITaskHandle<UserModel, UserVO> {

    @Autowired
    UserConvert userMapping;

    @Override
    public UserVO execute(UserModel userModel) {
        UserVO vo = new UserVO();
        return userMapping.mapper(userModel, vo);
    }
}
