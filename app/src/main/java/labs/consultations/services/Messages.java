package labs.consultations.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import labs.consultations.R;

// Служба періодичних повідомлень
public class Messages extends Service {

    private Thread messageThread ;

    @Override
    public void onCreate() {
        super.onCreate();
        messageThread = new Thread( ()->{
            Notification.Builder builder =
                    new Notification.Builder(this)
                            .setSmallIcon( android.R.drawable.ic_dialog_info )
                            .setContentTitle( getString( R.string.app_name ) )
                            .setContentText( getString( R.string.lab5_message ) ) ;

            Notification notification = builder.build();

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(3 ) ;
                } catch (InterruptedException e) {
                    return ;
                }

                notificationManager.notify(1, notification);
                Log.d("MSG SERVICE", "Notification sent" ) ;
            }
        } ) ;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if( messageThread != null && messageThread.isAlive() ) {
            messageThread.interrupt();
            messageThread = null ;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        messageThread.start() ;
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
