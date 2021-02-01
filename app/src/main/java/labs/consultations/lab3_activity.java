package labs.consultations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class lab3_activity extends AppCompatActivity {

    private final String DB_NAME = "lab_3.db" ;
    private SQLiteDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);

        db = null;
        try {
           db = SQLiteDatabase.openDatabase( DB_NAME, null, SQLiteDatabase.OPEN_READONLY ) ;
        } catch( SQLiteException ex ) {
            // database doesn't exist

        }

        File dbFile = getApplicationContext().getDatabasePath( DB_NAME ) ;
        boolean isFirstStart = ! dbFile.exists() ;
        db = openOrCreateDatabase( DB_NAME, Context.MODE_PRIVATE, null ) ;
        if( isFirstStart ) {
            Toast.makeText(this,R.string.lab3_first_start, Toast.LENGTH_SHORT).show();
            db.execSQL( "CREATE TABLE Students ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, pass TEXT )" ) ;
            db.execSQL( "INSERT INTO Students (name, pass ) VALUES ( 'Ber O.A.', '1234' ), ( 'Gacha O.O.', '4321' ) " ) ;
        }
    }

    public void exitClick(View view) {
        startActivity( new Intent( getApplicationContext(), MainActivity.class ) ) ;
    }

    public void loginClick(View view) {
        String name = ( (EditText) findViewById( R.id.lab3_etName ) ).getText().toString() ;
        String pass = ( (EditText) findViewById( R.id.lab3_etPass ) ).getText().toString() ;
        if( name.equals( "" ) ) {
            Toast.makeText(this,R.string.lab3_no_name, Toast.LENGTH_SHORT).show();
            return ;
        }
        if( pass.equals( "" ) ) {
            Toast.makeText(this,R.string.lab3_no_pass, Toast.LENGTH_SHORT).show();
            return ;
        }
        String query = "SELECT id FROM Students WHERE name='"+name+"' AND pass='"+pass+"'";
        try {
            Cursor res = db.rawQuery( query, null ) ;
            if( res.moveToFirst() ) {
                int id = res.getInt( 0 ) ;
                Toast.makeText(this,R.string.lab3_login_ok, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,R.string.lab3_login_fail, Toast.LENGTH_SHORT).show();
            }
        } catch( Exception ignored ) {
            Toast.makeText(this,R.string.lab3_db_error, Toast.LENGTH_SHORT).show();
        }
    }
}