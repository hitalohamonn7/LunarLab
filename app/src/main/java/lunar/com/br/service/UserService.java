package lunar.com.br.service;



import lunar.com.br.model.Token;
import lunar.com.br.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hitalo on 06/07/18.
 */

public interface UserService {
    @POST("Logar.php")
    Call<Token> logar(@Body User user);
}
