package me.rsanchez.ventitas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Administrador on 19/06/2015.
 */
public class Item implements Parcelable{
    private String mId = "";
    private String mDescription = "";
    private double mPrice = 0;
    private int mQuantity = 0;
    private String mUnit = "";
    private String mSize = "";
    private String mColor = "";
    private String mComments = "";

    public Item(String id, String description, double price, int quantity, String unit, String size, String color, String comments){
        this.mId = id;
        this.mDescription = description;
        this.mPrice = price;
        this.mQuantity = quantity;
        this.mUnit = unit;
        this.mSize = size;
        this.mColor = color;
        this.mComments = comments;
    }

    public String getDescripton(){
        return mDescription;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mDescription);
        dest.writeDouble(mPrice);
        dest.writeInt(mQuantity);
        dest.writeString(mUnit);
        dest.writeString(mSize);
        dest.writeString(mColor);
        dest.writeString(mComments);
    }

    private static Item readFromParcel(Parcel in) { // (4)
        String item_id = in.readString();
        String item_description = in.readString();
        double item_price = in.readDouble();
        int item_quantity = in.readInt();
        String item_unit = in.readString();
        String item_size = in.readString();
        String item_color = in.readString();
        String item_comments = in.readString();


        return new Item(item_id, item_description, item_price, item_quantity, item_unit, item_size, item_color, item_comments);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Item createFromParcel(Parcel in){
            return readFromParcel(in);
        }

        public Item[] newArray(int size){
            return new Item[size];
        }
    };


}
