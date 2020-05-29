package com.modestack.assignment.service;

import com.modestack.assignment.dao.UserDAO;
import com.modestack.assignment.model.Article;
import com.modestack.assignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //Declare this class as Service
public class UserService {

    @Autowired   //@Autowired annotation can be applied on variables and methods for autowiring byType
    private UserDAO userdao;

    public String registerUser(User registerdetails){

        return  userdao.registerUser(registerdetails);
    }

    public String loginUser(User logindetails){

        return userdao.loginUser(logindetails);
    }


    public String createArticle(Article article){

        return userdao.createArticle(article);

    }

    public String articleList(){

        return userdao.listArticle();
    }

}
