package edu.sti.gimay.simplenotetakingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Calendar;

public class DbHelper extends SQLiteOpenHelper {

    public static final String TAG = "DbHelper";
    public static final String DB_NAME = "app_notes.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NOTES = "notes";
    public static final String COL_ID = "id";
    public static final String COL_TITLE = "title";
    public static final String COL_BODY = "body";
    public static final String COL_CREATED_AT = "created_at";
    public static final String COL_UPDATED_AT = "updated_at";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createNoteTable = "CREATE TABLE " + TABLE_NOTES + "(" +
                COL_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                COL_TITLE + " TEXT, " +
                COL_BODY + " TEXT, " +
                COL_CREATED_AT + " TEXT, " +
                COL_UPDATED_AT + " TEXT" +
                ")";

        sqLiteDatabase.execSQL(createNoteTable);
        Log.d(TAG, createNoteTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //inserting a note
    public long insertNote(SQLiteDatabase sqLiteDatabase, String title, String body) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

       // title t = title.getInstance();
       // String title = t.get(title.COL_TITLE);

       // body b = body.getInstance();
       // String body = b.get(body.COL_BODY);

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_BODY, body);
        cv.put(COL_CREATED_AT, year + "-" + month + "-" + day);
        cv.put(COL_UPDATED_AT, year + "-" + month + "-" + day);


        long id = sqLiteDatabase.insert(TABLE_NOTES, null, cv);
        return id;
   }

}
