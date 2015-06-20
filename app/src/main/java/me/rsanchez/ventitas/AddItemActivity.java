package me.rsanchez.ventitas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrador on 19/06/2015.
 */
public class AddItemActivity extends ActionBarActivity {
    private TextView mIdTextView = null;
    private TextView mDescriptionTextView = null;
    private TextView mPriceTextView = null;
    private TextView mQuantityTextView = null;
    private TextView mUnitTextView = null;
    private TextView mSizeTextView = null;
    private TextView mColorTextView = null;
    private TextView mCommentsTextView = null;

    private String item_id = "";
    private String item_description = "";
    private double item_price = 0;
    private int item_quantity = 0;
    private String item_unit = "";
    private String item_size = "";
    private String item_color = "";
    private String item_comments = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item);


        mIdTextView = (TextView) findViewById(R.id.item_id);
        mDescriptionTextView = (TextView) findViewById(R.id.item_description);
        mPriceTextView = (TextView) findViewById(R.id.item_price);
        mQuantityTextView = (TextView) findViewById(R.id.item_quantity);
        mUnitTextView = (TextView) findViewById(R.id.item_unit);
        mSizeTextView = (TextView) findViewById(R.id.item_size);
        mColorTextView = (TextView) findViewById(R.id.item_color);
        mCommentsTextView = (TextView) findViewById(R.id.item_comments);


    }

    public void addItems(View view){
        item_id = mIdTextView.getText().toString().trim();
        item_description = mDescriptionTextView.getText().toString();

        double lPrice = 0;
        if(mIdTextView.getText().toString().trim() != ""){
            lPrice = Double.valueOf(mIdTextView.getText().toString().trim());
        }
        item_price = lPrice;

        int lQuantity = 0;
        if(mIdTextView.getText().toString().trim() != ""){
            lQuantity = Integer.valueOf(mIdTextView.getText().toString().trim());
        }
        item_quantity = lQuantity;


        item_unit = mUnitTextView.getText().toString().trim();
        item_size = mSizeTextView.getText().toString().trim();
        item_color = mColorTextView.getText().toString().trim();
        item_comments = mCommentsTextView.getText().toString().trim();

        Item item = new Item(item_id, item_description, item_price, item_quantity, item_unit, item_size, item_color, item_comments);

        Intent intent = new Intent(this, Item.class);

        intent.putExtra(PaymentActivity.NEW_ITEM, item);
        setResult(RESULT_OK, intent);
        finish();
    }


}
