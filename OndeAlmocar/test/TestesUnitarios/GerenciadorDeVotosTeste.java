package TestesUnitarios;

import ondealmocar.GerenciadorDeVotos;
import ondealmocar.Restaurante;
import ondealmocar.Voto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GerenciadorDeVotosTeste {
    
    public GerenciadorDeVotosTeste() {
    }
    GerenciadorDeVotos gerenciador;
    
    @Before
    public void setUp() {
        
        gerenciador = new GerenciadorDeVotos();        
    }
    
    @Test
    public void verificaSeNaoContemOpcoesDeRestaurante(){
        
        int quantidadeDeOpcoes = gerenciador.getListaDeRestaurantes().size();
        
        assertNotEquals(0,quantidadeDeOpcoes);
    }
    
    @Test
    public void verificaSeContemOpcoesDeRestaurante(){
        
        int quantidadeDeOpcoes = gerenciador.getListaDeRestaurantes().size();
        
        assertEquals(3,quantidadeDeOpcoes);
    }
    
    @Test
    public void verificaVotoValidoComRetornoDeMensagemErrada(){
        
        Voto voto = new Voto(3);
        String statusVoto = gerenciador.votoUsuario(10,voto);
        
        assertNotEquals("Mensagem Errada",statusVoto);
    }
    
    @Test
    public void verificaVotoValidoComRetornoDeMensagemCerta(){
        
        Voto voto = new Voto(3);
        String statusVoto = gerenciador.votoUsuario(10,voto);
        
        assertEquals("Voto concluido",statusVoto);
    }
    
    @Test
    public void VotoDoMesmoUsuarioNoMesmoDiaSemConclusaoComRetornoDeMensagemErrada(){
        
        Voto voto = new Voto(3);
        gerenciador.votoUsuario(10,voto);
        String statusVoto = gerenciador.votoUsuario(10,voto);        
        
        assertNotEquals("Voto concluido",statusVoto);
    }

    @Test
    public void VotoDoMesmoUsuarioNoMesmoDiaSemConclusaoComRetornandoMesagemCorreta(){
        
        Voto voto = new Voto(3);
        gerenciador.votoUsuario(10,voto);
        String statusVoto = gerenciador.votoUsuario(10,voto);        
        
        assertEquals("Usuario ja votou hoje",statusVoto);
    }
    
    @Test
    public void VotoEmRestauranteNaoCadastradoRetornandoMensagemErrada(){
        
        Voto voto = new Voto(4);
        gerenciador.votoUsuario(10,voto);
        String statusVoto = gerenciador.votoUsuario(10,voto);        
        
        assertNotEquals("Voto Concluido",statusVoto);
    }
    
    @Test
    public void VotoEmRestauranteNaoCadastradoRetornandoMensagemCerta(){
        
        Voto voto = new Voto(4);
        gerenciador.votoUsuario(10,voto);
        String statusVoto = gerenciador.votoUsuario(10,voto);        
        
        assertEquals("Restaurante nao cadastrado ou indisponivel",statusVoto);
    }
    
    @Test
    public void VotoEmRestauranteJaEscolhidoRetornandoMensagemErrada(){
        
        Voto votoUm = new Voto(2);
        gerenciador.votoUsuario(10,votoUm);
        Voto votoDois = new Voto(2);
        gerenciador.votoUsuario(20,votoDois);
        Voto votoTres = new Voto(3);
        gerenciador.votoUsuario(30,votoTres);
        
        gerenciador.verificarRestauranteVencedor();
        
        Voto votoQuatro = new Voto(2);
        String statusVoto = gerenciador.votoUsuario(40,votoQuatro); 
        
        assertNotEquals("Voto concluido",statusVoto);
    }
    
    @Test
    public void VotoEmRestauranteJaEscolhidoRetornandoMensagemCerta(){
        
        Voto votoUm = new Voto(2);
        gerenciador.votoUsuario(10,votoUm);
        Voto votoDois = new Voto(2);
        gerenciador.votoUsuario(20,votoDois);
        Voto votoTres = new Voto(3);
        gerenciador.votoUsuario(30,votoTres);
        
        gerenciador.verificarRestauranteVencedor();
        
        Voto votoQuatro = new Voto(2);
        String statusVoto = gerenciador.votoUsuario(40,votoQuatro); 
        
        assertEquals("Restaurante nao cadastrado ou indisponivel",statusVoto);
    }
    
    @Test
    public void verificaVencedorDoDiaErradoERetornandoONomeCerto(){
        Voto votoUm = new Voto(1);
        gerenciador.votoUsuario(10,votoUm);
        Voto votoDois = new Voto(2);
        gerenciador.votoUsuario(20, votoDois);
        Voto votoTres = new Voto(1);
        gerenciador.votoUsuario(30, votoTres);      
        
        Restaurante vencedorDoDia = (gerenciador.verificarRestauranteVencedor());
        
        assertNotEquals("Palatus",vencedorDoDia.getNome());
    }
    
    @Test
    public void verificaVencedorCertoDoDiaERetornandoONomeCerto(){
        Voto votoUm = new Voto(1);
        gerenciador.votoUsuario(10,votoUm);
        Voto votoDois = new Voto(2);
        gerenciador.votoUsuario(20, votoDois);
        Voto votoTres = new Voto(1);
        gerenciador.votoUsuario(30, votoTres);      
        
        Restaurante vencedorDoDia = (gerenciador.verificarRestauranteVencedor());
        
        assertEquals("RU",vencedorDoDia.getNome());
    }
    
    @Test
    public void verificaVencedorCertoDoDiaERetornandoONomeCertoVersaoDois(){
        Voto votoUm = new Voto(1);
        gerenciador.votoUsuario(10,votoUm);
        Voto votoDois = new Voto(2);
        gerenciador.votoUsuario(20, votoDois);
        Voto votoTres = new Voto(2);
        gerenciador.votoUsuario(30, votoTres);      
        
        Restaurante vencedorDoDia = (gerenciador.verificarRestauranteVencedor());
        
        assertEquals("Palatus",vencedorDoDia.getNome());
    }
    
    @Test
    public void verificaVencedorCertoDoDiaERetornandoONomeCertoVesaoTres(){
        Voto votoUm = new Voto(3);
        gerenciador.votoUsuario(10,votoUm);
        Voto votoDois = new Voto(3);
        gerenciador.votoUsuario(20, votoDois);
        Voto votoTres = new Voto(1);
        gerenciador.votoUsuario(30, votoTres);      
        
        Restaurante vencedorDoDia = (gerenciador.verificarRestauranteVencedor());
        
        assertEquals("Panorama",vencedorDoDia.getNome());
    }
    
    @Test
    public void verificaVencedorCertoDoDiaERetornandoONomeCertoVesaoQuatro(){
        Voto votoUm = new Voto(1);
        gerenciador.votoUsuario(10,votoUm);
        Voto votoDois = new Voto(1);
        gerenciador.votoUsuario(20, votoDois);
        Voto votoTres = new Voto(1);
        gerenciador.votoUsuario(30, votoTres);      
        Voto votoQuatro = new Voto(3);
        gerenciador.votoUsuario(40, votoQuatro);      
        
        Restaurante vencedorDoDia = (gerenciador.verificarRestauranteVencedor());
        
        assertEquals("RU",vencedorDoDia.getNome());
    }
}

