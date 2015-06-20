package me.rsanchez.ventitas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 20/06/2015.
 */
public class Sale {
    private String mCycle = "";
    private Client mClient = null;
    private List<Item> mItems = null;

    public Sale(String cycle, Client client, List<Item> items){
        mCycle = cycle;
        mClient = client;
        mItems = items;
    }

    public String getCycle(){
        return mCycle;
    }

    public String getClientName(){
        return mClient.getName();
    }
}
