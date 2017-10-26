package cn.zain.service;

import cn.zain.model.entity.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Zain
 */
public interface SysUserService {
    Logger logger = LogManager.getLogger();

    /**
     * 根据用户名查询系统用户信息
     *
     * @param username String
     * @return SysUser
     */
    SysUser selectByUsername(String username);
}
