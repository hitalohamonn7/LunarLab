package lunar.com.br.model;

/**
 * Created by hitalo on 06/07/18.
 */

public class User {
    private String cpf;
    private String senha;

    public User(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public User() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
