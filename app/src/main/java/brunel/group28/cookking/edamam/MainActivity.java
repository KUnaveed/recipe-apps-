package brunel.group28.cookking.edamam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import brunel.group28.cookking.R;
import brunel.group28.cookking.edamam.Controller.RetrofitClient;
import brunel.group28.cookking.edamam.Model.HitResponse;
import brunel.group28.cookking.edamam.Model.RecipeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetRecipes();

    }


    public static void GetRecipes(){
        RecipeService rsService = RetrofitClient.getClient("https://api.edamam.com/").create(RecipeService.class);



        Call<HitResponse> call = rsService.getRecipe("chicken", "8e4c9873", "cd8084d6a52f587fbd42a5c1be8ce487", 0, 3);
        call.enqueue(new Callback<HitResponse>() {
            @Override
            public void onResponse(Call<HitResponse> call, Response<HitResponse> response) {
                int statusCode = response.code();
                System.out.println("Status code is" + statusCode);
                //System.out.println(response.body().getHits().get(0).getRecipe().size());
                System.out.println(response.body().getHits().get(0).getRecipe().getLabel());
                System.out.println(response.body().getHits().get(0).getRecipe().getIngredientLines());
                System.out.println(response.body().getHits());
                // while(recipe.hasNext)

                //System.out.println("this is the recipe "+recipe.toString());
            }


            @Override
            public void onFailure(Call<HitResponse> call, Throwable t) {
                // Log error here since request failed
            }
        });
        //System.out.println("ray");



    }











}
