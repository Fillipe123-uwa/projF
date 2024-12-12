package model;

import database.ServicosDAO;

public class Servicos {
    private int test;
    private String nome;
    private String email;
    private String cpf;
    private String senha;
   
    
    public Servicos() {}

    public Servicos(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
    public Servicos(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Servicos(int test, String nome, String email, String cpf) {
        this.test = test;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    
    
    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String nascimento) {
        this.cpf = nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public boolean login() throws ClassNotFoundException, SQLException {
        boolean key = false;
        ServicosDAO dao = new ServicosDAO();
        ArrayList<Usuario> list = dao.getAllUsers();
        
        for(Usuario u : list) {
            if( u.getEmail().equals(this.email) ) {
                if( u.getSenha().equals(this.senha) ) {
                    key = true;
                }
            }
        }
                
        return key;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "test=" + test + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha + '}';
    }
    
        
}
