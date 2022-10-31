package dao;

import modelo.Produto;

import java.sql.*;


public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }

    private void salva(Produto produto){
        try {
            try (PreparedStatement pstm = connection.prepareStatement("INSERT INTO PRODUTO(nome, descricao, quantidade, preco)VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, produto.getNome());
                pstm.setString(2, produto.getDescricao());
                pstm.setInt(3, produto.getQuantidade());
                pstm.setDouble(4, produto.getPreco());
                pstm.execute();
                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        produto.setId(rst.getInt(1));
                    }
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e + " Problema na conexão!");
        }
    }

    public void salvaTresProdutos(Produto produto, Produto produto2, Produto produto3){
        int totalRegistros = 0;
        try {
            try (PreparedStatement pstm = connection.prepareStatement("SELECT ID, nome FROM PRODUTO")) {
                pstm.execute();                              // Busca para verificar a quantidade de registros na tabela.
                try (ResultSet rst2 = pstm.getResultSet()) {
                    while (rst2.next()) {
                        totalRegistros++;
                    }
                }
            }
            if (totalRegistros == 0) { // ou seja, se não houver registros na tabela, os produtos passados por argumentos serão armazenados.
                this.salva(produto);
                this.salva(produto2);
                this.salva(produto3);
                System.out.println("Produtos cadastrados com sucesso!");
            } else {
                System.out.println("OPÇÃO INCORRETA! PRODUTOS JÁ CADASTRADOS");
            }
        }catch(SQLException e){
            throw new RuntimeException(e+" Problema na conexão!");
        }
    }

    public void deleta(Produto produto){
        try {
            try (PreparedStatement pstm = connection.prepareStatement("SELECT ID FROM PRODUTO")) {
                pstm.execute();
                int idForRemove = 0;
                int totalRegistros = 0;
                try (ResultSet rst = pstm.getResultSet()) {
                    while (rst.next()) {
                        totalRegistros++;
                        if (rst.getRow() == 2) {
                            idForRemove = rst.getInt(1); // captura o id do segundo registro de produto
                        }
                    }
                }
                if (totalRegistros == 3) { // Só executa a query de deleção caso hajam 3 registros, evitando excluir duas vezes o produto.
                    try (PreparedStatement pstm2 = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
                        pstm2.setInt(1, idForRemove);
                        pstm2.execute();
                        System.out.println("Modelo.Produto apagado com sucesso!");
                    }
                } else {
                    System.out.println("OPÇÃO INCORRETA! O PRODUTO FOI DELETADO ANTERIORMENTE OU NÃO FOI INSERIDO");
                }
            }
        } catch(SQLException e){
            throw new RuntimeException(e + " problema na conexão!");
        }
    }

    public void altera(String descricao, double preco){
        int idForUpdate =0;
        int totalRegistros = 0;
        try {
            try (PreparedStatement pstm = connection.prepareStatement("SELECT ID FROM PRODUTO")) {
                pstm.execute();
                try (ResultSet rst = pstm.getResultSet()) {
                    while (rst.next()) {
                        totalRegistros++;
                    }
                    if(totalRegistros >=1){ // Se houver registros, é efetuada a alteração!
                        rst.absolute(1);
                        idForUpdate = rst.getInt(1);
                        try(PreparedStatement pstm2 = connection.prepareStatement("UPDATE PRODUTO SET descricao = ?, preco = ? WHERE ID = ?")){
                            pstm2.setString(1, descricao);
                            pstm2.setDouble(2, preco);
                            pstm2.setInt(3, idForUpdate);
                            pstm2.execute();
                            System.out.println("Modelo.Produto alterado");
                        }
                    }
                    else{
                        System.out.println("Não há registros para serem alterados!");
                    }
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e+" problema na conexão!");
        }
    }

    public void deletaTodosCampos() {
        try {
            try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTO")) {
                pstm.execute();
            }
        }catch (SQLException e){
            throw new RuntimeException(e + "problema na conexão!");
        }
    }
}
