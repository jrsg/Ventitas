package me.rsanchez.ventitas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 20/06/2015.
 */
public class SaleAdapter extends BaseAdapter {
    private static final List<Sale> mSales = new ArrayList<Sale>();
    private Context mContext = null;

    public SaleAdapter(Context context){
        mContext = context;
    }

    public void add(Sale sale) {
        mSales.add(sale);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mSales.size();
    }

    @Override
    public Object getItem(int position) {
        return mSales.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Sale sale = mSales.get(position);

        //RelativeLayout clientLayout = null;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);

            //convertView = itemLayout;
        }


        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(sale.getCycle());
        return convertView;
    }
}
