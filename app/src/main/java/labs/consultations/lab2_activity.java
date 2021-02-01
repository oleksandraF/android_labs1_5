package labs.consultations;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class lab2_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_2);
        // Контекстне меню для елемента
        registerForContextMenu( findViewById( R.id.lab2_press_me ) ) ;
        registerForContextMenu( findViewById( R.id.lab2_main_text ) ) ;
    }

    // Головне (Option) меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lab2_menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch( item.getItemId() ){
            case R.id.lab2_menu1_item1 :
                new AlertDialog.Builder( this )
                        .setTitle(R.string.lab2_dialog_header)
                        .setMessage(R.string.lab2_dialog_message)
                        .setIcon( android.R.drawable.ic_menu_help )
                        .setPositiveButton(R.string.lab2_dialog_pos_btn, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity( new Intent(lab2_activity.this, MainActivity.class) ) ;
                            }
                        })
                        .setNegativeButton(R.string.lab2_dialog_neg_btn,null)
                .show();

                return true;
            case R.id.lab2_menu1_item2:
                startActivity( new Intent(this, lab1_activity.class) ) ;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Контекстне меню
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(R.string.lab2_context_header);
        menu.setHeaderIcon(android.R.drawable.ic_menu_manage);
        getMenuInflater().inflate(R.menu.lab2_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int fontSize = 0 ;
        switch( item.getItemId() ) {
            case R.id.lab2_context_menu_small:
                fontSize = 11 ;
                break ;
            case R.id.lab2_context_menu_norm:
                fontSize = 14 ;
                break ;
            case R.id.lab2_context_menu_large:
                fontSize = 20 ;
                break ;
        }
        if(fontSize != 0 ) {
            ((TextView) findViewById(R.id.lab2_press_me)).setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
            ((TextView) findViewById(R.id.lab2_main_text)).setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        }
        return super.onContextItemSelected(item);
    }
}