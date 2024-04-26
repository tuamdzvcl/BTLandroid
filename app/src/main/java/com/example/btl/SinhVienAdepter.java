package com.example.btl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdepter extends BaseAdapter {

    private Context context ;
    private int layout;
    private List<SinhVien> SVlist;

    public SinhVienAdepter(Context context, int layout, List<SinhVien> SVlist) {
        this.context = context;
        this.layout = layout;
        this.SVlist = SVlist;
    }

    @Override
    public int getCount() {
        return SVlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout,null);

        TextView txtmasv = ( TextView) convertView.findViewById(R.id.txtmasv);
        TextView txttensv = (TextView) convertView.findViewById(R.id.txttensv);
        TextView txtquequan =(TextView) convertView.findViewById(R.id.txtquequan) ;
        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imageviewHinh);

        SinhVien svinh = SVlist.get(position);

        txtmasv.setText(svinh.getMasv());
        txttensv.setText(svinh.getTensv());
        txtquequan.setText(svinh.getQuequan());
        imgHinh.setImageResource(svinh.getHinh());
        return convertView;
    }
}
