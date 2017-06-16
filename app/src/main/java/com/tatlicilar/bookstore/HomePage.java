package com.tatlicilar.bookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    ListView filmler;
    ArrayAdapter<String> myAdaptor;
    ArrayList<String> filmIsmi;
    TextView hosgeldin;
    Intent intent, intent2;
    Kisi k;
    ImageView img;
    String name;
    RadioButton seansAra;
    CheckBox biletAl;
    String index ;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        filmler = (ListView) findViewById(R.id.filmler);
        filmIsmi = new ArrayList<String>();

        filmIsmi.add("");
        filmIsmi.add("Arabalar3");
        filmIsmi.add("The Journey");
        filmIsmi.add("Mummy");
        filmIsmi.add("Wonder Woman");

        hosgeldin = (TextView) findViewById(R.id.Hosgeldin);


        intent = getIntent();
        k = (Kisi) intent.getSerializableExtra("kisi");

        hosgeldin.setText("Hoşgeldin" + k.getIsim() + ",");
//        image.setImageResource(k.getResim());

        seansAra =(RadioButton) findViewById(R.id.radioButton);
        biletAl = (CheckBox) findViewById(R.id.checkBox);

        seansAra.setOnClickListener(this);
        biletAl.setOnClickListener(this);

//        final WebView wv = (WebView) findViewById(R.id.webview);
//        wv.getSettings().setJavaScriptEnabled(true);

        myAdaptor = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,filmIsmi);
        filmler.setAdapter(myAdaptor);

        filmler.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(HomePage.this,filmIsmi.get(position),Toast.LENGTH_SHORT).show();
//                switch(position){
//                    case '0':
//                        wv.loadUrl("https://www.sinemalar.com/film/221313/arabalar-3");
//                        break;
//                    case '1':
//                        wv.loadUrl("https://www.sinemalar.com/film/53093/the-journey");
//                        break;
//                    case '2':
//                        wv.loadUrl("https://www.sinemalar.com/film/224027/the-mummy-2017");
//                        break;
//                    case '3':
//                        wv.loadUrl("https://www.sinemalar.com/film/91055/wonder-woman");
//                        break;
//                }
    }}
            );
    }

public void onClick(View v){

    switch(v.getId()){
        case R.id.radioButton:
            intent2 = new Intent(this, Seans.class);
            startActivity(intent2);
            break;
        case R.id.checkBox:
            intent2 = new Intent(this, Seans.class);
            startActivity(intent2);
            break;
}

}}