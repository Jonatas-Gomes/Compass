package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmeDAO {
    private Connection connection;

    public FilmeDAO(Connection connection){
        this.connection = connection;
    }

    public void listaPaginada(int pagina, int numerosDeFilmes){
        try {
            try (PreparedStatement pstm = connection.prepareStatement("SELECT ID, nome, descricao, ano FROM FILME LIMIT ?,?")) {
                int inicio;
                if(numerosDeFilmes > 10){
                    numerosDeFilmes = 10; // cada pagina contem 10 filmes.
                }
                if(pagina == 1){ // pagina 1 compreende os primeiros 10 registros
                    inicio = 0;
                }else{
                    inicio = 10; // pagina 2 compreende os registros acima de 10.
                }
                pstm.setInt(1,inicio);
                pstm.setInt(2,numerosDeFilmes);
                pstm.execute();
             try(ResultSet rst = pstm.getResultSet()){
                 while(rst.next()) {
                     System.out.print(" | " + rst.getInt(1));
                     System.out.print(" | " + rst.getString(2));
                     System.out.print(" | " + rst.getString(3));
                     System.out.println(" | " + rst.getInt(4));
                 }
             }
            }
        }catch(SQLException e){
            throw new RuntimeException(e+" problema na conexão!");
        }
    }
}

