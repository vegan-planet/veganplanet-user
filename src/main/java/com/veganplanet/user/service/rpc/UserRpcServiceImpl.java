package com.veganplanet.user.service.rpc;

import com.veganplanet.user.api.UserRpcService;
import com.veganplanet.user.api.dto.UserDTO;
import com.veganplanet.user.api.vo.UserVO;
import com.veganplanet.user.domain.entity.Users;
import com.veganplanet.user.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * description
 *
 * @date 2023/9/27 23:14
 */
@Slf4j
@Validated
@Service
@DubboService(protocol = "dubbo", version = "2.0.0", retries = 3)
public class UserRpcServiceImpl implements UserRpcService {

    @Resource
    UserService userService;
    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public UserDTO getUserInfo(UserVO userVO) {
        Users user = new Users();
        user.setUserName("姓名"+userVO.getUserNo());
        user = this.userService.userInsert(user);
        if (user != null) {
            throw new RuntimeException("测试异常");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getUserName());
        return userDTO;
    }
}
