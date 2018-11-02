package lunar.com.br.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by hitalo on 05/07/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExameFile implements Serializable{
    private int idExameFile;
    private String link;
    private int pacienteIdPaciente;
    private String data;
    private String nome;

    public ExameFile() {

    }

    public ExameFile(String link, String data, String nome) {
        this.link = link;
        this.data = data;
        this.nome = nome;
    }

    public int getIdExameFile() {
        return idExameFile;
    }

    public void setIdExameFile(int idExameFile) {
        this.idExameFile = idExameFile;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPacienteIdPaciente() {
        return pacienteIdPaciente;
    }

    public void setPacienteIdPaciente(int pacienteIdPaciente) {
        this.pacienteIdPaciente = pacienteIdPaciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
