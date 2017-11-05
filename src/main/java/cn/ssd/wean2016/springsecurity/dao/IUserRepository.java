package cn.ssd.wean2016.springsecurity.dao;

import cn.ssd.wean2016.springsecurity.model.domain.SysUser;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<SysUser, Long> {

    SysUser findSysUserByUserName(String userName);

}
