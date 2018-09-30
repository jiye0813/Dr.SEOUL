package com.example.drseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
    public void mClick(View v){
        switch(v.getId()){
            case R.id.btnfind:
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btninfo:
                Intent intent2=new Intent(this, InfoActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnmy:
                Intent intent3=new Intent(this, MypageActivity.class);
                startActivity(intent3);
                break;
            case R.id.btntreattype:
                Intent intent4=new Intent(this, TypeActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
