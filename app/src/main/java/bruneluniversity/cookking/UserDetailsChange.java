package bruneluniversity.cookking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDetailsChange extends AppCompatActivity {

    public Button b1;
    public Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details_change);

        getSupportActionBar().setTitle("Change details");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        b1 = (Button) findViewById(R.id.to_profile);
        b2 = (Button) findViewById(R.id.save_changes);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //click on cancel leads to user profile
                toProfile();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ToDo changes are saved in the database
                //ToDo user is notified about the changes made
                //user is directed to the profile page
                toProfile();



            }
        });

    }

    public void toProfile(){

        Intent i = new Intent(this, UserProfile.class);
        startActivity(i);

    }
}
