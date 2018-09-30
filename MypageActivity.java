package com.example.drseoul;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MypageActivity extends AppCompatActivity {
    DatabaseHelper dbhelper;
    Cursor cursor;
    LikeAdapter adapter;
    ListView likeItems;
    SQLiteDatabase db;
    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        dbhelper = new DatabaseHelper(this);
        db = dbhelper.getWritableDatabase();
        cursor = db.rawQuery("select _id, name, phoneNum from hospital where is_like = 1;", null);
        adapter =new LikeAdapter(this, cursor);
        likeItems=(ListView)findViewById(R.id.list_myhospital);
        likeItems.setAdapter(adapter);
        likeItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Intent intenthospital = new Intent(MypageActivity.this, HospitalActivity.class);
                intenthospital.putExtra("from", cursor.getInt(0));
                startActivity(intenthospital);
            }
        });
    }
    class LikeAdapter extends CursorAdapter{

        public LikeAdapter(Context context, Cursor c){
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return inflater.inflate(R.layout.myitem, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor c) {
            TextView txthostName = (TextView) view.findViewById(R.id.textHospital);
            txthostName.setText(cursor.getString(1));

//            TextView cancel = (TextView)view.findViewById(R.id.btnmycancel);
//            cancel.setClickable(true);
//            cancel.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(cursor.moveToNext()) {
//                        String sql = "update hospital set is_like = 0 where _id = " + cursor.getInt(0) + ";";
//                        db.execSQL(sql);
//                        Intent intent2=new Intent(MypageActivity.this, MypageActivity.class);
//                        startActivity(intent2);
//                    }
//
//                }
//            });
//
//           TextView call = (TextView)view.findViewById(R.id.btnmycall);
//            //call.setClickable(true);
//            call.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(cursor.moveToNext()) {
//                        Intent mycall = new Intent(Intent.ACTION_DIAL);
//                        mycall.setData(Uri.parse("tel:" + cursor.getString(2)));
//                        try {
//                           startActivity(mycall);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            });
        }
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