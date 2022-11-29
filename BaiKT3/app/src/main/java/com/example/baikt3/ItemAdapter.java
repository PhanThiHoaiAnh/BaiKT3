package com.example.baikt3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Item> arrayList;

    public ItemAdapter(Context context, int layout, List<Item> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        Item ngonNgu= arrayList.get(i);

        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tv_motaNN= view.findViewById(R.id.tv_mota);
        ImageView imageV = view.findViewById(R.id.imgHinh);

        tvName.setText(ngonNgu.getTenNN());
        tv_motaNN.setText(ngonNgu.getMtaNN());
        imageV.setImageResource(ngonNgu.getHinh());
        return view;
    }
}
