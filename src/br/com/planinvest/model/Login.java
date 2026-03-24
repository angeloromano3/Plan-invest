package br.com.planinvest.model;

// Login herda os atributos e métodos de Usuario
public class Login extends Usuario {

    // Atributos específicos do login
    private String usuario;
    private String senha;

    // Construtor da classe Login, chama o construtor da superclasse Usuario
    public Login(int idUsuario, String nome, String email, String usuario, String senha) {
        super(idUsuario, nome, email);
        this.usuario = usuario;
        this.senha = senha;
    }

    // Métodos do login
    public void realizarLogin() {
        System.out.println("Fazendo o login do usuário");
    }

    public void validarUsuario() {
        System.out.println("Validando usuário e senha");
    }

    // Getters e Setters para acessar e modificar os atributos
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}