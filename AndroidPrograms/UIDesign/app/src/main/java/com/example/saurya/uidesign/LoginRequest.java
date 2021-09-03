package com.example.saurya.uidesign;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Saurya on 1/12/2017.
 */
public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL="https://saash.000webhostapp.com/Login.php";
    private Map<String,String> params;
    public LoginRequest(String username,String password,Response.Listener<String> Listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,Listener,null);
        params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);

    }
    public Map<String,String>getParams(){
        return params;
    }
}
