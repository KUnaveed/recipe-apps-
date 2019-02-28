package brunel.group28.cookking.edamam.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeService {

    String app_id= "&app_id=8e4c9873";
    String app_key = "&app_key=cd8084d6a52f587fbd42a5c1be8ce487";


    @GET("search?")
    Call<HitResponse> getRecipe(@Query("q") String q, @Query("app_id") String app_id, @Query("app_key") String app_key, @Query("from") int from, @Query("to") int to);


}
