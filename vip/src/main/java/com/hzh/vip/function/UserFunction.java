package com.hzh.vip.function;

import com.hzh.vip.entity.ClientEntity;
import com.hzh.vip.entity.UserEntity;
import com.hzh.vip.entity.VIPEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserFunction {

    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    public UserEntity login(String account,String password)throws Exception;

    /**
     * 修改密码
     * @param lodPassword
     * @param newPassword
     * @param newPasswordConfirm
     * @return
     * @throws Exception
     */
    @Transactional
    public UserEntity updatePassword(String id, String lodPassword, String newPassword, String newPasswordConfirm) throws Exception;


    /**
     * VIP客户注册
     * @param code
     * @param name
     * @param money
     * @return
     */
    public void InsertClient(String code,String name,int money) throws Exception;


    /**
     * VIP客户查询
     * @param code
     * @return
     * @throws Exception
     */
    public ClientEntity selectClient(String code) throws Exception;


    /**
     * VIP消费记录录入
     * @param code
     * @param x_project
     * @param x_je
     * @throws Exception
     */
    public int VipInsert(String code,String x_project,String x_je) throws  Exception;

    /**
     *VIP消费记录查询
     * @return
     * @throws Exception
     */
    public List<VIPEntity> selectAllX() throws Exception;

    /**
     * 指定VIP消费记录查询
     * @param code
     * @return
     * @throws Exception
     */
    public List<VIPEntity> selectCodeAllX(String code) throws Exception;

    /**
     * 查询全部VIP客户
     * @return
     * @throws Exception
     */
    public List<ClientEntity> selectAllC() throws Exception;

    /**
     * 查询指定VIP客户
     * @param code
     * @return
     * @throws Exception
     */
    public List<ClientEntity> selectCodeAllC(String code) throws Exception;

    /**
     * 修改VIP客户信息
     * @param id
     * @param code
     * @param name
     * @return
     * @throws Exception
     */
    public int UpdateClient(String id,String code,String name) throws Exception;

    /**
     * 删除VIP客户
     * @param id
     * @return
     * @throws Exception
     */
    public void ClientDelete(String id,String code) throws Exception;

}
