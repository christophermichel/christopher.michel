package br.com.crescer.aula03;

import java.io.File;

/**
 * @author carloshenrique
 */
public interface SQLUtils {

    void runFile(String filename);

    String executeQuery(String query);
    
    void importCSV(File file);
    
    File importCSV(String query);

}