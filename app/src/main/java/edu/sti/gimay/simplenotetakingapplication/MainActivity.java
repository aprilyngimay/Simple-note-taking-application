package edu.sti.gimay.simplenotetakingapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper = null;
    private SQLiteDatabase db = null;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        long id = dbHelper.insertNote(db, "My First Note", "This is my very first note!" );
        if(id > 0){
            Log.d(TAG, "onCreate Note was inserted");

        }
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.add_notes){
            //start the add note activity here

            Intent noteIntent = new Intent(this, Notes.class);
            startActivity(noteIntent);

        }
        return true;
    }
}
