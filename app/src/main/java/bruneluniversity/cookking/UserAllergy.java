package bruneluniversity.cookking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserAllergy extends AppCompatActivity {


    public Button b1;
    public Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_allergy);

        b1 = findViewById(R.id.save_changes);
        b2 = findViewById(R.id.to_profile);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //click on cancel leads to User profile page
                toProfile();

            }
        });

    }

    public void toProfile(){

        Intent i = new Intent(this, UserProfile.class);
        startActivity(i);

    }






}
