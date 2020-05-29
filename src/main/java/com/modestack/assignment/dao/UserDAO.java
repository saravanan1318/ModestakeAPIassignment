package com.modestack.assignment.dao;

import com.modestack.assignment.model.Article;
import com.modestack.assignment.model.User;

import java.util.List;

public interface UserDAO {

    String loginUser(User logindetails);
    String registerUser(User registerdetails);
    String createArticle(Article article);
    String listArticle();
}
