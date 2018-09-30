package com.example.drseoul;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by user on 2018-09-27.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Medical.db";

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TIME = "time";
    private static final String TABLE_TYPE = "type";
    private static final String TABLE_HOSPITAL = "hospital";

    private static final String KEY_ID = "_id";
    private static final String KEY_TYPE_ID = "t_key";
    private static final String KEY_TIME_ID = "time_key";
    private static final String KEY_TYPE = "h_type";

    private static final String KEY_MON = "mon";
    private static final String KEY_TUE = "tue";
    private static final String KEY_WED = "wed";
    private static final String KEY_THU = "thu";
    private static final String KEY_FRI = "fri";
    private static final String KEY_SAT = "sat";
    private static final String KEY_SUN = "sun";


    //    private static final String CREATE_TABLE_HOSPITAL = "CREATE TABLE"
//            + TABLE_HOSPITAL + "(" + KEY_ID + "INTEGER PRIMARY KEY, " ++

    private static final String CREATE_TABLE_TYPE = "CREATE TABLE "
            + TABLE_TYPE + "(" + KEY_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_ID + " INTEGER, " + KEY_TYPE + " INTEGER" + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table time(_id integer primary key, sun text, mon text, tue text, wed text, thu text, fri text, sat text);");
        db.execSQL(CREATE_TABLE_TYPE);
        db.execSQL("create table hospital(_id integer primary key, name text, phoneNum text, address text, lat float, lng float, is_like bool);");

        db.execSQL("insert into " + TABLE_TIME + "(_id, sun, mon, tue, wed, thu, fri, sat)" + "values (1, 'Day Off', '11:00 ~ 20:00', '11:00 ~ 20:00', '11:00 ~ 19:00', '11:00 ~ 20:00', '11:00 ~ 20:00', '11:00 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (2, 'Day Off', '09:00 ~ 17:30 / 18:00 ~ 21:00', '09:00 ~ 17:30 / 18:00 ~ 21:00', '09:00 ~ 17:30 / 18:00 ~ 21:00', '09:00 ~ 17:30 / 18:00 ~ 21:00', '09:00 ~ 17:30 / 18:00 ~ 21:00', '09:00 ~ 12:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (3, 'Day Off', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 12:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (4, 'Day Off', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 12:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (5, 'Day Off', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 12:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (6, 'Day Off', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 13:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (7, 'Day Off', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 13:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (8, 'Day Off', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 12:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (9, 'Day Off', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (10, 'Day Off', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (11, 'Day Off', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (12, 'Day Off', '10:00 ~ 21:00', '10:00 ~ 21:00', '10:00 ~ 21:00', '10:00 ~ 18:30', '10:00 ~ 21:00', '10:00 ~ 14:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (13, 'Day Off', '09:00 ~ 17:00', '09:00 ~ 17:00', '09:00 ~ 17:00', '09:00 ~ 17:00', '09:00 ~ 17:00', '09:00 ~ 13:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (14, 'Day Off', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (15, 'Day Off', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 13:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (16, 'Day Off', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 13:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (17, 'Day Off', '09:00 ~ 16:00', '09:00 ~ 16:00', '09:00 ~ 16:00', '09:00 ~ 16:00', '09:00 ~ 16:00', '09:00 ~ 12:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (18, 'Day Off', '24 Hours', '24 Hours', '24 Hours', '24 Hours', '24 Hours', '24 Hours'); ");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (19, 'Day Off', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (20, 'Day Off', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 13:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (21, 'Day Off', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (22, 'Day Off', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (23, 'Day Off', '09:00 ~ 21:00', '09:00 ~ 18:30', '09:00 ~ 21:00', '09:00 ~ 18:30', '09:00 ~ 21:00', '09:00 ~ 14:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (24, 'Day Off', '09:30 ~ 18:30', '09:30 ~ 18:30', '09:30 ~ 18:30', '09:30 ~ 18:30', '09:30 ~ 18:30', '09:30 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (25, 'Day Off', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (26, 'Day Off', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 17:00', '08:30 ~ 12:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (27, 'Day Off', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00', '09:00 ~ 18:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (28, 'Day Off', '08:30 ~ 16:30', '08:30 ~ 16:30', '08:30 ~ 16:30', '08:30 ~ 16:30', '08:30 ~ 16:30', '08:30 ~ 16:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (29, 'Day Off', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 17:30', '08:30 ~ 12:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (30, 'Day Off', '09:00 ~ 17:30', '09:00 ~ 17:30', '09:00 ~ 17:30', '09:00 ~ 17:30', '09:00 ~ 17:30', '09:00 ~ 12:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (31, 'Day Off', '09:00 ~ 17:00', '09:00 ~ 17:00', '09:00 ~ 17:00', '09:00 ~ 17:00', '09:00 ~ 17:00', '09:00 ~ 12:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (32, 'Day Off', '09:00 ~ 19:00', '09:00 ~ 20:00', '09:00 ~ 19:00', '09:00 ~ 19:00', '09:00 ~ 19:00', '09:00 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (33, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (34, 'Day Off', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (35, 'Day Off', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 18:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (36, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (37, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (38, 'Day Off', '10:00 ~ 20:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 20:00', '10:00 ~ 19:00', '10:00 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (39, 'Day Off', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 15:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (40, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (41, 'Day Off', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (42, 'Day Off', '09:00 ~ 19:00', '09:00 ~ 19:00', '09:00 ~ 19:00', '09:30 ~ 21:00', '09:00 ~ 19:00', '09:30 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (43, 'Day Off', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 18:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (44, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 18:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (45, 'Day Off', '10:00 ~ 18:30', '10:00 ~ 20:00', '10:00 ~ 18:30', '10:00 ~ 18:30', '10:00 ~ 20:00', '10:00 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (46, 'Day Off', '08:00 ~ 16:00', '08:00 ~ 16:00', '08:00 ~ 16:00', '08:00 ~ 16:00', '08:00 ~ 16:00', '08:00 ~ 13:00(Every 2 weeks)');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (47, 'Day Off', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 18:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (48, 'Day Off', '09:00 ~ 20:00', '09:00 ~ 20:00', '09:00 ~ 20:00', 'Day Off', '09:00 ~ 20:00', '09:00 ~ 19:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (49, 'Day Off', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (50, 'Day Off', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (51, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (52, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 21:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (53, 'Day Off', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 19:00', '09:30 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (54, 'Day Off', '09:00 ~ 18:30', '09:00 ~ 18:30', '09:00 ~ 18:30', '09:00 ~ 18:30', '09:00 ~ 18:30', 'Day Off');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (55, 'Day Off', '09:00 ~ 19:00', '09:00 ~ 19:00', '09:00 ~ 19:00', '09:30 ~ 21:00', '09:00 ~ 20:00', '09:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (56, 'Day Off', '11:00 ~ 21:00', '11:00 ~ 21:00', '11:00 ~ 21:00', '11:00 ~ 21:00', '11:00 ~ 21:00', '10:30 ~ 16:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (57, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 21:00', 'Day Off', '10:00 ~ 21:00', '09:00 ~ 17:30');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (58, 'Day Off', '10:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 20:00', '11:00 ~ 20:00', '10:00 ~ 20:00', '10:00 ~ 17:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (59, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 20:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 20:00', '10:00 ~ 16:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (60, 'Day Off', '08:00 ~ 16:00', '08:00 ~ 16:00', '08:00 ~ 16:00', '08:00 ~ 16:00', '08:00 ~ 16:00', '07:00 ~ 13:00');");
        db.execSQL("insert into time (_id, sun, mon, tue, wed, thu, fri, sat) values (61, 'Day Off', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 19:00', '10:00 ~ 16:00');");


        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (1, 1);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (2, 2);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (3, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (4, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (5, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (6, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (7, 4);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (8, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (9, 2);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (10, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (11, 4);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (12, 5);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (13, 6);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (14, 7);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (15, 2);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (16, 2);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (17, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (18, 3);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (19, 8);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (19, 10);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (20, 2);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (21, 3);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (22, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (22, 8);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (23, 5);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (24, 5);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (25, 2);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (26, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (27, 2);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (28, 7);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (29, 8);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (29, 11);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (30, 12);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (31, 3);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (32, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (32, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (32, 15);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (33, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (33, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (33, 16);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (33, 17);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (34, 18);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (34, 19);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (34, 20);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (35, 17);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (35, 21);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (36, 20);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (36, 22);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (37, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (37, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (37, 15);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (38, 23);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (38, 24);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (38, 29);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (39, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (39, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (39, 17);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (39, 26);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (39, 27);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (40, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (40, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (40, 15);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (40, 21);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (41, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (41, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (41, 15);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (41, 16);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (41, 17);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 15);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 16);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 17);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 18);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 28);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 29);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (42, 30);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (43, 16);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (43, 17);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (43, 32);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (44, 31);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (45, 1);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (45, 15);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (45, 17);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (46, 35);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (47, 13);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (48, 33);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (49, 18);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (49, 23);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (50, 20);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (50, 22);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (50, 23);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (50, 31);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (51, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (51, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (51, 15);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (51, 17);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (52, 13);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (53, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (53, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (53, 15);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (53, 16);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (53, 19);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (53, 23);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (54, 34);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (55, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (55, 14);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (55, 15);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (55, 17);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (55, 23);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (56, 16);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (56, 20);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (56, 31);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (57, 24);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (58, 16);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (58, 20);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (59, 13);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (59, 27);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (59, 31);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (60, 35);");

        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (61, 16);");
        db.execSQL("insert into " + TABLE_TYPE + " (_id, h_type)" + " values (61, 23);");

        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(1, '365 mc Hospital', '010-2171-3657', '126, Seochojungang-ro, Seocho-gu, Seoul', 37.493013, 127.014077, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(2, 'CM Hospital', '02-2678-0001', '13, Yeongdeungpo-ro 36-gil, Yeongdeungpo-gu, Seoul', 37.519004, 126.903935, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(3, 'Gangnam Severance Hospital', '02-974-3653', '211, Eonju-ro, Gangnam-gu, Seoul', 37.492974, 127.046234, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(4, 'Gangdong Kyunghee University Hospital', '02-440-7000', '892, Dongnam-ro, Gangdong-gu, Seoul', 37.553017, 127.157220, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(5, 'Gangbuk Samsung Hospital', '1599-8114', '29, Saemunan-ro, Jongno-gu, Seoul', 37.568554, 126.967410, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(6, 'Konkuk University Medical Center', '02-1588-1533', '120-1, Neungdong-ro, Gwangjin-gu, Seoul', 37.541080, 127.072275, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(7, 'Kim''s Eye Hospital', '1577-2639', '136, Yeongsin-ro, Yeongdeungpo-gu, Seoul', 37.519723, 126.901514, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(8, 'Kyunghee University Medical Center', '02-958-8114', '23, Kyungheedae-ro, Dongdaemun-gu, Seoul', 37.593894, 127.051335, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(9, 'Godoil Hospital', '1577-8907', '505, Gangnam-daero, Seocho-gu, Seoul', 37.506977, 127.022688, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(10, 'Korea University Medical Center Anam Hospital', '1577-0083', '73, Inchon-ro, Seongbuk-gu, Seoul', 37.587054, 127.026768, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(11, 'Kwangdong Hospital', '02-2222-4888', '612, Bongeunsa-ro, Gangnam-gu, Seoul',37.514201, 127.062104, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(12, 'Good Life Dental Hospital', '02-3446-2755', '476, Gangnam-daero, Gangnam-gu, Seoul', 37.504791, 127.024911, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(13, 'Daehang Hospital', '02-6388-8114', '2151, Nambusunhwan-ro, Seocho-gu, Seoul', 37.475539, 126.98796, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(14, 'Mizmedi Hospital', '02-2007-1000', '295, Gangseo-ro, Gangseo-gu, Seoul', 37.552173, 126.836089, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(15, 'Barosun Hospital', '1666-5853', '295, Gangseo-ro, Gangseo-gu, Seoul', 37.660381, 127.042219, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(16, 'Seoul Bumin Hospital', '1577-7582', '295, Gangseo-ro, Gangseo-gu, Seoul', 37.556895, 126.850929, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(17, 'Samsung Seoul Hospital', '02-3410-2114', '295, Gangseo-ro, Gangseo-gu, Seoul', 37.488131, 127.085542, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(18, 'Seoul National University Hospital', '1588-5700', '101, Daehak-ro, Jongno-gu, Seoul', 37.579692, 126.999023, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(19, 'Seoul Asan Hospital', '1599-8114', '88, Olympic-ro 43-gil, Songpa-gu, Seoul', 37.526929, 127.108407, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(20, 'Seran Clinic', '1599-1987', '256, Tongil-ro, Jongno-gu, Seoul', 37.575116, 126.957485, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(21, 'Severance Hospital', '1599-1004', '50-1, Yonsei-ro, Seodaemun-gu, Seoul', 37.562281, 126.941204, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(22, 'Soonchunhyang University Hospital Seoul', '02-709-9000', '59, Daesagwan-ro, Yongsan-gu, Seoul', 37.533689, 127.004201, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(23, 'Sinchon Dain Dental Clinic', '02-719-2275', '94, Sinchon-ro, Mapo-gu, Seoul', 37.554974, 126.935993, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(24, 'S Plant Dental Clinic', '02-512-0700', '410, Dosan-daero, Gangnam-gu, Seoul', 37.522972, 127.040479, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(25, 'Wooridul Hospital', '1688-0088', '445, Hakdong-ro, Gangnam-gu, Seoul', 37.518974, 127.049756, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(26, 'Inje University Seoul Paik Hospital', '02-2270-0114', '9, Mareunnae-ro, Jung-gu, Seoul', 37.565008, 126.988795, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(27, 'Jaseng Hospital of Korean Medicine', '1577-0007', '536, Gangnam-daero, Gangnam-gu, Seoul', 37.509897, 127.022353, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(28, 'Cheil General Hospital ', '02-2000-7114', '17, Seoae-ro 1-gil, Jung-gu, Seoul', 37.561734, 126.999227, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(29, 'Chungang University Hospital', '1800-1114', '102, Heukseok-ro, Dongjak-gu, Seoul', 37.506763, 126.960705, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(30, 'Hangang Sacred Heart Hospital, Hallym University', '02-2639-5114', '12, Beodeunaru-ro 7-gil, Yeongdeungpo-gu, Seoul', 37.523152, 126.909743, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(31, 'Hanyang University Hospital', '02-2290-8114', '222-1, Wangsimni-ro, Seongdong-gu, Seoul', 37.559647, 127.04398, 0);");

        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(32, 'April 31 Plastic Surgery', '02-540-6777', '548, Gangnam-daero, Gangnam-gu, Seoul', 37.511098, 127.021868, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(33, 'BK Plastic Surgery Clinic', '02-544-0404', '106, Dosan-daero, Gangnam-gu, Seoul', 37.516292, 127.020428, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(34, 'CU Clean Up Dermatology Clinic', '02-556-9070', '17, Teheran-ro 87-gil, Gangnam-gu, Seoul', 37.508907, 127.058387, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(35, 'JJ Hong Jin Joo Plastic Surgery', '02-544-8807', '853, Nonhyeon-ro, Gangnam-gu, Seoul', 37.525240, 127.028024, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(36, 'JK Plastic Surgery', '02-777-0337', '835, Nonhyeon-ro, Gangnam-gu, Seoul', 37.523279, 127.027874, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(37, 'JW Plastic Surgery', '010-7195-5114', '836, Nonhyeon-ro, Gangnam-gu, Seoul', 37.523083, 127.028582, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(38, 'Kang Dermatology Clinic', '02-567-4962', '304, Seocho-daero, Seocho-gu, Seoul', 37.494516, 127.017559, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(39, 'Gyalumhan Plastic Surgery', '02-535-6688', '390, Gangnam-daero, Gangnam-gu, Seoul', 37.497788, 127.028534, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(40, 'Glovi Plastic Surgery', '02-515-3399', '25, Apgujeong-ro 28-gil, Gangnam-gu, Seoul', 37.524716, 127.027831, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(41, 'Dream Plastic Surgery', '02-518-2615', '848, Nonhyeon-ro, Gangnam-gu, Seoul', 37.524572, 127.028877, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(42, 'DA Plastic Surgery', '02-515-4600', '7, Seocho-daero 77-gil, Seocho-gu, Seoul', 37.502551, 127.024803, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(43, 'Leaders Dermatology Clinic', '010-9548-7833', '843, Eonju-ro, Gangnam-gu, Seoul', 37.525713, 127.032923, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(44, 'Riz OBGYN', '02-540-8811', '127, Dosan-daero, Gangnam-gu, Seoul', 37.517602, 127.022393, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(45, 'Banobagi Plastic Surgery', '02-562-6001', '517, Nonhyeon-ro, Gangnam-gu, Seoul', 37.502655, 127.035742, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(46, 'Seoul National University Hospital Healthcare System Gangnam Center', '02-2112-5503', '152, Teheran-ro, Gangnam-gu, Seoul', 37.499937, 127.036475, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(47, 'Seoul Balgeunsesang Eye Clinic', '02-53443-0880', '823, Seolleung-ro, Gangnam-gu, Seoul', 37.525569, 127.039376, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(48, 'Best-Skilled OBGYN', '02-575-4888', '841, Nonhyeon-ro, Gangnam-gu, Seoul', 37.524061, 127.027983, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(49, 'Arumdaun Nara Dermatology Clinic (Gangnam)', '02-3420-2206', '390, Gangnam-daero, Gangnam-gu, Seoul', 37.496465, 127.029197, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(50, 'Arumdaun Nara Dermatology Clinic (Myeong-dong)', '02-755-2105', '125, Toegye-ro, Jung-gu, Seoul', 37.561106, 126.985686, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(51, 'Iwell Plastic Surgery', '02-542-2017', '843, Nonhyeon-ro, Gangnam-gu, Seoul', 37.524472, 127.027969, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(52, 'SNB Eye Clinic', '02-3416-1050', '842, Nonhyeon-ro, Gangnam-gu, Seoul', 37.523881, 127.028745, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(53, 'Apgujeong Seoul Plastic Surgery', '02-547-5100', '840, Nonhyeon-ro, Gangnam-gu, Seoul', 37.523621, 127.028593, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(54, 'Yeson Voice Center', '02-3444-0559', '874, Eonju-ro, Gangnam-gu, Seoul', 37.528589, 127.034058, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(55, 'Wonjin Plastic Surgery', '02-3477-3300', '419, Gangnam-daero, Seocho-gu, Seoul', 37.499856, 127.026254, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(56, 'Wiz N Mi Woman Clinic', '1644-6401', '21, Myeongdong 7-gil, Jung-gu, Seoul', 37.564699, 126.983821, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(57, 'Lee Moon Won Korean Medicine Clinic', '02-511-1079', '41, Hakdong-ro 97-gil, Gangnam-gu, Seoul', 37.522373, 127.054294, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(58, 'Cheongdam Oracle Dermatology and Plastic Surgery Clinic', '070-4880-2111', '333, Bongeunsa-ro, Gangnam-gu, Seoul', 37.510383, 127.043157, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(59, 'CheongdamU Plastic Surgery & Dermatology', '010-8856-2415', '6, Samseong-ro 145-gil, Gangnam-gu, Seoul', 37.522301, 127.047666, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(60, 'Hanshin Medipia Clinic', '02-591-5414', '94, Jamwon-ro, Seocho-gu, Seoul', 37.512781, 127.007028, 0);");
        db.execSQL("insert into hospital(_id, name, phoneNum, address, lat, lng, is_like) values(61, 'HERSHE Plastic Surgery & Dermatology', '02-511-3911', '502, Dosan-daero, Gangnam-gu, Seoul', 37.523929, 127.047908, 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }
}