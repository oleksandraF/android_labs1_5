package labs.consultations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class lab1_activity extends AppCompatActivity {

    private TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        tvDescription = findViewById( R.id.tvSelDescription ) ;

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lab1_vars, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] descrs = getResources().getStringArray( R.array.lab1_descr ) ;
                tvDescription.setText( descrs[ i ] ) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tvDescription.setText( R.string.lab1_descr ) ;
            }
        });
    }

    public void faq1Click(View view) {
        Toast.makeText(this,R.string.ans1, Toast.LENGTH_SHORT ).show() ;
    }

    public void faq2Click(View view) {
        Toast.makeText(this,R.string.ans2, Toast.LENGTH_SHORT ).show() ;
    }

    public void faq3Click(View view) {
        Toast.makeText(this,R.string.ans3, Toast.LENGTH_SHORT ).show() ;
    }
}