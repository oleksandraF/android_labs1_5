package labs.consultations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exitClick(View view) {
        finish();
    }

    public void lab1Click(View view) {
        Intent lab1 = new Intent(this,lab1_activity.class);
        startActivity(lab1);
    }

    public void lab2Click(View view) {
        Intent lab2 = new Intent(this,lab2_activity.class);
        startActivity(lab2);
    }

    public void lab3Click(View view) {
        Intent lab3 = new Intent(this,lab3_activity.class);
        startActivity(lab3);
    }

    public void lab4Click(View view) {
        Intent lab4 = new Intent(this,lab4_activity.class);
        startActivity(lab4);
    }

    public void lab5Click(View view) {
        Intent lab5 = new Intent(this,lab5_activity.class);
        startActivity(lab5);
    }
}