package lunar.com.br.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitalo on 07/07/18.
 */

public class Exames {
    private ArrayList<ExameFile> exames;


    public Exames(){

    }

    public List<ExameFile> getExames() {
        return exames;
    }

    public void setExames(ArrayList<ExameFile> exames) {
        this.exames = exames;
    }
}
