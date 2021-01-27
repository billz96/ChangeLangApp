package com.unipi.talepis.changelang1;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String chosenlang="";
    int langpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chosenlang=(String)listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),chosenlang,Toast.LENGTH_LONG).show();
                langpos=position;
            }
        });
    }
    public void changelang(View view){
       switch (langpos){
           case 0:
               updateconfig("en");
               break;
           case 1:
               updateconfig("de");
               break;
           case 2:
               updateconfig("fr");
               break;
           default:
               break;
       }
    }
    public void updateconfig(String s){
        Locale locale=new Locale(s);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,
                getBaseContext().getResources().getDisplayMetrics());
        Bundle bundle=new Bundle();
        onCreate(bundle);
        setTitle(R.string.app_name);
    }
}
