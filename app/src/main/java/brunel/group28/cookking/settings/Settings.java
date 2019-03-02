package brunel.group28.cookking.settings;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

import java.io.FileWriter;
import java.io.IOException;

import brunel.group28.cookking.R;

public class Settings extends AppCompatActivity {

   // private boolean IsvibrationOn;
    //private boolean IsLEDOn;

    private Switch LEDSwitch;
    private String LEDDuration;

    private Switch vibrationSwitch;
    private String vibrationDuration;
    private int IntegerVibrationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        //Notify();

        System.out.println("yeyeyey");
        try {
            usingFileWriter();
        }catch (IOException E){
            System.out.println("fail");
        }
    }



    public void Notify(){
        vibrationSwitch = findViewById(R.id.VibrateSwitch);
        LEDSwitch = findViewById(R.id.LEDSwitch);


                if(vibrationSwitch.isChecked()) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


                        if(vibrationDuration.contains("[0-9]+")) {

                        IntegerVibrationDuration = Integer.parseInt(vibrationDuration);

                        vibrator.vibrate(IntegerVibrationDuration);
                         }

                 }


                if(LEDSwitch.isChecked()){

                    if(LEDDuration.contains("[0-9]+")) {



                    NotificationManager nm = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );
                    Notification notif = new Notification();
                    notif.ledARGB = 0xFFff0000;
                    notif.flags = Notification.FLAG_SHOW_LIGHTS;
                    notif.ledOnMS = 1000;
                    notif.ledOffMS = 1000;


                    }


                }



    }



    public static void usingFileWriter() throws IOException
    {
        System.out.println("okokoko");

        String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";

        FileWriter fileWriter = new FileWriter("C:/Users/Ray/Documents/GitHub/cs2001-18-19-group-28/app/src/main/java/brunel/group28/cookking/settings/savedSettings.txt");
        fileWriter.write(fileContent);
        fileWriter.close();


    }





}




