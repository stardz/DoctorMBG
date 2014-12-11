package com.example.oo.doctormbg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;


public class Main extends Activity {
        int choice=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BootstrapButton statsBtn=(BootstrapButton)findViewById(R.id.statsbtn);
        final BootstrapButton aboutBtn=(BootstrapButton)findViewById(R.id.aboutbtn);
        final BootstrapButton trackBtn=(BootstrapButton)findViewById(R.id.trackbtn);
        BootstrapButton loginBtn=(BootstrapButton)findViewById(R.id.login);
        statsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutBtn.setBootstrapType("default");
                trackBtn.setBootstrapType("default");
                statsBtn.setBootstrapType("success");
                Main.this.choice=1;
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statsBtn.setBootstrapType("default");
                trackBtn.setBootstrapType("default");
                aboutBtn.setBootstrapType("success");
                Main.this.choice=3;
            }
        });
        trackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutBtn.setBootstrapType("default");
                statsBtn.setBootstrapType("default");
                trackBtn.setBootstrapType("success");
                Main.this.choice=2;
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Main.this.choice==1){
                    Intent nextAct=new Intent(Main.this,MaiStats.class);
                    startActivity(nextAct);
                }else if(Main.this.choice==2){
                    Intent nextAct=new Intent(Main.this,MaiSuivi.class);
                    startActivity(nextAct);
                }else{
                    Intent nextAct=new Intent(Main.this,MaiAbout.class);
                    startActivity(nextAct);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
