package com.modestack.assignment.controller;

import com.modestack.assignment.model.Article;
import com.modestack.assignment.model.User;
import com.modestack.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Defines this class is Rest controller
@RequestMapping("/")   //Defines this URL
public class UserController {


    @Autowired //@Autowired annotation can be applied on variables and methods for autowiring byType
    private UserService userService;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUser(@RequestBody User registerdetails){


        return userService.registerUser(registerdetails);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginUser(@RequestBody User logindetails){

        return userService.loginUser(logindetails);
    }

    @RequestMapping(value = "/articles",method = RequestMethod.GET)
    public String listArticle(){

        return userService.articleList();
    }

    @RequestMapping(value = "/articles",method = RequestMethod.POST)
    public String createArticle(@RequestBody Article article){

        return userService.createArticle(article);
    }



}
