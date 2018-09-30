package com.example.drseoul;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.util.Calendar;

public class HospitalActivity extends FragmentActivity implements OnMapReadyCallback{
    ArrayAdapter<CharSequence> adapter;
    int from;
    int i, ttype;
    private GoogleMap map2;
    DatabaseHelper dbhelper;
    Cursor cursor, cursor2;
    SQLiteDatabase db;
    LayoutInflater inflater;
    TextView address,time,type, name;
    String strname, straddress, strtype;
    Button btnadd;
    Drawable fill, empty;
    Calendar cal = Calendar.getInstance();
    int nWeek = cal.get(Calendar.DAY_OF_WEEK);
    MarkerOptions markerOptions = new MarkerOptions();
    String hospital_type[] = {"liposuction", "joint, spine", "general hospital", "Korean Medicine", "dental",
            "colonal","ob-gyn","cancer","organ transplatation","heart","thyroid gland","brun injury",
            "eye","nose","breast","anti-aging","facial contour","pimple","wrinkle","petit surgery","revision surgery",
            "aesthetic","lifting","hair loss","freckle","double jaw surgery","facial fat operation","body type",
            "skin","man","laser surgery","skin-lightening","vagina suegery","vacoal cords"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        Intent intent = getIntent();
        from = intent.getIntExtra("from",0);

        empty = getResources().getDrawable(R.drawable.searhbox);
        fill = getResources().getDrawable(R.drawable.btncircle);
        address = (TextView)findViewById(R.id.txtadress);
        time = (TextView)findViewById(R.id.txttime);
        type = (TextView)findViewById(R.id.txttype);
        name =(TextView)findViewById(R.id.txtname);
        btnadd=(Button)findViewById(R.id.btnaddmy);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView2);
        mapFragment.getMapAsync(this);

        inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        dbhelper = new DatabaseHelper(this);
        db = dbhelper.getWritableDatabase();
        cursor = db.rawQuery("select h.*, t.sun, t.mon, t.tue, t.wed, t.thu, t.fri, t.sat from hospital h inner join time t on h._id = t._id where h._id = "+from+";" ,null);
        cursor2 = db.rawQuery("select _id, h_type from type where _id = "+from+";",null);
        if(cursor.getCount()>0) {
            if (cursor.moveToNext()) {
                straddress=cursor.getString(3);
                address.setText(straddress);
                strname=cursor.getString(1);
                name.setText(strname);
                i=cursor.getInt(6);
                if(i==1){
                    btnadd.setBackgroundDrawable(fill);
                    btnadd.setTextColor(Color.WHITE);
                    btnadd.setText("DELETE");
                } else if (i == 0) {
                    btnadd.setBackgroundDrawable(empty);
                    btnadd.setTextColor(Color.rgb(0,167,184));
                    btnadd.setText("ADD");
                }
            }
        }

        if(cursor2 != null && cursor2.moveToFirst()){
            String strtype = hospital_type[cursor2.getInt(1)];
            if(cursor2.moveToNext()) {
                ttype = cursor2.getInt(1);
                strtype = strtype + hospital_type[ttype - 1];

            }
            type.setText(strtype);
            cursor2.close();
        }

        Spinner spin =(Spinner)findViewById(R.id.spindate);
        spin.setPrompt("Select Date");
        adapter=ArrayAdapter.createFromResource(this,R.array.dates,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(adapter);
        spin.setSelection(nWeek-1);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
              String sqltime;
              switch (position){
                  case 0:
                      time.setText(cursor.getString(7));
                      break;
                  case 1:
                      time.setText(cursor.getString(8));
                      break;
                  case 2:
                      time.setText(cursor.getString(9));
                      break;
                  case 3:
                      time.setText(cursor.getString(10));
                      break;
                  case 4:
                      time.setText(cursor.getString(11));
                      break;
                  case 5:
                      time.setText(cursor.getString(12));
                      break;
                  case 6:
                      time.setText(cursor.getString(13));
                      break;
              }
          }
          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {
          }
        });

    }
    public void mClick(View v){
        String sql;
        switch(v.getId()){
            case R.id.btnaddmy:
                if(i==1){
                    i=0;
                sql = "update hospital set is_like = 0 where _id = " + cursor.getInt(0) + ";";
                db.execSQL(sql);
                //btnadd.setBackground(@drawable/);
                    btnadd.setBackgroundDrawable(empty);
                    btnadd.setTextColor(Color.rgb(0,167,184));
                    btnadd.setText("ADD");
                }else if(i==0){
                    i=1;
                    sql = "update hospital set is_like = 1 where _id = " + cursor.getInt(0) + ";";
                    db.execSQL(sql);
                    btnadd.setBackgroundDrawable(fill);
                    btnadd.setTextColor(Color.WHITE);
                    btnadd.setText("DELETE");
                }
                break;
            case R.id.btncall:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+cursor.getString(2)));
                try {
                    startActivity(callIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map2 = googleMap;
        LatLng SEOUL = new LatLng(cursor.getFloat(4), cursor.getFloat(5));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        map2.addMarker(markerOptions.position(SEOUL).title(cursor.getString(1)));
    }
}
