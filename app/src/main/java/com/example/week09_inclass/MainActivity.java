package com.example.week09_inclass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {
    GridView gridView;
    String[] link={"https://thanhnien.vn/","https://vnexpress.net/","https://dantri.com.vn/","https://vtc.vn/"};
    String[] name={"Thanh Niên","VNEXPRESS","Dân Trí","VTCNews"};
    Integer[] thumbnails={R.drawable.logo,R.drawable.logo1,R.drawable.logo2,R.drawable.logo3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("NEWS APP");
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new MyImageAdapter(this, thumbnails));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent callChannel = new Intent(MainActivity.this, Channel.class);
                Bundle myData = new Bundle();
                myData.putString("link", link[i]); myData.putString("name",name[i]);
                callChannel.putExtras(myData); startActivity(callChannel);
            }
        });
    }
}