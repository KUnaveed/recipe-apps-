package bruneluniversity.cookking;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;

public class SavedRecipes extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_recipes);

        getSupportActionBar().setTitle("Saved recipe");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

    }
}
