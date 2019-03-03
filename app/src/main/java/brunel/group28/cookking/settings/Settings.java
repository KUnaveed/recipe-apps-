package brunel.group28.cookking.settings;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import brunel.group28.cookking.MainActivity;
import brunel.group28.cookking.R;

public class Settings extends AppCompatActivity implements View.OnClickListener {

   // private boolean IsvibrationOn;
    //private boolean IsLEDOn;

    private Switch LEDSwitcher;
    private TextView LEDDuration;
    private int LEDLength;

    private Switch vibrationSwitch;
    private Spinner vibrationLength;


    private int IntegerVibrationDuration;

    private Button UpdateButton;
    private Button ChangeActivity;


    private TextView VibrationDuration;
    private int VibrateLength;

    SharedPreferences sharedPref;

    private Button TestNotification;
    private Button ClearSettingPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        UpdateButton = findViewById(R.id.UpdateSettingsButton);
        //UpdateButton = new Button(this);
        UpdateButton.setOnClickListener(this);


        ChangeActivity = findViewById(R.id.ChangeActivitys);
        //ChangeActivity = new Button(this);
        ChangeActivity.setOnClickListener(this);

        LEDSwitcher = findViewById(R.id.LEDSwitch);
        LEDSwitcher.setOnClickListener(this);

        LEDDuration = findViewById(R.id.LEDLength);
        LEDDuration.setOnClickListener(this);

        vibrationSwitch = findViewById(R.id.VibrateSwitch);
        vibrationSwitch.setOnClickListener(this);

        VibrationDuration = findViewById(R.id.VibrationLength);
        VibrationDuration.setOnClickListener(this);

        TestNotification = findViewById(R.id.testnotification);
        TestNotification.setOnClickListener(this);

        ClearSettingPreferences = findViewById(R.id.ClearSettingsButton);
        ClearSettingPreferences.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){

        if(v == UpdateButton) {
            VibrateLength = Integer.parseInt(VibrationDuration.getText().toString());
            LEDLength = Integer.parseInt(LEDDuration.getText().toString());
           WritePreferences();
        }

        //System.out.println("rayayayay");

        if(v == ChangeActivity){

            Intent myIntent = new Intent(this, Testing2.class);
            startActivity(myIntent);

        }

//        if(v == VibrationDuration){
//           // VibrateLength = Integer.parseInt(VibrationDuration.toString());
//
//            VibrateLength = Integer.parseInt(VibrationDuration.getText().toString());
//
//
//        }


//        if(v == LEDDuration){
//            LEDLength = Integer.parseInt(LEDDuration.toString());
//        }

        if(v == TestNotification){
            notification();
        }

        if(v == ClearSettingPreferences){
            sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPref.edit();

            editor.clear().commit();

        }






    }



    public void Notify(){
        vibrationSwitch = findViewById(R.id.VibrateSwitch);
        LEDSwitcher = findViewById(R.id.LEDSwitch);


                if(vibrationSwitch.isChecked()) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


                        //if(vibrationDuration.contains("[0-9]+")) {

                      //  IntegerVibrationDuration = Integer.parseInt(vibrationDuration);

                        vibrator.vibrate(IntegerVibrationDuration);
                        // }

                 }


                if(LEDSwitcher.isChecked()){





                    NotificationManager nm = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );
                    Notification notif = new Notification();
                    notif.ledARGB = 0xFFff0000;
                    notif.flags = Notification.FLAG_SHOW_LIGHTS;
                    notif.ledOnMS = 1000;
                    notif.ledOffMS = 1000;





                }



    }



    public void WritePreferences() {

    sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);

    SharedPreferences.Editor editor = sharedPref.edit();

    if(isVibrationOnOrOff()){
        System.out.println("ray555");
        editor.putBoolean("vibrationSwitch", true);

        System.out.println(GetVibrationDuration() + "vibratedurtation method returned this");

        int output = GetVibrationDuration();

        System.out.println("ray555output" + output);

        editor.putInt("VibrationDuration", output);

    }else{
        System.out.println("ray666");
        editor.putBoolean("vibrationSwitch", false);
        editor.putInt("VibrationDuration", 0);
    }


    if(isLEDonOrOff()){
        System.out.println("ray777");
        editor.putBoolean("LEDSwitch", true);
        int output = GetLEDDuration();

        System.out.println("ray777 output" + output);

        editor.putInt("LEDDuration", output);
    }
    else{
        System.out.println("ray888");
        editor.putBoolean("LEDSwitch", false);
        editor.putInt("LEDDuration", 0);
    }

    editor.commit();


        //THIS WAS RIGHT BEFORE
//        sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);
//
//        SharedPreferences.Editor editor = sharedPref.edit();
//
//        editor.putString("vibrationSwitch", String.valueOf("true"));
//        editor.putString("LEDSwitch", String.valueOf("false"));
//
//
//        editor.commit();
//
//
//        System.out.println("okokok");
//        System.out.println("okokok");
//        System.out.println("okokok");
//        System.out.println("okokok");


    }






    public void notification(){

        System.out.println("ok");

        sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);
        boolean vibrateswitch  = sharedPref.getBoolean("vibrationSwitch",false);
        int vibrateduration = sharedPref.getInt("VibrationDuration", 0);

        boolean ledswitch = sharedPref.getBoolean("LEDSwitch", false);
        int ledduration = sharedPref.getInt("LEDDuration", 0);


        System.out.println(vibrateswitch + "this is vib Switch");
        System.out.println(vibrateduration + "this is vib duration");


        if (vibrateswitch == true && vibrateduration > 0){
            System.out.println("ray123");

            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(vibrateduration*1000);
        }

        if(ledswitch == true && ledduration > 0){
            System.out.println("ray321");
            NotificationManager nm = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );
            Notification notif = new Notification();
            notif.ledARGB = 0xFFff0000;
            notif.flags = Notification.FLAG_SHOW_LIGHTS;
            notif.ledOnMS = 1000;
            notif.ledOffMS = 1000;

        }




    }









    public boolean isVibrationOnOrOff(){

        vibrationSwitch = findViewById(R.id.VibrateSwitch);

        if(vibrationSwitch.isChecked() == true){

            return true;
        }
        else {
            return false;
        }

    }


    public boolean isLEDonOrOff(){

        LEDSwitcher = findViewById(R.id.LEDSwitch);

        if(LEDSwitcher.isChecked() == true){

            return true;
        }
        else {
            return false;
        }

    }


    public int GetVibrationDuration(){



            return VibrateLength;


    }


    public int GetLEDDuration(){

        if(LEDLength > 0 && LEDLength <10){

            return LEDLength;

        }
        else{
            return 0;
        }

    }














}




