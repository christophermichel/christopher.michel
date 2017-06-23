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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
    
    public String executeQuery(String query) {
    
        return "oi";
    }
    
    public void importCSV(File file) {
    
        return;
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
