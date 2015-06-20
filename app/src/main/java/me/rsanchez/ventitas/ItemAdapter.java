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
 * Created by Administrador on 19/06/2015.
 */
public class ItemAdapter extends BaseAdapter {
    private static final List<Item> mItems = new ArrayList<Item>();
    private Context mContext = null;

    public ItemAdapter(Context context){
        mContext = context;
    }

    public void add(Item item) {
        mItems.add(item);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Item item = mItems.get(position);

        //RelativeLayout clientLayout = null;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);

            //convertView = itemLayout;
        }


        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(item.getDescripton());
        return convertView;
    }
}
