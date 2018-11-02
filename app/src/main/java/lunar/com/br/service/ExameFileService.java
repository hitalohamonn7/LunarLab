package lunar.com.br.service;

import java.util.List;

import lunar.com.br.model.ExameFile;
import lunar.com.br.model.Exames;
import lunar.com.br.model.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hitalo on 06/07/18.
 */

public interface ExameFileService {
    @POST("getExames.php")
    Call<Exames> getExames(@Body Token token);
}
