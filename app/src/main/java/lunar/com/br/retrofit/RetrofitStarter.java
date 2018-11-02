package lunar.com.br.retrofit;

import lunar.com.br.service.ExameFileService;
import lunar.com.br.service.UserService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by hitalo on 06/07/18.
 */

public class RetrofitStarter {
    private final Retrofit retrofit;
    public RetrofitStarter() {
        HttpLoggingInterceptor interceptor =  new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);
        retrofit = new Retrofit.Builder().baseUrl("http://apilacamm.lunarsoftware.com.br/").addConverterFactory(JacksonConverterFactory.create()).client(client.build()).build();
    }

    public UserService getUserService(){
        return retrofit.create(UserService.class);
    }

    public ExameFileService getExameService(){
        return retrofit.create(ExameFileService.class);
    }
}
