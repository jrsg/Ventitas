package me.rsanchez.ventitas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrador on 18/06/2015.
 */
public class PaymentActivity extends ActionBarActivity {
    private ArrayList<Item> mItems = null;
    public final int ADD_ITEM_REQUEST = 0;
    public static final String NEW_ITEM = "new_item";
    private ListView mItemList = null;
    private ItemAdapter mItemAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //MainActivity.mClientAdapter = new ClientAdapter(this);

        setTitle(R.string.payment_activity_title);
        setContentView(R.layout.payment_form);

        mItemList = (ListView) findViewById(R.id.payment_item_list);

        mItemAdapter = new ItemAdapter(this);

        mItemList.setAdapter(mItemAdapter);
    }

    public void addItems(View view){
        Intent intent = new Intent(this, AddItemActivity.class);

        startActivityForResult(intent, ADD_ITEM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){

            Item item = data.getExtras().getParcelable(NEW_ITEM);
            mItemAdapter.add(item);
            //mItems.add(item);
        }
    }

    public void save(View view){
        TextView clientTextView = (TextView) findViewById(R.id.new_payment_client_name);
        //TextView amountTextView = (TextView) findViewById(R.id.new_payment_amount);

        String clientName = clientTextView.getText().toString().trim();
        //Float amount = Float.valueOf(amountTextView.getText().toString());
        float amount = 1.0F;

        Client client = new Client("1", clientName, amount);

        MainActivity.mClientAdapter.add(client);

        finish();

    }

    public void addItem(Item item){
        mItems.add(item);
    }
}
