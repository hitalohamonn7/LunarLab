package lunar.com.br.applacad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.URI;
import java.net.URISyntaxException;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class LunarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        //
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Lunar Software Innovation é uma startup de desenvolvimento mobile e web que implementa soluções inovadoras!")
                .setImage(R.drawable.logolunar)


                .addGroup("Entre Em Contato")
                .addEmail("lunarsoftinovation@gmail.com")
                .addWebsite("http://lunarsi.com/")
                .addFacebook("LunarSoftwareInnovation")
                .addInstagram("lunarsoftwarecs")
                .create();

        setContentView(aboutPage);
    }
}
