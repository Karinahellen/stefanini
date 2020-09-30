package valueObjects.usuario;

public class FormCadastrarUsuario {
    public String usuario;
    public String senha;
    public String nome;

    public FormCadastrarUsuario(String usuario, String senha, String nome) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
    }
}
