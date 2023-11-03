package dk.tec.webapielevapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder
{
    private static final String URL = "http://10.131.199.72:8080/JansWebApi/api/";
    private static Retrofit retrofit =
            new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    public static <S> S buildService(Class<S> serviceType)
    {
        return retrofit.create(serviceType);
    }
}
