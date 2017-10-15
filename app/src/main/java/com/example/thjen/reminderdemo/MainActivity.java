package com.example.thjen.reminderdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<SinhVien> mangSinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        mangSinhVien = new ArrayList<SinhVien>();

        mangSinhVien.add(new SinhVien("Q.ThjeN", 1998));
        mangSinhVien.add(new SinhVien("Trung Jin", 1999));
        mangSinhVien.add(new SinhVien("Tun Hentai", 1998));
        mangSinhVien.add(new SinhVien("Q.Thjen Carray All", 1997));
        mangSinhVien.add(new SinhVien("Q.ThjeN", 1998));
        mangSinhVien.add(new SinhVien("Trung Jin", 1999));
        mangSinhVien.add(new SinhVien("Tun Hentai", 1998));
        mangSinhVien.add(new SinhVien("Q.Thjen Carray All", 1997));
        mangSinhVien.add(new SinhVien("Q.ThjeN", 1998));
        mangSinhVien.add(new SinhVien("Trung Jin", 1999));
        mangSinhVien.add(new SinhVien("Tun Hentai", 1998));
        mangSinhVien.add(new SinhVien("Q.Thjen Carray All", 1997));
        mangSinhVien.add(new SinhVien("Q.ThjeN", 1998));
        mangSinhVien.add(new SinhVien("Trung Jin", 1999));
        mangSinhVien.add(new SinhVien("Tun Hentai", 1998));
        mangSinhVien.add(new SinhVien("Q.Thjen Carray All", 1997));
        mangSinhVien.add(new SinhVien("Q.ThjeN", 1998));
        mangSinhVien.add(new SinhVien("Trung Jin", 1999));
        mangSinhVien.add(new SinhVien("Tun Hentai", 1998));
        mangSinhVien.add(new SinhVien("Q.Thjen Carray All", 1997));

        SinhVienAdapter customAdapter = new SinhVienAdapter(
                MainActivity.this,
                R.layout.list_sinhvien,
                mangSinhVien);

        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Alarm.class);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });

    }

}
