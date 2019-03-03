package brunel.group28.cookking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import brunel.group28.cookking.settings.Settings;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_main); // ORIGINAL
        Intent myIntent = new Intent(this, Settings.class);
            startActivity(myIntent);


    }

}
