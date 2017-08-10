package com.grimreaper.sqlitepracticeapp.dbmsPkg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by grimReaper on 8/9/2017.
 */

public class DBMS extends SQLiteOpenHelper {
    public static String DBName = "UserDatabase.db";
    public static int DBVersion = 1;
    public String UserDetailTableQuery = "CREATE TABLE user_details(p_name TEXT,p_Fname TEXT,p_password TEXT,P_address TEXT)";

    public DBMS(Context context) {
        super(context, DBName, null, DBVersion);
        Log.e("DBMS=>", "yes Db bna d ha");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDetailTableQuery);
        Log.e("ONCREATE=>", "yes db ma table bn geya ha");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertNewUserIntoDb(SQLiteDatabase db, String Name, String Fname, String Pass, String Address) {
        ContentValues cv = new ContentValues();
        cv.put("p_name", Name);
        cv.put("p_Fname", Fname);
        cv.put("p_password", Pass);
        cv.put("P_address", Address);
        db.insert("user_details", null, cv);
        Log.e("insertNewUserIntoDb: ", "data is inserted");
    }


    public Cursor getAllRegisteredUsers(SQLiteDatabase db) {

        String[] projections = {
                "p_name",
                "p_Fname",
                "p_password",
                "P_address"
        };

        Cursor mCursor =  db.query("user_details",projections,null,null,null,null,null);
        return mCursor;
    }
}
