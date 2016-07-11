/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ondealmocar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Dragon
 */
public class AppOndeAlmocar {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);       
        GerenciadorDeVotos gerenciador = new GerenciadorDeVotos();    
        ArrayList<Restaurante> listaDeRestaurantes = new ArrayList<Restaurante>();        
        boolean opcao = true;
        
        while(opcao == true){
            
        System.out.print("\nOpcoes de Restaurante:\n");
        
        listaDeRestaurantes = gerenciador.getListaDeRestaurantes();
        for(Restaurante r: listaDeRestaurantes){
            System.out.println("nome: "+r.getNome()+" - codigo: "+r.getIdentificadorRestaurante());
        }
        System.out.println("\nDigite: \nV: votar");
        System.out.println("D: Definir vencedor");
        System.out.println("S: sair");
        
        String escolha = ler.next();
        
        if(escolha.equals("V")){
            
            System.out.println("Digite seu codigo de usuario");
            int codigoUsuario = ler.nextInt();
            System.out.println("Digite o codigo do Restaurante");
            int codigoRestaurante = ler.nextInt();      
            
            String status = gerenciador.votoUsuario(codigoUsuario,new Voto(codigoRestaurante));            
            System.out.println(status);
        }
        else if(escolha.equals("D")){
            Restaurante ganhador = gerenciador.verificarRestauranteVencedor();
            if(ganhador.getQuantidadeDeVotos() == 0){
                System.out.println("nenhum voto foi realizado");
            }
            else{
            System.out.println("Escolhido para hoje:");
            System.out.println("codigo - "+ganhador.getIdentificadorRestaurante());
            System.out.println("nome - "+ganhador.getNome());
            }
        }

        else if(escolha.equals("S")){
        System.out.println("Sistema Encerrado");
        opcao = false;
        }
        else System.out.println("Opcao invalida");       
    }    
}
}
