package brunel.group28.cookking.edamam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

import brunel.group28.cookking.R;
import brunel.group28.cookking.edamam.Controller.RetrofitClient;
import brunel.group28.cookking.edamam.Model.HitResponse;
import brunel.group28.cookking.edamam.Model.RecipeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    static String RecipeName; // recipe name
    static ArrayList<String> RecipeIngredients; // RecipeIngredients with getting rid of unuseful words or phrases.

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
                String RecipeName = response.body().getHits().get(0).getRecipe().getLabel();
                getRecipeName(RecipeName);

                System.out.println(response.body().getHits().get(0).getRecipe().getIngredientLines());
                ArrayList<String> Ingredients = new ArrayList<String>();


                for(int i = 0; i < response.body().getHits().get(0).getRecipe().getIngredients().size(); i++){
                    Ingredients.add(response.body().getHits().get(0).getRecipe().getIngredients().get(i).getText());
                    System.out.println(response.body().getHits().get(0).getRecipe().getIngredients().get(i).getText());
                }

                RegexRecipes(Ingredients);



               // System.out.println(response.body().getHits());
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

    public static void getRecipeName(String Recipename){

       RecipeName = Recipename;

    }


    public static void RegexRecipes(ArrayList<String> RecipeIngredientsRegex ){

        ArrayList<String> RegexList = new ArrayList<String>();

       // .replaceAll(  "0-9,"");
        // replaceAll("\\p{P}","");
        // above removes punctuation marks that include all brackets, braces and sq. brackets

        RegexList.add("peeled");
        RegexList.add("and");
        RegexList.add("cut");
        RegexList.add("into");
        RegexList.add("chunks");
        RegexList.add("chopped");
        RegexList.add("cup");
        RegexList.add("thawed");
        RegexList.add("pieces");

        for(int i = 0; i < RecipeIngredientsRegex.size(); i++) {
            RecipeIngredientsRegex.get(i).replaceAll("0-9", "");
            RecipeIngredientsRegex.get(i).replaceAll("\\p{P}", "");


        }
            for (int j = 0; j < RecipeIngredientsRegex.size(); j++) {
                for(int k = 0; k < RegexList.size(); k++) {
                    RecipeIngredientsRegex.get(j).replaceAll(RegexList.get(k),"");
                }
            }

            System.out.println("testing from here");

            for(int i = 0; i < RecipeIngredientsRegex.size(); i++){
                System.out.println(RecipeIngredientsRegex.get(i));
            }

       RecipeIngredients = RecipeIngredientsRegex;

    }











}
