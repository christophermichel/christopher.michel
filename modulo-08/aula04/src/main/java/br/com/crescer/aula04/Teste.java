/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04;

import java.util.List;

/**
 *
 * @author chris
 */
public class Teste {
    
    public static void main(String[] args) {
        
        //FuncionarioDao fDao = new FuncionarioDao();
        //Funcionario f = new Funcionario();
        //f.setNome("Chris");
        //f.setRg("902480928");
        //fDao.save(f);
        
        
        //Funcionario f = fDao.loadById(23L);
        //System.out.println(f.getNome());
        //fDao.remove(f);
        
        FuncionarioDao fDao = new FuncionarioDao();
        List<Funcionario> lista = fDao.findAll();

        lista.forEach((funcionario) -> {
            System.out.println(funcionario.getNome());
        });
        
        
    }
}