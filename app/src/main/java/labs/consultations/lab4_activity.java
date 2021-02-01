package labs.consultations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;

public class lab4_activity extends AppCompatActivity {

    private Handler handler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);

        handler = new Handler() ;

        findViewById( R.id.lab4_img_logo ).setAnimation( AnimationUtils.loadAnimation( this, R.anim.fadein ) ) ;
        handler.postDelayed( ()->{ findViewById( R.id.lab4_tvText1 ).startAnimation( AnimationUtils.loadAnimation( lab4_activity.this, R.anim.blink ) ) ;}, 1000 ) ;
        handler.postDelayed( ()->{ findViewById( R.id.lab4_imq_que ).startAnimation( AnimationUtils.loadAnimation( lab4_activity.this, R.anim.rotate ) ) ; }, 2000 ) ;
        handler.postDelayed( ()->{ findViewById( R.id.lab4_tvText2 ).startAnimation( AnimationUtils.loadAnimation( lab4_activity.this, R.anim.fadein_long ) ) ; }, 2000 ) ;
        handler.postDelayed( ()->{ findViewById( R.id.lab4_img_logo ).startAnimation( AnimationUtils.loadAnimation( lab4_activity.this, R.anim.growup ) ) ; }, 2000 ) ;
    }
}