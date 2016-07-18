package com.hll.action;

import com.hll.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hll on 2016/7/18.
 */
@Controller
public class LoginAction {

  @RequestMapping("/login")
  public String login(SysUser user,Model model){
    if(user.isEmpty()) {
      return "login";
    }else {
      Subject subject = SecurityUtils.getSubject();
      UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
      try {
        subject.login(token);
      }catch (UnknownAccountException|IncorrectCredentialsException e){
        model.addAttribute("error","用户名/密码错误");
        return "login";
      }catch (AuthenticationException e){
        model.addAttribute("error","用户被锁定");
        return "login";
      }
      return "redirect:/";
    }
  }

  @RequestMapping("/logout")
  public String logout(){

    return "";
  }

}
