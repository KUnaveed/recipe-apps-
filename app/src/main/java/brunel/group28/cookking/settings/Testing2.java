package brunel.group28.cookking.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import brunel.group28.cookking.R;



public class Testing2 extends AppCompatActivity {

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing2);


        sharedPref = getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);


        String ok = sharedPref.getString("vibrationSwitch","false");

        String ok2 = sharedPref.getString("LEDSwitch","false");

        Toast.makeText(Testing2.this, ok, Toast.LENGTH_LONG).show();

        Toast.makeText(Testing2.this, ok2, Toast.LENGTH_LONG).show();
    }
}
