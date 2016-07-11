package TestesUnitarios;

import java.time.LocalDateTime;
import ondealmocar.Voto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VotoTeste {
   
    private Voto voto;
    
    @Before
    public void setUp() {
        
        voto = new Voto(10);
    }

    @Test
    public void verfificaSeCodigoEstaIncorreto(){
        
        int codigoRestaurante = voto.getCodigoRestaurante();
        
        assertNotEquals(5,codigoRestaurante);
    }
    
    @Test
    public void verfificaSeCodigoEstaCorreto(){
        
        int identificador = voto.getCodigoRestaurante();
        
        assertEquals(10,identificador);
    }
  
    @Test
    public void verificaSeDiaDoVotoFoiFeitoEmDiaDiferente(){
        
        voto = new Voto(25);
        
        int diaVoto = voto.getDiaVoto();
        int diaVotoDiferente = diaVoto + 5;
        
        assertNotEquals(diaVotoDiferente,diaVoto);        
    }
    
    @Test
    public void verificaSeDiaDoVotoFoiFeitoHoje(){
        
        int diaCorrente = LocalDateTime.now().getDayOfMonth();        
        voto = new Voto(25);
        
        int diaVoto = voto.getDiaVoto();
        
        assertEquals(diaCorrente,diaVoto);
        
    }
}
