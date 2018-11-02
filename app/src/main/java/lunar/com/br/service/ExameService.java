package lunar.com.br.service;

import java.util.ArrayList;
import java.util.List;

import lunar.com.br.model.ExameFile;

/**
 * Created by hitalo on 05/07/18.
 */

public class ExameService {
    public static List<ExameFile> getExames(){
        List<ExameFile> exames = new ArrayList<ExameFile>();

        exames.add(new ExameFile("link","28/08/1220","nome"));
        exames.add(new ExameFile("link","28/08/1220","nome"));
        exames.add(new ExameFile("link","28/08/1220","nome"));
        exames.add(new ExameFile("link","28/08/1220","nome"));
        return exames;
    }
}
