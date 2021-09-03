package com.example.saurya.uidesign;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Saurya on 1/12/2017.
 */
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="https://saash.000webhostapp.com/Register.php";
    private Map<String,String> params;
    public RegisterRequest(String name,String username,int age,String password,Response.Listener<String> Listener){
        super(Method.POST,REGISTER_REQUEST_URL,Listener,null);
        params=new HashMap<>();
        System.out.println(name);
        System.out.println(username);
        System.out.println(age);
        System.out.println(password);
        params.put("name",name);
        params.put("username",username);
        params.put("password",password);
        params.put("age",age+"");

    }
    public Map<String,String>getParams(){
        return params;
    }

}
