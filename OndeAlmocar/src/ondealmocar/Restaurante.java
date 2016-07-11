package ondealmocar;

public class Restaurante {
    
    private int identificadorRestaurante;
    private String nome;
    private int quantidadeDeVotos;
    private int diaUltimoVoto;

    public Restaurante(int identificadorRestaurante,String nome) {
        this.identificadorRestaurante = identificadorRestaurante;
        this.nome = nome;
        quantidadeDeVotos = 0;
        diaUltimoVoto = 0;
    }
    
    public int getIdentificadorRestaurante() {
        
        return identificadorRestaurante;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeDeVotos() {
        return quantidadeDeVotos;
    }      
    
    public void somaQuantidadeVotos(int diaVoto){
        
        if(diaUltimoVoto != diaVoto)zeraQuantidadeDeVotos();
      
        quantidadeDeVotos ++;
        diaUltimoVoto = diaVoto;
    }
    
    public void zeraQuantidadeDeVotos(){
        
        quantidadeDeVotos = 0;
    }    
}
