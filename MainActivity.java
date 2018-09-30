package com.example.drseoul;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.Calendar;

import static com.google.android.gms.maps.GoogleMap.*;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener{
    DatabaseHelper helper;
    SQLiteDatabase db;
    Cursor cursor, cursor2, cursor3;
    LayoutInflater inflater;
    private GoogleMap map;
    Marker[] marker = new Marker[61];
    MarkerOptions markerOptions = new MarkerOptions();
    Calendar cal = Calendar.getInstance();
    int nWeek = cal.get(Calendar.DAY_OF_WEEK);
    String textTime, textPhone;
    int textDetails;
    AutoCompleteTextView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (AutoCompleteTextView) findViewById(R.id.search_edit);
        String[] hospitals = getResources().getStringArray(R.array.hospital_seoul);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hospitals);
        search.setAdapter(adapter);

        inflater =(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        helper= new DatabaseHelper(this);
        db = helper.getWritableDatabase();
        cursor = db.rawQuery("select h.*, t.sun, t.mon, t.tue, t.wed, t.thu, t.fri, t.sat from hospital h inner join time t where h._id = t._id;", null);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
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

            case R.id.btnclinic:
                ToggleButton btnClinic=(ToggleButton)findViewById(R.id.btnclinic);
                if(btnClinic.isChecked()){
                    btnClinic.setBackgroundColor(Color.rgb(0,167,184));
                    btnClinic.setTextColor(Color.WHITE);
                    addClinicMarker();
                }else{
                    btnClinic.setBackgroundColor(Color.WHITE);
                    btnClinic.setTextColor(Color.GRAY);
                    eraseClinicMarker();
                }
                break;

            case R.id.btnhospital:
                ToggleButton btnhospital=(ToggleButton)findViewById(R.id.btnhospital);
               if(btnhospital.isChecked()){
                   btnhospital.setBackgroundColor(Color.rgb(0,167,184));
                   btnhospital.setTextColor(Color.WHITE);
                   addHospitalMarker();
               }else{
                   btnhospital.setBackgroundColor(Color.WHITE);
                   btnhospital.setTextColor(Color.GRAY);
                   eraseHospitalMarker();
               }
                break;

            case R.id.btntreattype:
                Intent intent4=new Intent(this, TypeActivity.class);
                startActivity(intent4);
                break;
            case R.id.btnsearch:
                String str = search.getText().toString();
                if(str.length()==0){
                    Toast.makeText(this,"Enter Hospital name",Toast.LENGTH_SHORT).show();
                }
                else{
                    String exist = "select _id from hospital where name like '%"+str+"%';";
                    cursor3 = db.rawQuery(exist, null);
                    if(cursor3.getCount()==0){
                        Toast.makeText(this,"No Hospital Matches",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent searched=new Intent(MainActivity.this, SearchResultActivity.class);
                        searched.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        searched.putExtra("word",str);
                        startActivity(searched);
                    }
                }
                break;
        }
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        map = googleMap;

        map.setOnMarkerClickListener((OnMarkerClickListener) this);

        LatLng SEOUL = new LatLng(37.49, 127.01);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle(marker.getTitle());

        cursor2 = db.rawQuery("select t.sun, t.mon, t.tue, t.wed, t.thu, t.fri, t.sat, h.phoneNum, h._id from hospital h inner join time t where h._id = t._id and h.name = " +"'"+marker.getTitle()+"';", null);

        if(cursor2 != null && cursor2.moveToFirst()){
            textTime = cursor2.getString(nWeek-1);
            textPhone = cursor2.getString(7);
            textDetails = cursor2.getInt(8);
            cursor2.close();
        }
        dialog.setMessage(dayOfWeek()+ " : " +textTime);
        dialog.setPositiveButton("DETAILS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent hospitals=new Intent(MainActivity.this, HospitalActivity.class);
                hospitals.putExtra("from",textDetails);
                startActivity(hospitals);
            }
        });
        dialog.setNegativeButton("CALL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+textPhone));
                try {
                    startActivity(callIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        AlertDialog dlg = dialog.show();
        dlg.getWindow().setGravity(Gravity.BOTTOM);
        return false;
    }

    public String dayOfWeek(){
        String strweek[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        int intweek[] = {1,2,3,4,5,6,7};
        String Q = null;
        for(int i=1; i<8; i++) {
            if (nWeek == intweek[i - 1]) {
                Q = strweek[i - 1];
            }
        }
        return Q;
    }

    public void addHospitalMarker(){
        for(int i=0; i<=30; i++){
            cursor.moveToPosition(i);
            marker[i] = map.addMarker(markerOptions.position(new LatLng(cursor.getFloat(4), cursor.getFloat(5))).title(cursor.getString(1)));
        }
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
    public void addClinicMarker(){
        for(int i=31; i<=60; i++){
            cursor.moveToPosition(i);
            marker[i] = map.addMarker(markerOptions.position(new LatLng(cursor.getFloat(4), cursor.getFloat(5))).title(cursor.getString(1)));
        }
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
    private void eraseHospitalMarker() {
        for(int i=0; i<=30; i++){
            marker[i].remove();
        }
    }
    private void eraseClinicMarker() {
        for(int i=31; i<=60; i++){
            marker[i].remove();
        }
    }
}
