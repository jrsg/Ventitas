package me.rsanchez.ventitas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrador on 18/06/2015.
 */
public class Client {
    private String mId = "";
    private String mName = "";
    private ArrayList<JSONObject> mPaymentLog = new ArrayList<JSONObject>();

    public Client(String id, String name, Float amount){
        setId(id);
        setName(name);
        setAmount(amount);
    }

    public void setAmount(Float amount){
        JSONObject json = new JSONObject();
        try {
            json.put("amount", amount.longValue());
            json.put("date", new Date());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mPaymentLog.add(json);
    }

    public void setId(String id){
        mId = id;
    }

    public void setName(String name){
        mName = name;
    }

    public String getId(){
        return mId;
    }

    public String getName(){
        return mName;
    }
}
