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
    static ArrayList<Double> IngredientsWeights; //

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


                //START OF GETTING RECIPE NAME

                System.out.println(response.body().getHits().get(0).getRecipe().getLabel());
                String RecipeName = response.body().getHits().get(0).getRecipe().getLabel();
                getRecipeName(RecipeName); // get and set the recipe name

                //END OF GETTING RECIPE NAME


                //START OF GETTING RECIPE INGREDIENTS

                System.out.println(response.body().getHits().get(0).getRecipe().getIngredientLines());
                ArrayList<String> Ingredients = new ArrayList<String>();



                for(int i = 0; i < response.body().getHits().get(0).getRecipe().getIngredients().size(); i++){
                    Ingredients.add(response.body().getHits().get(0).getRecipe().getIngredients().get(i).getText());
                   // System.out.println(i);
                    System.out.println(response.body().getHits().get(0).getRecipe().getIngredients().get(i).getText());
                }

                RegexRecipes(Ingredients); //regular expression the recipes

                // END OF GETTING RECIPE INGREDIENTS


                // Start of setting recipes
                ArrayList<Double> IngredientsWeights = new ArrayList<>();

                for(int i = 0; i < response.body().getHits().get(0).getRecipe().getIngredients().size(); i++){
                    IngredientsWeights.add(response.body().getHits().get(0).getRecipe().getIngredients().get(i).getWeight());
                }







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


    public static void RegexRecipes(ArrayList<String> RecipeIngredientsToRegex ){

        for(int i = 0; i < RecipeIngredientsToRegex.size(); i++){
            String ok = RecipeIngredientsToRegex.get(i);
          //  System.out.println(ok);
        }




        ArrayList<String> RegexList = new ArrayList<>();



        ArrayList<String> RecipeIngredientRegexed = new ArrayList<String>();

        RegexList.add("peeled");
        RegexList.add("and");
        RegexList.add("cut");
        RegexList.add("into");
        RegexList.add("chunks");
        RegexList.add("chopped");
        RegexList.add("cup");
        RegexList.add("thawed");
        RegexList.add("pieces");


        System.out.println("STARTING FROM HERE");
        for(int i = 0; i < RecipeIngredientsToRegex.size(); i++){
             String okay = RecipeIngredientsToRegex.get(i).replaceAll("peeled","");
             okay = okay.replaceAll(",","");
             okay = okay.replaceAll("and","");
             okay = okay.replaceAll("cut","");
             okay = okay.replaceAll("into","");
             okay = okay.replaceAll("chunks","");
             okay = okay.replaceAll("chopped","");
             okay = okay.replaceAll("cup","");
             okay = okay.replaceAll("thawed","");
             okay = okay.replaceAll("/","");
             okay = okay.replaceAll("[0-9]","");
             okay = okay.replaceAll("tablespoons","");
             okay = okay.replaceAll("tablespoon","");
             okay = okay.replaceAll("large","");
             okay = okay.replaceAll("pound","");
             okay = okay.replaceAll("frozen","");
             okay = okay.replaceAll("-","");
             okay = okay.replaceAll("\\p{P}","");

            //okay = okay.substring(0, okay.indexOf("-"));
            okay = okay.split(" or ")[0];

            okay = okay.trim().replaceAll(" +", " ");

            RecipeIngredientRegexed.add(okay);
        }


        System.out.println("okay");

        for(int i = 0; i < RecipeIngredientRegexed.size(); i++){
            System.out.println(RecipeIngredientRegexed.get(i));
        }



       RecipeIngredients = RecipeIngredientRegexed;

    }











}
