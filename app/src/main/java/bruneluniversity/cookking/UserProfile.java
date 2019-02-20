package bruneluniversity.cookking;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static bruneluniversity.cookking.R.id.avatar;

public class UserProfile extends AppCompatActivity {

    ImageView user_avatar;

    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;

    //ToDo button and page for saved recipes



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);

      //  Button b1 = findViewById(R.id.button_username)
         b1 = findViewById(R.id.button_allergy);
         b2 = findViewById(R.id.button_deletion);
         b3 = findViewById(R.id.button_details);
         b4 = findViewById(R.id.button_saved_rec);
       // Button b5 = findViewById(avatar)


        //Buttons calling other activities(which are to be implemented)

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toAllergy();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDeletion();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toDetChange();

            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toSavedRecipe();
            }

        });


        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    public void toAllergy(){
        Intent i =new Intent(this, UserAllergy.class);
        startActivity(i);

    }

    public void toDeletion(){

        Intent j =new Intent(this, UserDeletionRequest.class);
        startActivity(j);

    }

    public void toDetChange(){

        Intent k =new Intent(this, UserDetailsChange.class);
        startActivity(k);

    }

    public void toSavedRecipe(){

        Intent m = new Intent(this, SavedRecipes.class);
        startActivity(m);

    }

}
