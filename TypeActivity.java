package com.example.drseoul;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeActivity extends AppCompatActivity {
    String type[] = {"liposuction", "joint, spine", "general hospital", "Korean Medicine", "dental",
            "colonal", "ob-gyn", "cancer", "organ transplatation", "heart", "thyroid gland", "brun injury",
            "eye", "nose", "breast", "anti-aging", "facial contour", "pimple", "wrinkle", "petit surgery", "revision surgery",
            "aesthetic", "lifting", "hair loss", "freckle", "double jaw surgery", "facial fat operation", "body type",
            "skin", "man", "laser surgery", "skin-lightening", "vagina suegery", "vacoal cords"
    };

    int[] h_id = new int[123];
    static String[] h_name = new String[123];

    List<String> list = Arrays.<String>asList(type);
    static List<String> h_list = Arrays.<String>asList(h_name);

    ArrayList<String> TypeList = new ArrayList<String>(list);
    static ArrayList HospitalList = new ArrayList(h_list);

    LayoutInflater inflater;
    DatabaseHelper dbhelper;
    Cursor cursor, cursor2;
    SQLiteDatabase db;

    //HospitalAdapter h_Adapter;
    //ArrayAdapter<String> h_Adapter;
    ArrayAdapter<String> typeAdapter;
    ListView t_Items, h_Items;
    String str_hname;
    TextView txtHname;

    int oo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        dbhelper = new DatabaseHelper(this);

        db = dbhelper.getWritableDatabase();

        cursor = db.rawQuery("select h._id, h.name from hospital h inner join type ty where h._id = ty._id;", null);

        txtHname = (TextView) findViewById(R.id.txthospitalname);
        //cursor2 = db.rawQuery("select h._id, h.name from hospital h inner join type ty on h._id = ty._id where ty.h_type = "+ +1 +";", null);

        typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, TypeList);
        t_Items = (ListView) findViewById(R.id.list_type);
        t_Items.setAdapter(typeAdapter);
        t_Items.setOnItemClickListener(mItemClick);
        t_Items.setSelector(R.drawable.selector);

        //typeAdapter =new TypeAdapter(this, cursor);
//        h_Items=(ListView)findViewById(R.id.list_type);
//        h_Items.setAdapter(typeAdapter);

//        h_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, HospitalList);
//        h_Items = (ListView) findViewById(R.id.list_output);
//        h_Items.setAdapter(h_Adapter);
//        //h_Items.setOnItemClickListener(mItemClick2);
//        h_Items.setSelector(R.drawable.selector);

//        h_Adapter =new HospitalAdapter(this, cursor);
//        h_Items=(ListView)findViewById(R.id.list_output);
//        h_Items.setAdapter(h_Adapter);
    }

    AdapterView.OnItemClickListener mItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            int p = (TypeList.indexOf(type[position + 1]));
            cursor2 = db.rawQuery("select h._id, h.name from hospital h inner join type ty on h._id = ty._id where ty.h_type = " + p + ";", null);

