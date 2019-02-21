package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        System.out.println(user);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                session.setAttribute("user", user);
                return "redirect:/user/getAll.do";
            } else {
                return "redirect:./login.jsp";
            }
        } else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("list", list);
        return "forward:/emplist.jsp";

    }

    @RequestMapping("/remove")
    public String remove(Integer id){
        userService.remove(id);
        return "redirect:/user/getAll.do";
    }

    @RequestMapping("/add")
    public String add(User user){
        int i = userService.add(user);
        if(i>0){
            return "redirect:/user/getAll.do";
        }else{
            return "redirect:/addEmp.jsp";
        }
    }

    @RequestMapping("/getById")
    public String getById(Integer id,Model model){
        User user = userService.getById(id);
        model.addAttribute("emp",user);
        return "forward:/updateEmp.jsp";
    }

    @RequestMapping("/modify")
    public String modify(User user){
        userService.modify(user);
        return "redirect:/user/getAll.do";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login.jsp";
    }
}
