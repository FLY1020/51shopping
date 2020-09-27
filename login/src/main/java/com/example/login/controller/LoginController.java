package com.example.login.controller;

import com.example.login.bean.User;
import com.example.login.bean.UserSession;
import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {


    private String VerificationCode;//验证码


//    @Autowired
//    private SessionUserService sessionUserService;

    @Autowired
    private LoginService loginService;

    @Autowired
    UserSession userSession;

    Map<String, Object> map = new HashMap<>();

    //账号登录接口
    @PostMapping("user/login")
    public Map<String, Object> getUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,
                                       HttpServletResponse response, HttpSession session) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        User user = loginService.getByUser(username, password);

        if (user != null) {
            map.put("success", true);
            session.setAttribute("se_username", username);//存贮数据到session
            // sessionUserService.getSession((String) session.getAttribute("se_username"));
            userSession.setSession_user((String) session.getAttribute("se_username"));
        } else {
            map.put("success", false);
        }
        return map;
    }

    //获取session
    @PostMapping("user/session")
    public Map<String, Object> getSser(HttpServletResponse response, HttpSession session) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        map.put("msg", "数据为");
        map.put("msg", session.getAttribute("se_username"));
        return map;
    }

    //根据账号查找用UserSession户
//    @PostMapping("user/oneuser")
//    public Map<String,Object> getUserone(@RequestParam(value = "username") String username, HttpServletResponse response){
//        response.addHeader("Access-Control-Allow-Origin", "*");
//
//        User user=loginService.getByNameOne(User);
//        if(user!=null){
//            map.put("success",true);
//        }else {
//            map.put("success",false);
//        }
//        return map;
//    }

    //注册
    @PostMapping("user/register")
    public Map<String, Object> setUser(User user, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        User user1 = loginService.getByNameOne(user.getUsername());
        User user_phone = loginService.getByPhoneOne(user.getPhone());
        System.out.println(user_phone + " " + user.getPhone());
        //根据用户账号先查找是否有该用户
        if (user1 != null) {
            map.put("success", false);
            map.put("msg", "该用户名已被使用");
        } else if (user_phone != null) {
            map.put("success", false);
            map.put("msg", "该号码已注册");
        } else {
            int i = loginService.setByUser(user);

            if (user != null) {
                map.put("success", true);
            } else {
                map.put("success", false);
            }
        }
        return map;
    }

    //发送验证码
    @PostMapping("user/code")
    public Map<String, Object> setYanZheng(HttpServletResponse response, String phone) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        User user_phone = loginService.getByPhoneOne(phone);
        if (user_phone != null) {

            VerificationCode = "";//清空验证码
            for (int i = 0; i < 4; i++) {
                VerificationCode += (Math.round(Math.random() * 10));
            }
            System.out.println(phone);
            System.out.println("验证码为：" + VerificationCode);
            map.put("success", true);

//        // TODO Auto-generated method stub
//        HttpClient client = new HttpClient();
//        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
//        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
//        NameValuePair[] data ={ new NameValuePair("Uid", "哈哈海盗船长"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob",phone),new NameValuePair("smsText","您的验证码为："+VerificationCode+"请打死都不要告诉别人哈哈哈！")};
//        post.setRequestBody(data);
//
//        try {
//            client.executeMethod(post);
//            Header[] headers = post.getResponseHeaders();
//            int statusCode = post.getStatusCode();
//            System.out.println("statusCode:"+statusCode);
//            for(Header h : headers)
//            {
//                System.out.println(h.toString());
//            }
//            String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
//            System.out.println(result);
//
//
//            post.releaseConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        } else {
            map.put("success", false);
            map.put("msg", "该号码未注册！");
        }

        return map;
    }

    //验证验证码是否正确
    @PostMapping("user/verificationcode")
    public Map<String, Object> yanYanZheng(HttpServletResponse response, String code) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        System.out.println(code);

        if (code.equals(VerificationCode)) {
            map.put("success", true);
        } else {
            map.put("success", false);
        }

        return map;
    }
}
