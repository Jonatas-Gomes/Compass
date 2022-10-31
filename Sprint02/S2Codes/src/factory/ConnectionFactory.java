package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public DataSource dataSource;

    public ConnectionFactory(){

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/avaliacao_sprint2?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("99168844Jo#");
        comboPooledDataSource.setMaxPoolSize(3);
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperaConexao(){
        try {
            return this.dataSource.getConnection();
        }catch(SQLException e){
            throw new RuntimeException(e + "Problema na conexão");
        }
    }
}
