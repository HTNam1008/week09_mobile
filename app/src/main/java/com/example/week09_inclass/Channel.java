package com.example.week09_inclass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.Locale;

public class Channel extends Activity {
    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context context;
    SingleItem selectedNewsItem;
    String [][] myUrlCaptionMenu = {
            {"", "Thể thao"},
            {"", "Du lịch"},
            {"", "Giáo dục"},
            {"", "Kinh tế"},
            {"", "Giải trí"},
            {"","Thế giới"}
    };

    String[] myUrlCaption = new String[myUrlCaptionMenu.length];
    String[] myUrlAddress = new String[myUrlCaptionMenu.length];
    String name="",link="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_activity);

        Intent callingIntent = getIntent();
        Bundle myBundle = callingIntent.getExtras();
        name = myBundle.getString("name"); link = myBundle.getString("link");

        myUrlCaptionMenu[0][0]=link+"rss/the-thao.rss";
        myUrlCaptionMenu[1][0]=link+"rss/du-lich.rss";
        myUrlCaptionMenu[2][0]=link+"rss/giao-duc.rss";
        myUrlCaptionMenu[3][0]=link+"rss/kinh-te.rss";
        myUrlCaptionMenu[4][0]=link+"rss/giai-tri.rss";
        myUrlCaptionMenu[5][0]=link+"rss/the-gioi.rss";

        for (int i=0; i<myUrlAddress.length; i++) {
            myUrlAddress[i] = myUrlCaptionMenu[i][0]; myUrlCaption[i] = myUrlCaptionMenu[i][1];
        }

        context = getApplicationContext();
        this.setTitle("CHANNELS IN " +name.toUpperCase(Locale.US));

        myMainListView = (ListView) this.findViewById(R.id.myListView);
        myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String urlAddress = myUrlAddress[i], urlCaption = myUrlCaption[i];

                Intent callShowHeadlines = new Intent(Channel.this, ShowHeadlines.class);
                Bundle myData = new Bundle();
                myData.putString("urlAddress", urlAddress); myData.putString("urlCaption", urlCaption); myData.putString("name",name);
                callShowHeadlines.putExtras(myData); startActivity(callShowHeadlines);
            }
        });
        adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);
    }
}
