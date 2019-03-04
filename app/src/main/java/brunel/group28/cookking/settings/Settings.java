/**
 *
 * To be able to send notifications to the user please call the notification method from your activity.
 *
 *
 */


package brunel.group28.cookking.settings;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


import brunel.group28.cookking.MainActivity;
import brunel.group28.cookking.R;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    // private boolean IsvibrationOn;
    //private boolean IsLEDOn;

    private Switch LEDSwitcher;
    private TextView LEDDuration;
    private int LEDLength;

    private Switch vibrationSwitch;
    private TextView VibrationDuration;
    private int VibrateLength;

    private Switch ringtoneSwitch;
    private TextView RingtoneDuration;
    private int RingToneLength;


    //private Spinner vibrationLength;


    //private int IntegerVibrationDuration;


    //button
    private Button UpdateButton;
    private Button ChangeActivity;
    private Button TestNotification;
    private Button ClearSettingPreferences;


    //pref
    SharedPreferences sharedPref;

    SeekBar volumeControl;

    View view;// used to change background colour

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.appcolour);

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

        RingtoneDuration = findViewById(R.id.RingtoneLength);
        RingtoneDuration.setOnClickListener(this);

        TestNotification = findViewById(R.id.testnotification);
        TestNotification.setOnClickListener(this);

        ClearSettingPreferences = findViewById(R.id.ClearSettingsButton);
        ClearSettingPreferences.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == UpdateButton) {
            RingToneLength = Integer.parseInt(RingtoneDuration.getText().toString());
            VibrateLength = Integer.parseInt(VibrationDuration.getText().toString());
            LEDLength = Integer.parseInt(LEDDuration.getText().toString());
            WritePreferences();
        }

        //System.out.println("rayayayay");

        if (v == ChangeActivity) {

            Intent myIntent = new Intent(this, Testing2.class);
            startActivity(myIntent);

        }

        if (v == TestNotification) {
            notification();
        }

        if (v == ClearSettingPreferences) {
            sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPref.edit();

            editor.clear().commit();

        }

    }


    public void WritePreferences() {

        sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        if (isVibrationOnOrOff()) {
            System.out.println("ray555");
            editor.putBoolean("vibrationSwitch", true);

            System.out.println(GetVibrationDuration() + "vibratedurtation method returned this");

            int output = GetVibrationDuration();

            System.out.println("ray555output" + output);

            editor.putInt("VibrationDuration", output);

        } else {
            System.out.println("ray666");
            editor.putBoolean("vibrationSwitch", false);
            editor.putInt("VibrationDuration", 0);
        }


        if (isLEDonOrOff()) {
            System.out.println("ray777");
            editor.putBoolean("LEDSwitch", true);
            int output = GetLEDDuration();

            System.out.println("ray777 output" + output);

            editor.putInt("LEDDuration", output);
        } else {
            System.out.println("ray888");
            editor.putBoolean("LEDSwitch", false);
            editor.putInt("LEDDuration", 0);
        }


        if (isRingtoneonOrOff()) {
            System.out.println("ray999");
            editor.putBoolean("ringtoneSwitch", true);
            int output = GetRingtoneDuration();
            editor.putInt("RingtoneDuration", output);
        } else {
            System.out.println("ray000");
            editor.putBoolean("ringtoneSwitch", false);
            editor.putInt("RingtoneDuration", 0);
        }


        editor.commit();

    }


    public void notification() {

        System.out.println("ok");

        sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);
        boolean vibrateswitch = sharedPref.getBoolean("vibrationSwitch", false);
        int vibrateduration = sharedPref.getInt("VibrationDuration", 0);

        boolean ledswitch = sharedPref.getBoolean("LEDSwitch", false);
        int ledduration = sharedPref.getInt("LEDDuration", 0);

        boolean ringtoneswitch = sharedPref.getBoolean("ringtoneSwitch", false);
        int ringtoneduration = sharedPref.getInt("RingtoneDuration", 0);

        System.out.println(vibrateswitch + "this is vib Switch");
        System.out.println(vibrateduration + "this is vib duration");

        System.out.println(ringtoneswitch + "this is ringtone Switch");
        System.out.println(ringtoneduration + "this is ringtone duration");


        if (vibrateswitch == true && vibrateduration > 0) {
            System.out.println("ray123");

            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(vibrateduration * 1000);
        }

        if (ledswitch == true && ledduration > 0) {
            System.out.println("ray321");
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification notif = new Notification();
            notif.ledARGB = 0xFFff0000;
            notif.flags = Notification.FLAG_SHOW_LIGHTS;
            notif.ledOnMS = ledduration;
            notif.ledOffMS = 1000;

        }

        if (ringtoneswitch == true && ringtoneduration > 0) {

            final MediaPlayer mp;

            mp = MediaPlayer.create(this, R.raw.ringtone);
            mp.start();


            new CountDownTimer(ringtoneduration * 1000, 1000) {

                public void onTick(long millisUntilFinished) {
                    mp.start();
                }

                public void onFinish() {
                    System.out.println("completed");
                }
            }.start();

        }


    }


    public boolean isVibrationOnOrOff() {

        vibrationSwitch = findViewById(R.id.VibrateSwitch);

        if (vibrationSwitch.isChecked() == true) {

            return true;
        } else {
            return false;
        }

    }


    public boolean isLEDonOrOff() {

        LEDSwitcher = findViewById(R.id.LEDSwitch);

        if (LEDSwitcher.isChecked() == true) {

            return true;
        } else {
            return false;
        }

    }

    public boolean isRingtoneonOrOff() {

        ringtoneSwitch = findViewById(R.id.RingtoneSwitch);

        if (ringtoneSwitch.isChecked() == true) {

            return true;
        } else {
            return false;
        }

    }


    public int GetVibrationDuration() {


        return VibrateLength;


    }


    public int GetLEDDuration() {

        if (LEDLength > 0 && LEDLength < 10) {

            return LEDLength;

        } else {
            return 0;
        }

    }

    public int GetRingtoneDuration() {


        return RingToneLength;


    }


}