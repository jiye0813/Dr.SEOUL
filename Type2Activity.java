package com.example.drseoul;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Type2Activity extends Activity {
    DatabaseHelper dbhelper;
    Cursor cursor, cursor2, cursor3;
    SearchedAdapter adapter;
    ListView searched_Items;
    SQLiteDatabase db;
    LayoutInflater inflater;

    ArrayList _arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type2);


        _arraylist = new ArrayList<ArrayList>();
        _arraylist = getIntent().getParcelableArrayListExtra("h_name");

        int i1;

        Intent intent = getIntent();
        i1 = intent.getIntExtra("_id",0);

        inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        dbhelper = new DatabaseHelper(this);
        db = dbhelper.getWritableDatabase();

        cursor = db.rawQuery("select h._id, h.name, h.address from hospital h inner join type ty on h._id = ty._id where ty.h_type ="+ i1 +";", null);

        adapter =new SearchedAdapter(this,cursor);
        searched_Items=(ListView)findViewById(R.id.list_searchresult);
        searched_Items.setAdapter((ListAdapter) adapter);


    }

    public class SearchedAdapter extends CursorAdapter {

        public SearchedAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return inflater.inflate(R.layout.searchitem, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor c) {

            TextView searchName = (TextView)view.findViewById(R.id.txthospitalname);
            searchName.setText(cursor.getString(1));

            TextView searchLoc = (TextView) view.findViewById(R.id.txthoslocation);
            searchLoc.setText(cursor.getString(2));
            Button searchGo = (Button)view.findViewById(R.id.button);
            searchGo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intenthospital = new Intent(Type2Activity.this, HospitalActivity.class);
                    intenthospital.putExtra("from", cursor.getInt(0));
                    startActivity(intenthospital);
                }
            });

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