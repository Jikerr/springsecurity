package cn.ssd.wean2016.springsecurity.controller;


import cn.ssd.wean2016.springsecurity.dao.IUserRepository;
import cn.ssd.wean2016.springsecurity.model.domain.SysRole;
import cn.ssd.wean2016.springsecurity.model.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;


@Controller
public class TestController {

    @Autowired
    private IUserRepository userRepository;

    @RequestMapping(value="testGetUser")
    public @ResponseBody  String testGetUser(){
        SysUser user = userRepository.findSysUserByUserName("guest");
        Set<SysRole> roles = user.getRoles();


        for(SysRole role : roles){
            System.out.println(role.getRoleName());
        }

        System.out.println(user.toString());
        return "success";
    }

}
