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
    private String LEDDurationer;

    private Switch vibrationSwitch;
    private Spinner vibrationLength;


    private int IntegerVibrationDuration;

    private Button UpdateButton;
    private Button ChangeActivity;


    private TextView VibrationDuration;

    SharedPreferences sharedPref;




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

        vibrationSwitch = findViewById(R.id.VibrateSwitch);
        vibrationSwitch.setOnClickListener(this);

        VibrationDuration = findViewById(R.id.VibrationLength);
        VibrationDuration.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){

        if(v == UpdateButton) {

            try {
                usingFileWriter();
            } catch (IOException e) {

            }
        }

        //System.out.println("rayayayay");

        if(v == ChangeActivity){

            Intent myIntent = new Intent(this, Testing2.class);
            startActivity(myIntent);

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

                    if(LEDDurationer.contains("[0-9]+")) {



                    NotificationManager nm = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );
                    Notification notif = new Notification();
                    notif.ledARGB = 0xFFff0000;
                    notif.flags = Notification.FLAG_SHOW_LIGHTS;
                    notif.ledOnMS = 1000;
                    notif.ledOffMS = 1000;


                    }


                }



    }



    public  void usingFileWriter() throws IOException {

    sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);

    SharedPreferences.Editor editor = sharedPref.edit();

    if(isVibrationOnOrOff()){
        editor.putBoolean("vibrationSwitch", true);
    }else{
        editor.putBoolean("vibrationSwitch", false);
    }


    if(isLEDonOrOff()){
        editor.putBoolean("LEDSwitch", true);
    }
    else{
        editor.putBoolean("LEDSwitch", false);
    }




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











}




