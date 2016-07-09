package TestesUnitarios;

import ondealmocar.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dragon
 */
public class UsuarioTeste {
   
    Usuario usuario;
    
    @Before
    public void setUp() {
        
        usuario = new Usuario(10);
    }

    @Test
    public void verfificaSeIdentificadorEstaIncorreto(){
        
        int identificador = usuario.getIdentificador();
        //esperado,real
        assertNotEquals(5,identificador);
    }
    
    @Test
    public void verfificaSeIdentificadorEstaCorreto(){
        
        int identificador = usuario.getIdentificador();
        //esperado,real
        assertEquals(10,identificador);
    }
    
    @Test
    public void verificaCodigoDoRestaruranteVotadoIncorreto(){
        
        usuario.setVotoRestaurante(8);
        int codigoRestaurante = usuario.getVotoRestaurante();
        
        assertNotEquals(6,codigoRestaurante);
    }
 
    @Test
    public void verificaCodigoDoRestaruranteVotadoCorreto(){
        
        usuario.setVotoRestaurante(8);
        int codigoRestaurante = usuario.getVotoRestaurante();
        
        assertEquals(8,codigoRestaurante);
    }
        
    @Test
    public void verificaDiaDaVotacaoIncorreta(){
        
        usuario.setDiaVoto(20);
        int diaVoto = usuario.getDiaVoto();
        
        assertNotEquals(15,diaVoto);
        
    }
    
    @Test
    public void verificaDiaDaVotacaoCorreto(){
        
        usuario.setDiaVoto(20);
        int diaVoto = usuario.getDiaVoto();
        
        assertEquals(20,diaVoto);
        
    }
}
