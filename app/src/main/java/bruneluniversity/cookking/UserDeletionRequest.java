package bruneluniversity.cookking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDeletionRequest extends AppCompatActivity {

    public Button b1;
    public Button b2;



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_deletion_request);

        getSupportActionBar().setTitle("Request Deletion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b1 = findViewById(R.id.button_deletion);
        b2 = findViewById(R.id.to_profile1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ToDo delete user data from database and prompt msg about it

                //after deletion user is directed back to the profile
                toProfile();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //click on cancel button leads to the user profile page
                toProfile();

            }
        });





    }

    public void toProfile(){

        Intent i = new Intent(this, UserProfile.class);
        startActivity(i);
    }



}
