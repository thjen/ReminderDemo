package com.example.thjen.reminderdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by thjen on 13/10/2017.
 */

public class SinhVienAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<SinhVien> arraySinhVien;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {

        myContext = context;
        myLayout = layout;
        arraySinhVien = sinhVienList;

    }

    @Override
    public int getCount() {

        return arraySinhVien.size();
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

        // layoutInflater để lấy list_sinhvien.xml để hiện thị trên từng item của list_sinhvien
        LayoutInflater layoutInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(myLayout, null); // để lấy ra các text view trong list_sinhvien;

        /** ánh xạ và gán giá trị **/
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName); /** Ánh xạ **/
        tvName.setText(arraySinhVien.get(position).getmName());  /** gán giá trị **/

        TextView tvBerthday = (TextView) convertView.findViewById(R.id.tvBerthday);
        tvBerthday.setText(String.valueOf(arraySinhVien.get(position).getmBerthday()));  //mBerthday là kiểu int

        Button bt = (Button) convertView.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return convertView;
    }
}
