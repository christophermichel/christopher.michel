/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author chris
 */
public class WriteUtilsImpl implements WriteUtils{
    
    public File fileAtributo;
    
    @Override
    public void write(String fileParametro, String conteudo) throws Exception {
        fileAtributo = new File(fileParametro);
        
        if(fileParametro.contains(".txt")) {
            
            if(!fileAtributo.exists()) throw new Exception("Arquivo não encontrado");
            
            Writer writer = new FileWriter(fileParametro);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.append(conteudo);
            bufferedWriter.flush();


        } else {
            throw new Exception("Arquivo não é um .txt");
        }
    }
}
