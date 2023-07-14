package campominado_java;

public class Jogo {

    private Tabuleiro tabuleiro;
    boolean terminar = false;
    boolean ganhou = false;
    int[] jogada;
    int rodada = 0;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        Jogar(tabuleiro);
        jogada = new int[2];
    }

    public void Jogar(Tabuleiro board) {
        do {
            rodada++;
            System.out.println("Rodada " + rodada);
            board.exibe();
            terminar = board.setPosicao();

            if (!terminar) {
                board.abrirVizinhas();
                terminar = board.ganhou();
            }

        } while (!terminar);

        if (!board.ganhou()) {
            
            board.exibeMinas();
            System.out.println("BUMMMMMM - estourou a mina ! Você perdeu!");
        } else {
            //System.out.println("Parabéns, você deixou os 8 campos de minas livres em " + rodada + " rodadas");
            
            board.exibeMinas();
            System.out.println("Parabéns, você venceu em " + rodada + " rodadas");
        }
    }
}
