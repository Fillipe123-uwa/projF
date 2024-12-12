package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Servicos;

public class ServicosDAO {

    private static Connection conn;

    public ServicosDAO() throws ClassNotFoundException, SQLException {
        conn = Conexao.getConn();
    }

    public ArrayList<Servicos> getAllUsers() throws SQLException {

        ArrayList<Servicos> list = new ArrayList();

        String query = "select * from servicos;";

        PreparedStatement prep = conn.prepareStatement(query);

        ResultSet res = prep.executeQuery();

        while (res.next()) {
            Servicos user = new Servicos();

            user.setTest(res.getInt("test"));
            user.setNome(res.getString("nome"));
            user.setEmail(res.getString("email"));
            user.setCpf(res.getString("cpf"));
            user.setSenha(res.getString("senha"));

            list.add(user);
            System.out.println(user);
        }

        prep.close();
        return list;
    }

    public void setNewUser(Servicos user) throws SQLException {
        String query = "insert into usuarios(nome, email, cpf, senha) "
                + "values(?, ?, ?, sha1(?))";

        PreparedStatement prep = conn.prepareStatement(query);

        prep.setString(1, user.getNome());
        prep.setString(2, user.getEmail());
        prep.setString(3, user.getCpf());
        prep.setString(4, user.getSenha());

        prep.execute();
        prep.close();
    }

    public void deleteUser(int test) throws SQLException {
        String query = "delete from servicos "
                + "where test = " + test;

        PreparedStatement prep = conn.prepareStatement(query);

        prep.execute();
        prep.close();
    }

    public Servicos getOneUser(int id) throws SQLException {
        String query = "select * from usuarios where test = " + test;

        PreparedStatement prep = conn.prepareStatement(query);

        ResultSet res = prep.executeQuery();

        Servicos u = new Servicos();

        if (res.next()) {
            u.setTest("test");
            u.setNome(res.getString("nome"));
            u.setEmail(res.getString("email"));
            u.setCpf(res.getString("cpf"));
            u.setSenha(res.getString("senha"));

        }

        prep.close();
        return u;
    }

    public Servicos getOneUserByEmail(String email) throws SQLException {
        String query = "select * from usuarios where email = ?";

        PreparedStatement prep = conn.prepareStatement(query);

        prep.setString(1, email);

        ResultSet res = prep.executeQuery();

        Servicos u = new Servicos();

        if (res.next()) {
            u.setTest(res.getInt("test"));
            u.setNome(res.getString("nome"));
            u.setEmail(res.getString("email"));
            u.setCpf(res.getString("cpf"));
            u.setSenha(res.getString("senha"));

        }

        prep.close();
        return u;
    }

    public void updateUser(Servicos user) throws SQLException {
        String query = "update usuarios set nome = ?, "
                + "email = ?, cpf = ? "
                + "where test = ?";

        PreparedStatement prep = conn.prepareStatement(query);

        prep.setString(1, user.getNome());
        prep.setString(2, user.getEmail());
        prep.setString(3, user.getCpf());
        prep.setInt(4, user.getTest());

        prep.execute();
        prep.close();
    }
}
