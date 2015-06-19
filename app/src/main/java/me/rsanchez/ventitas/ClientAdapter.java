package me.rsanchez.ventitas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 18/06/2015.
 */
public class ClientAdapter extends BaseAdapter {
    private static final List<Client> mClients = new ArrayList<Client>();
    private Context mContext = null;

    public ClientAdapter(Context context){
        mContext = context;
    }

    public void add(Client client) {
        mClients.add(client);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mClients.size();
    }

    @Override
    public Object getItem(int position) {
        return mClients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Client client = mClients.get(position);

        //RelativeLayout clientLayout = null;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);

            //convertView = itemLayout;
        }


        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(client.getName());
        return convertView;
    }
}
