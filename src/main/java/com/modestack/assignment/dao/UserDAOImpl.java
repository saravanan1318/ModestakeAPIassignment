package com.modestack.assignment.dao;

import com.modestack.assignment.model.Article;
import com.modestack.assignment.model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Repository    //@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects
public class UserDAOImpl implements UserDAO {

    //LIST Object creation
    List<User> usersdata = new ArrayList<>();
    List<Article> articledata = new ArrayList<Article>();

    @Override
    public String loginUser(User logindetails) {

        //JSON Declaration
        JSONObject loginresponse=new JSONObject();
        JSONObject bodymessage =new JSONObject();

        for (User usersdetails: usersdata) {


            //Check the Username and password already exist
            if (Objects.equals(usersdetails.getUsername(), logindetails.getUsername()) && Objects.equals(usersdetails.getPassword(), logindetails.getPassword())){

                try {

                    //Response with Acces token already created when register user
                    bodymessage.put("message","success");
                    bodymessage.put("accessToken",usersdetails.getAccess_token());

                    loginresponse.put("statusCode","200");
                    loginresponse.put("body",bodymessage);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return String.valueOf(loginresponse);
            }else {

                //Response when failure
                try {
                    bodymessage.put("message","failure");
                    loginresponse.put("statusCode","201");
                    loginresponse.put("body",bodymessage);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return String.valueOf(loginresponse);
            }
        }

        return null;
    }

    @Override
    public String registerUser(User registerdetails) {   //Create Account for register


        usersdata.add(registerdetails);   //Add register details to the User List

        //JSONObject Declaration
        JSONObject registerresponse=new JSONObject();
        JSONObject bodymessage =new JSONObject();

        try {

            //Response
            bodymessage.put("message","new user created");
            registerresponse.put("statusCode","201");
            registerresponse.put("body",bodymessage);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return String.valueOf(registerresponse);
    }


    @Override
    public String createArticle(Article article){  //Create Article by users

       articledata.add(article);  //Add the Article data in list

        JSONObject articleresponse=new JSONObject();
        JSONObject bodymessage =new JSONObject();

        try {

            //response
            bodymessage.put("message","new article created");
            articleresponse.put("statusCode","201");
            articleresponse.put("body",bodymessage);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return String.valueOf(articleresponse);

    }

    @Override
    public String listArticle() {    //List os all the article created by all users


        JSONObject articleresponse=new JSONObject();
        JSONObject bodymessage =new JSONObject();
        JSONArray bodyArray = new JSONArray();

        try {

            for (Article articledetails: articledata) {  //Run for loop to push all the article data in JSON Array

                JSONObject body =new JSONObject();

                body.put("title",articledetails.getTitle());
                body.put("body",articledetails.getBody());
                body.put("author",articledetails.getAuthor());

                bodyArray.put(body);
            }

            //Response
            articleresponse.put("statusCode","201");
            bodymessage.put("data",bodyArray);
            articleresponse.put("body",bodymessage);

        } catch (JSONException e) {
            e.printStackTrace(); //Exception
        }


        return String.valueOf(articleresponse);
    }

}
