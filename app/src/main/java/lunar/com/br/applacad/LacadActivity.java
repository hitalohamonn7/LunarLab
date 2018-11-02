package lunar.com.br.applacad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class LacadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        //
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Av. Francisco Ademar de Andrade nº 756 - Centro - Campos Sales\n" +
                        "Av. São Pedro nº 264 - Centro - Salitre")
                .setImage(R.drawable.logolacad)


                .addGroup("Entre Em Contato")
                .addEmail("lacadcs@hotmail.com")
                .addWebsite("http://www.lacad.com.br/")
                .addInstagram("lacadcs")
                .create();

        setContentView(aboutPage);
    }
}
