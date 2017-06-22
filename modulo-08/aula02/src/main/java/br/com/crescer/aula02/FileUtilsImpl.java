package br.com.crescer.aula02;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author chris
 */
public class FileUtilsImpl implements FileUtils{
    
    public File file;
    
    @Override
    public boolean mk(String string) {
        try {
            file = new File(string);
            if(file.isFile()){
                return file.createNewFile();
            } else
                return file.mkdir();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean rm(String string) {
        file = new File(string);
        if (file.isFile()) {
            return file.delete();
        }
        else {
            System.out.println("Arquivo é inválido");
            return false;
        }
    }
    
    @Override
    public String ls(String string) {
        file = new File(string);
        if (file.isFile()) {
            return file.getAbsolutePath();
        } else {
            String[] arquivos = new File(string).list();
            String stringFinal = String.join(",", arquivos);
            return stringFinal;
        }
    }
    
    @Override
    public boolean mv(String in, String out) {
        
        File entrada = new File(in);
        File saida = new File(out);
        
        if(entrada.isFile() || saida.isFile()) {
            return entrada.renameTo(saida);
        } else {
            System.out.println("Arquivo é inválido");
            return false;
        }
    }
    
}
