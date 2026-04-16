package br.com.planinvest.model;

// Classe que representa o usuário do sistema Plan+Invest
public class Usuario {

    // Atributos do usuário
    private int idUsuario;
    private String nome;
    private String email;

    // Construtor da classe Usuario
    public Usuario(int idUsuario, String nome, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
    }

    // Métodos do usuário
    public void cadastrarUsuario() {
        System.out.println("Executando método cadastrar usuário");
    }

    public void consultarUsuario() {
        System.out.println("Consultando dados do usuário " + nome);
    }

    // Getters e Setters para acessar e modificar os atributos
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

