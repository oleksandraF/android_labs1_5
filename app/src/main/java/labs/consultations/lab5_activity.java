package labs.consultations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import labs.consultations.services.Messages;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class lab5_activity extends AppCompatActivity {

    Intent messagesService ;
    MediaPlayer clickSound ;

    private static final int CAMERA_REQUEST = 1001 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);

        messagesService = new Intent( this, labs.consultations.services.Messages.class ) ;
        clickSound = MediaPlayer.create( this, R.raw.button_click ) ;
    }

    public void startClick(View view) {
        clickSound.start() ;
        startService( messagesService ) ;
    }

    public void stopClick(View view) {
        clickSound.start() ;
        stopService( messagesService ) ;
    }

    public void getPhotoClick(View view) {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get( "data" ) ;
            ImageView puc = findViewById(R.id.lab5_ivPhoto);
            puc.setImageBitmap(photo);
        }
    }
}