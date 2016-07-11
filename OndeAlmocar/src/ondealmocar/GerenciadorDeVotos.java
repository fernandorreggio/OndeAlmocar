package ondealmocar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class GerenciadorDeVotos {

    private ArrayList<Restaurante> restaurantes;
    private ArrayList<Restaurante> restaurantesNaoEscolhidos;
    private HashMap<Integer,Voto> listaDeVotos;
    private String diaDaSemana;
    
    public GerenciadorDeVotos() {                 
        
        restaurantes = new ArrayList<Restaurante>(3);
        restaurantesNaoEscolhidos = new ArrayList<Restaurante>(3);
        listaDeVotos = new HashMap<Integer,Voto>();
        diaDaSemana = "";
        
        restaurantes.add(new Restaurante(1,"RU"));
        restaurantes.add(new Restaurante(2,"Palatus"));
        restaurantes.add(new Restaurante(3,"Panorama"));
        
        restaurantesNaoEscolhidos = restaurantes;        
    }

    public ArrayList getListaDeRestaurantes() {
        
        diaDaSemana = LocalDate.now().getDayOfWeek().name();        
        if(diaDaSemana.equals("MONDAY"))restaurantesNaoEscolhidos = restaurantes;
        
        return restaurantesNaoEscolhidos;       
    }

    public String votoUsuario(int idUsuario,Voto voto){
        
        if(listaDeVotos.containsKey(idUsuario)){
            int dataRegistrada = listaDeVotos.get(idUsuario).getDiaVoto();
            
            if(dataRegistrada == voto.getDiaVoto()) return "Usuario ja votou hoje";
        }
        
        if(verificaRestauranteCadastrado(voto.getCodigoRestaurante()) == -1){
            return "Restaurante nao cadastrado ou indisponivel";
        }        
        
        listaDeVotos.put(idUsuario, voto);
        somaQuantidadeDeVotos(voto.getCodigoRestaurante(),voto);
        return "Voto concluido";
    }
    
    public Restaurante verificarRestauranteVencedor(){
        
        Restaurante vencedor = restaurantes.get(0);
        
        for(Restaurante r: restaurantes){
            if(r.getQuantidadeDeVotos() > vencedor.getQuantidadeDeVotos())vencedor = r;            
        }      
        if(vencedor.getQuantidadeDeVotos() > 0){
        restaurantesNaoEscolhidos.remove(vencedor);
        }
        return vencedor;
        }        
              
    private int verificaRestauranteCadastrado(int identificadorRestaurante){
        for(Restaurante r: restaurantesNaoEscolhidos){
            if(r.getIdentificadorRestaurante() == identificadorRestaurante) return r.getIdentificadorRestaurante();
        }
        return -1;
    }
    
    private void somaQuantidadeDeVotos(int codigoRestaurante,Voto voto){
    
            for(Restaurante r: restaurantesNaoEscolhidos){
                if(r.getIdentificadorRestaurante() == codigoRestaurante){
                    r.somaQuantidadeVotos(voto.getDiaVoto());
                }
            }
    }
    
}
