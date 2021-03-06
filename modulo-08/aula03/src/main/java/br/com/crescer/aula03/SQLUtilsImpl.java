package br.com.crescer.aula03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author chris
 */
public class SQLUtilsImpl implements SQLUtils {
    
    File file;
    
    @Override
    public void runFile(String filename) {
        try {
            file = new File(filename);

            if (!file.exists()) {
                throw new Exception("Não foi possível encontrar o arquivo");
            }
            if (filename.contains(".sql") || file.isFile()) {
                
                Reader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                ArrayList<String> arrayLinhas = new ArrayList<>();

                bufferedReader
                    .lines()
                    .forEach(x -> arrayLinhas.add(x));
            
                try (final Connection connection = ConnectionUtils.getConnection()) {
                    PreparedStatement preparedStatement;
                    
                    for(int i = 0; i < arrayLinhas.size(); i++){
                        preparedStatement = connection.prepareStatement(arrayLinhas.get(i));
                        preparedStatement.executeUpdate();
                        connection.isClosed();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                throw new Exception("Não é um arquivo .sql");
            }
        } catch (Exception e) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public String executeQuery(String query) {
        StringBuilder tabela = new StringBuilder();
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()) { 
            
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData coluna = resultSet.getMetaData();

            while(resultSet.next()){                
                for(int i = 0; i < coluna.getColumnCount(); i++) {
                    tabela.append(resultSet.getString(i+1)).append(" "); 
                }
                tabela.append("\n");                
            } 
            
        } catch (SQLException e) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return tabela.toString();
    }
    
    @Override
    public void importCSV(File file) {
        String nome = file.getName();
        if(nome.contains(".csv") || file.isFile()) {
            String nomeTabela = nome.substring(0, nome.lastIndexOf("."));
            try {
                if(!file.exists()) {
                throw new Exception("Não foi possível encontrar o arquivo");
                }
                Reader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                List<String> dadosLinha = bufferedReader
                                                .lines()
                                                .collect(toList());
                String comandoSQL = String.format("insert into %s (%s) values (?)", nomeTabela, dadosLinha.get(0));
                try (final Statement statement = ConnectionUtils.getConnection().createStatement()) {
                    for(int i = 1; i < dadosLinha.size(); i++) {
                        statement.addBatch(comandoSQL.replace("?", dadosLinha.get(i)));
                    }
                    statement.executeBatch();
                } catch (Exception e) {
                    throw new Exception("Não foi possível concluir com êxito as operações");
                }
            } catch (Exception e) {
                    throw new RuntimeException("Erro: " + e.getMessage());
            }
        }
    }

    
    @Override
    public File importCSV(String query) {
        file = new File("file.csv");
        String comandoSQL = executeQuery(query);
        try {
            file.createNewFile();
            if(file.exists()){
                Writer writer = new FileWriter(file);
                writer.append(comandoSQL);
                writer.flush(); 
            }
        } catch (Exception e) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return file;
    }
}
