package TestesUnitarios;

import ondealmocar.Restaurante;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestauranteTeste {
    
    private Restaurante restaurante;
    
    @Before
    public void setUp() {
        restaurante = new Restaurante(10,"RestauranteA");       
    }
    
    @Test
    public void verificaIdentificadorDoRestauranteIncorreto(){
        
        int identificadorRestaurante = restaurante.getIdentificadorRestaurante();
        
        assertNotEquals(5,identificadorRestaurante);
    }

    @Test
    public void verificaIdentificadorDoRestauranteCorreto(){
        
        int identificadorRestaurante = restaurante.getIdentificadorRestaurante();
        
        assertEquals(10,identificadorRestaurante);
    }
    
    @Test
    public void verificaNomeRestauranteIncorreto(){
        
        String nomeRestaurante = restaurante.getNome();
        
        assertNotEquals("RestauranteB", nomeRestaurante);
    }
    
    @Test
    public void verificaNomeRestauranteCorreto(){
        
        String nomeRestaurante = restaurante.getNome();
        
        assertEquals("RestauranteA", nomeRestaurante);
    }
    
    @Test
    public void verificaQuantidadeDeVotosNoMesmoDiaErrada(){
        
        restaurante.somaQuantidadeVotos(10);
        restaurante.somaQuantidadeVotos(10);
        int somaDeVotos = restaurante.getQuantidadeDeVotos();
        int somaDeVotosErrada = 3; 
        
        assertNotEquals(somaDeVotosErrada,somaDeVotos);
    }
    
    @Test
    public void verificaQuantidadeDeVotosNoMesmoDiaCerta(){
        
        restaurante.somaQuantidadeVotos(10);
        restaurante.somaQuantidadeVotos(10);
        int somaDeVotos = restaurante.getQuantidadeDeVotos();
        int somaDeVotosCerta = 2; 
        
        assertEquals(somaDeVotosCerta,somaDeVotos);
    }    
    
    @Test
    public void verificaQuantidadeDeVotosErraEmDiasDiferentesZerandoOContador(){
        
        restaurante.somaQuantidadeVotos(10);
        restaurante.somaQuantidadeVotos(10);
        restaurante.somaQuantidadeVotos(15);
        int somaDeVotos = restaurante.getQuantidadeDeVotos();
        int somaDeVotosErrada = 3; 
        
        assertNotEquals(somaDeVotosErrada,somaDeVotos);
    }    
    
    @Test
    public void verificaQuantidadeDeVotosEmDiasDiferentesZerandoOContador(){
        
        restaurante.somaQuantidadeVotos(10);
        restaurante.somaQuantidadeVotos(10);
        restaurante.somaQuantidadeVotos(15);
        int somaDeVotos = restaurante.getQuantidadeDeVotos();
        int somaDeVotosCerta = 1; 
        
        assertEquals(somaDeVotosCerta,somaDeVotos);
    }
    
    @Test
    public void verificaSeContadorFoiZeradoIncorretamente(){
        
        restaurante.somaQuantidadeVotos(10);
        restaurante.somaQuantidadeVotos(10);
        restaurante.zeraQuantidadeDeVotos();
        
        int somaDeVotos = restaurante.getQuantidadeDeVotos();
        int somaDeVotosErrada = 2;
        
        assertNotEquals(somaDeVotosErrada,somaDeVotos);
    }
    
    @Test
    public void verificaSeContadorFoiZeradoCorretamente(){
        
        restaurante.somaQuantidadeVotos(10);
        restaurante.somaQuantidadeVotos(10);
        restaurante.zeraQuantidadeDeVotos();
        
        int somaDeVotos = restaurante.getQuantidadeDeVotos();
        int somaDeVotosCerta = 0;
        
        assertEquals(somaDeVotosCerta,somaDeVotos);
    }
    
}
