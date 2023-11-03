package dk.tec.webapielevapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ElevService
{
    @GET("Elev/{id}")
    Call<Elev> getElevById(@Path("id") int id);
}
