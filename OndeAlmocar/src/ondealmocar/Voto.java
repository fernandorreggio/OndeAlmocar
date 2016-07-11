package ondealmocar;

import java.time.LocalDate;

public class Voto{

    private int getIdentificadorRestaurante;
    private LocalDate dataAtual;
    
    public Voto(int CodigoRestaurante){
        
        this.getIdentificadorRestaurante = CodigoRestaurante;
        dataAtual = LocalDate.now();
    }
    
    public int getCodigoRestaurante() {
        
        return getIdentificadorRestaurante;
    }

    public int getDiaVoto() {

        return dataAtual.getDayOfMonth();
    }    
}
