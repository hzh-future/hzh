package com.hzh.vip.web.handler;


import com.hzh.common.ThisSystemException;
import com.hzh.vip.entity.ClientEntity;
import com.hzh.vip.entity.UserEntity;
import com.hzh.vip.entity.VIPEntity;
import com.hzh.vip.function.UserFunction;
import com.hzh.vip.function.impl.UserFunctionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
public class LoginHandler {

    @Autowired
    UserFunction fun;

    @RequestMapping(value = "/login.do")
    public String login(String account, String password, HttpServletRequest request){
        String ac = request.getParameter("account");
        String pa = request.getParameter("password");
        try{
            UserEntity u = fun.login(account,password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",u);
        }catch (Exception e){
            request.setAttribute("message",e.getMessage());
            return "forward:/login.jsp";
        }
        return "redirect:/index.do";
    }

    @RequestMapping("/index.do")
    public String index(){
        return "index";
    }

    @RequestMapping("/welcome.do")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        //让session失效
        session.invalidate();
        return "redirect:/login.jsp";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/updatepassword.do")
    public String updatepasswordView(){
        return "updatepassword";
    }

    @RequestMapping(method = RequestMethod.POST,path = "/updatepassword.do")
    public String updatePassword(String oldPassword,String newPassword,String newPasswordConfirm,HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        UserEntity u = (UserEntity) session.getAttribute("currentUser");
        try{
            fun.updatePassword(u.getId(),oldPassword,newPassword,newPasswordConfirm);
        }catch(ThisSystemException e){
            request.setAttribute("message",e.getMessage());
            return "updatepassword";
        }
        request.setAttribute("message","修改成功，请重新登录");
        return "redirect:/login.jsp";
    }

    @RequestMapping(method=RequestMethod.GET,path = "/client.do")
    public String Clientc(){
        return "client";
    }

    @RequestMapping(method=RequestMethod.POST,path = "/client.do")
    public String Client(String code,String name,int money,HttpServletRequest request){
        try{
            fun.InsertClient(code,name,money);
        }catch(ThisSystemException e){
            request.setAttribute("message","添加失败");
            return "client";
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("message","VIP客户注册成功");
        return "forward:/welcome.do";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/selectclient.do")
    public String SelectClient(){
        return "selectclient";
    }

    @RequestMapping(method = RequestMethod.POST,path = "/selectclient.do")
    public String SelectClient(String code,HttpServletRequest req){
        HttpSession session = req.getSession();
        ClientEntity clientEntity = null;
        try{
            clientEntity =  fun.selectClient(code);
        }catch(ThisSystemException e){
            req.setAttribute("message","查询失败");
            return "selectclient";
        }
        catch(Exception e){
            req.setAttribute("message","查询失败");
        }
        System.out.println("这里是Controller层的输出："+clientEntity);
        if(clientEntity == null){
            req.setAttribute("message","当前用户不存在！");
        }
        req.setAttribute("client",clientEntity);
//        req.setAttribute("");
        return "forward:/WEB-INF/views/selectclient.jsp";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/vipinsert.do")
    public String VipInsert(){
        return "vipinsert";
    }

    @RequestMapping(method = RequestMethod.POST,path = "/vipinsert.do")
    public String VipInsert(String code,String x_je,HttpServletRequest request){
        if(x_je == ""){
            //通过电话获取姓名
            ClientEntity client = null;
            try {
                client= fun.selectClient(code);
            } catch (Exception e) {
                request.setAttribute("message",e.getMessage());
            }
            //获取当前时间
            Date date = new Date();
            String fmt = "yyyy-MM-dd hh:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            String dateStr = sdf.format(date).toString();
            //把数据放到request中
            request.setAttribute("dateStr",dateStr);
            request.setAttribute("client",client);
            return "forward:/WEB-INF/views/vipinsert.jsp";
        }

        String[] x_project = request.getParameterValues("x_project");
        //把数组转换成字符串
        String project = Arrays.toString(x_project).toString();
//        ClientEntity client = null;
        int res = 0;
        try {
            res = fun.VipInsert(code,project,x_je);
        }catch (ThisSystemException e){
           request.setAttribute("message","添加失败");
           return "vipinsert";
        } catch (Exception e) {
            e.printStackTrace();
        }
       if (res != 0){
           request.setAttribute("message","VIP消费记录插入成功");
       }
        return "forward:/welcome.do";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/viprecord.do")
    public String VipRecord(HttpServletRequest request){
        List<VIPEntity> list = null;
        try {
            list = fun.selectAllX();
        } catch (Exception e) {
            throw new ThisSystemException("查询出错");
        }
        request.setAttribute("list",list);
        return "forward:/WEB-INF/views/viprecord.jsp";
    }

    @RequestMapping(method = RequestMethod.POST,path = "/viprecord.do")
    public String VipRecord(String code,HttpServletRequest request){
        List<VIPEntity> list = null;
        try {
            list = fun.selectCodeAllX(code);
        } catch (Exception e) {
            throw new ThisSystemException("查询出错");
        }
        request.setAttribute("list",list);
        return "forward:/WEB-INF/views/viprecord.jsp";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/clientmanage.do")
    public String ClientManage(HttpServletRequest request){
        List<ClientEntity> list = null;
        try {
            list = fun.selectAllC();
        } catch (Exception e) {
            throw new ThisSystemException("查询出错");
        }
        request.setAttribute("list",list);
        return "forward:/WEB-INF/views/clientmanage.jsp";
    }

    @RequestMapping(method = RequestMethod.POST,path = "/clientmanage.do")
    public String ClientManage(String code,HttpServletRequest request){
        List<ClientEntity> list = null;
        try {
            list = fun.selectCodeAllC(code);
        } catch (Exception e) {
            throw new ThisSystemException("查询出错");
        }
        request.setAttribute("list",list);
        return "forward:/WEB-INF/views/clientmanage.jsp";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/clientupdate.do")
    public String clientUpdate(String id,String code,String name,HttpServletRequest request){
        System.out.println("你是个大笨蛋："+id+"--"+code+"--"+name);
        request.setAttribute("id",id);
        request.setAttribute("code",code);
        request.setAttribute("name",name);
        return "forward:/WEB-INF/views/clientupdate.jsp";
    }

    @RequestMapping(method = RequestMethod.POST,path = "/clientupdate.do")
    public String ClientUpdate(String code,String name,HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println("修改后的client:"+id+"--"+code+"--"+name);
        int res = 0;
        try {
            res = fun.UpdateClient(id,code,name);
        } catch (Exception e){
            request.setAttribute("message","VIP客户信息修改失败");
            return "forward:/welcome.do";
        }
        if(res == 0){
            request.setAttribute("message","VIP客户信息修改失败");
            return "forward:/welcome.do";
        }
        request.setAttribute("message","VIP客户信息修改成功");
        return "forward:/welcome.do";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/clientdelete.do")
    public String ClientDelete(String id,String code,HttpServletRequest request){
        System.out.println("asfa::"+id);
        try {
            fun.ClientDelete(id,code);
        } catch (Exception e) {
            request.setAttribute("message","删除失败");
            return "forward:/welcome.do";
        }
        request.setAttribute("message","删除成功");
        return "forward:/welcome.do";
    }









}
