package me.rsanchez.ventitas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrador on 18/06/2015.
 */
public class PaymentActivity extends Activity {
    //private ClientAdapter mClientAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //MainActivity.mClientAdapter = new ClientAdapter(this);


        setContentView(R.layout.payment_form);
    }

    public void save(View view){
        TextView clientTextView = (TextView) findViewById(R.id.new_payment_client_name);
        TextView amountTextView = (TextView) findViewById(R.id.new_payment_amount);

        String clientName = clientTextView.getText().toString().trim();
        Float amount = Float.valueOf(amountTextView.getText().toString());

        Client client = new Client("1", clientName, amount);

        MainActivity.mClientAdapter.add(client);

        finish();

    }
}
