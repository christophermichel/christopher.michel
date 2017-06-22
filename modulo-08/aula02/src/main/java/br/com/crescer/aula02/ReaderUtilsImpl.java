package br.com.crescer.aula02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author chris
 */
public class ReaderUtilsImpl implements ReaderUtils{
    
    public File file;
    
    @Override
    public String read(String string) throws Exception {
        
        file = new File(string);
        
        if(string.contains(".txt")) {
            
            if(!file.exists()) throw new Exception("Arquivo não encontrado");
            
            Reader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder stringBuilder = new StringBuilder();
            bufferedReader.lines()
                          .forEach(x -> stringBuilder.append(x));
            return stringBuilder.toString();
            
        } else throw new Exception("Arquivo não é um txt.");
    }
}
