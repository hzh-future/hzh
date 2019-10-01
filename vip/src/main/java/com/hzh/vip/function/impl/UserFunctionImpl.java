package com.hzh.vip.function.impl;

import com.hzh.common.ThisSystemException;
import static com.hzh.common.ThisSystemUtil.*;

import com.hzh.common.ThisSystemUtil;
import com.hzh.common.ThisSystemUtilGon;
import com.hzh.vip.dao.UserDao;
import com.hzh.vip.entity.ClientEntity;
import com.hzh.vip.entity.UserEntity;
import com.hzh.vip.entity.VIPEntity;
import com.hzh.vip.function.UserFunction;
import com.mysql.fabric.xmlrpc.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class UserFunctionImpl implements UserFunction {

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity login(String account, String password) throws Exception {
        /*if(account == null ||account.trim().length() == 0){
            throw new ThisSystemException("账户不能为空！");
        }*/
        account = $("账户不能为空",account);
        password = $("账户密码不能为空",password);
        password = ThisSystemUtilGon.md5(password);
        UserEntity u = userDao.select("account",account);
        if(u == null){
            throw  new ThisSystemException("账户不存在");
        }
        if(!u.getPassword().equals(password)){
            throw  new ThisSystemException("密码错误");
        }
        return u;
    }

    @Override
    public UserEntity updatePassword(String id, String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //验证参数
        id = $("id不能为空",id);
        oldPassword = ThisSystemUtilGon.md5(oldPassword);
        newPassword = ThisSystemUtilGon.md5(newPassword);
        newPasswordConfirm = ThisSystemUtilGon.md5(newPasswordConfirm);
        oldPassword = $("旧密码不能为空",oldPassword);
        newPassword = $("新密码不能为空",newPassword);
        newPasswordConfirm = $("确认密码不能为空",newPasswordConfirm);
        assertNotEquals("旧密码和新密码不能一样",oldPassword,newPassword);
        assertEquals("两次密码不一致",newPassword,newPasswordConfirm);
        //找到用户
        UserEntity u = userDao.select("id",id);
        /*if(u == null){
            throw new ThisSystemException("无法找到用户");
        }*/
        assertNotNull("无法找到用户",u);
        //验证旧密码
        assertEquals("旧密码不正确",u.getPassword(),oldPassword);
        //更新密码
        u.setPassword(newPassword);
        userDao.update(u);
        return u;
    }

    @Override
    public void InsertClient(String code, String name, int money) throws Exception {
        code = $("电话不能为空",code);
        name = $("姓名不能为空",name);
        ClientEntity client = new ClientEntity();
        client.setCode(code);
        client.setName(name);
        client.setMoney(money);
        client.setDengji(Grade(money));
        client.setXia(UpGrade(money));
        System.out.println("这里是client对象："+client);
        userDao.insertClient(client);
    }

    @Override
    public ClientEntity selectClient(String code) throws Exception {
        code = $("电话不能为空",code);
        ClientEntity clientEntity = userDao.selectClient(code);
        return clientEntity;
    }

    @Override
    public int VipInsert(String code, String project, String x_je) throws Exception {
        VIPEntity vipEntity = new VIPEntity();
        //验证是否为空
        code = $("电话为空，请输入",code);
        project = $("您选择的项目为空",project);
        x_je = $("你的消费金额为空",x_je);
        //查询该号码的VIP是否存在
        ClientEntity client = selectClient(code);
        System.out.println("这里是VipInser的vip用户"+client);
        //不存在报错
        assertNotNull("您的电话输入错误,查询不到",client);
        //获取当前时间
        Date date = new Date();
        String fmt = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String dateStr = sdf.format(date).toString();

        //类型转换
        int je = Integer.parseInt(x_je);
        //把数据输入到实体类中
        vipEntity.setCode(code);
        vipEntity.setName(client.getName());
        vipEntity.setX_date(dateStr);
        vipEntity.setX_project(project);
        vipEntity.setX_je(je);
        System.out.println(vipEntity);
        //更新客户的积分
        client.setMoney(client.getMoney()+je);
        client.setDengji(Grade(client.getMoney()));
        client.setXia(UpGrade(client.getMoney()));
        userDao.vipUpdate(client);
        //插入数据
        int res = userDao.vipInsert(vipEntity);
        assertIntNull("数据插入失败",res);

        return res;
    }

    @Override
    public List<VIPEntity> selectAllX() throws Exception {
        List<VIPEntity> list = userDao.selectAllX();
        System.out.println(list);
        assertNotNull("查询出错",list);
        return list;
    }

    @Override
    public List<VIPEntity> selectCodeAllX(String code) throws Exception {
        List<VIPEntity> list = userDao.selectCodeAllX(code);
        System.out.println(list);
        if (list == null){
            throw new ThisSystemException("查询的电话错误或该电话没有注册VIP");
        }
        return list;
    }

    @Override
    public List<ClientEntity> selectAllC() throws Exception {
        List<ClientEntity> list = null;
        list = userDao.selectAllC();
        if (list == null){
            throw new ThisSystemException("VIP客户查询出错");
        }
        return list;
    }

    @Override
    public List<ClientEntity> selectCodeAllC(String code) throws Exception {
        List<ClientEntity> list = null;
        list = userDao.selectCodeAllC(code);
        if (list == null){
            throw new ThisSystemException("你输入的电话错误导致VIP客户查询出错");
        }
        System.out.println(list);
        return list;
    }

    @Override
    public int UpdateClient(String id, String code, String name) throws Exception {
        System.out.println("impl: "+id+"--"+code+"--"+name);
        int i = Integer.parseInt(id);
        String phone = userDao.selectIdClient(i);
        System.out.println("phone::"+phone);
        int resl = userDao.updateRecord(code,name,phone);
        System.out.println("resl:"+resl);
        int res = userDao.updateClient(i,code,name);
        return res;
    }

    @Override
    public void ClientDelete(String id,String code) throws Exception {
        int i = Integer.parseInt(id);
        userDao.consumeDelete(code);
        userDao.clientDelete(i);
//        return res;
    }
}