//            for(int i = 0; i < cursor2.getCount(); i++) {
//                cursor2.moveToPosition(i);
//                h_name[i] = cursor2.getString(1);
//                HospitalList.add(i,cursor2.getString(1));
//
//                Intent intent = new Intent(TypeActivity.this, Type2Activity.class);
//                intent.putParcelableArrayListExtra("h_name", HospitalList);
//                startActivity(intent);
//            }

            switch (position) {
                case 0:
                    Intent intent = new Intent(TypeActivity.this, Type2Activity.class);
                    intent.putExtra("_id", 1);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent2 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent2.putExtra("_id", 2);
                    startActivity(intent2);
                    break;
                case 2:
                    Intent intent3 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent3.putExtra("_id", 3);
                    startActivity(intent3);
                    break;
                case 3:
                    Intent intent4 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent4.putExtra("_id", 4);
                    startActivity(intent4);
                    break;
                case 4:
                    Intent intent5 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent5.putExtra("_id", 5);
                    startActivity(intent5);
                    break;
                case 5:
                    Intent intent6 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent6.putExtra("_id", 6);
                    startActivity(intent6);
                    break;
                case 6:
                    Intent intent7 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent7.putExtra("_id", 7);
                    startActivity(intent7);
                    break;
                case 7:
                    Intent intent8 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent8.putExtra("_id", 8);
                    startActivity(intent8);
                    break;
                case 8:
                    Intent intent9 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent9.putExtra("_id", 9);
                    startActivity(intent9);
                    break;
                case 9:
                    Intent intent10 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent10.putExtra("_id", 10);
                    startActivity(intent10);
                    break;
                case 10:
                    Intent intent11 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent11.putExtra("_id", 11);
                    startActivity(intent11);
                    break;
                case 11:
                    Intent intent12 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent12.putExtra("_id", 12);
                    startActivity(intent12);
                    break;
                case 12:
                    Intent intent13 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent13.putExtra("_id", 13);
                    startActivity(intent13);
                    break;
                case 13:
                    Intent intent14 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent14.putExtra("_id", 14);
                    startActivity(intent14);
                    break;
                case 14:
                    Intent intent15 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent15.putExtra("_id", 15);
                    startActivity(intent15);
                    break;
                case 15:
                    Intent intent16 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent16.putExtra("_id", 16);
                    startActivity(intent16);
                    break;
                case 16:
                    Intent intent17 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent17.putExtra("_id", 17);
                    startActivity(intent17);
                    break;
                case 17:
                    Intent intent18 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent18.putExtra("_id", 18);
                    startActivity(intent18);
                    break;
                case 18:
                    Intent intent19 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent19.putExtra("_id", 19);
                    startActivity(intent19);
                    break;
                case 19:
                    Intent intent20= new Intent(TypeActivity.this, Type2Activity.class);
                    intent20.putExtra("_id", 20);
                    startActivity(intent20);
                    break;
                case 20:
                    Intent intent21 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent21.putExtra("_id", 21);
                    startActivity(intent21);
                    break;
                case 21:
                    Intent intent22 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent22.putExtra("_id", 22);
                    startActivity(intent22);
                    break;
                case 22:
                    Intent intent23 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent23.putExtra("_id", 23);
                    startActivity(intent23);
                    break;
                case 23:
                    Intent intent24 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent24.putExtra("_id", 24);
                    startActivity(intent24);
                    break;
                case 24:
                    Intent intent25 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent25.putExtra("_id", 25);
                    startActivity(intent25);
                    break;
                case 26:
                    Intent intent27 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent27.putExtra("_id", 27);
                    startActivity(intent27);
                    break;
                case 27:
                    Intent intent28 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent28.putExtra("_id", 28);
                    startActivity(intent28);
                    break;
                case 28:
                    Intent intent29 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent29.putExtra("_id", 29);
                    startActivity(intent29);
                    break;
                case 29:
                    Intent intent30 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent30.putExtra("_id", 30);
                    startActivity(intent30);
                    break;
                case 30:
                    Intent intent31 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent31.putExtra("_id", 31);
                    startActivity(intent31);
                    break;
                case 31:
                    Intent intent32 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent32.putExtra("_id", 32);
                    startActivity(intent32);
                    break;
                case 32:
                    Intent intent33 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent33.putExtra("_id", 33);
                    startActivity(intent33);
                    break;
                case 33:
                    Intent intent34 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent34.putExtra("_id", 34);
                    startActivity(intent34);
                    break;
                case 34:
                    Intent intent35 = new Intent(TypeActivity.this, Type2Activity.class);
                    intent35.putExtra("_id", 35);
                    startActivity(intent35);
                    break;
            }
        }
    };

    public void addHospitalName() {
        for (int i = 0; i < cursor2.getCount(); i++) {
            cursor2.moveToPosition(i);
            //h_name[i] = cursor2.getString(1);
            //HospitalList.add(i,cursor2.getString(1));
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
