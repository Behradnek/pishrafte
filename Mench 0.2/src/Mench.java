import java.util.Random;

public class Mench {
    private Bazikon[] bazikonha;
    private Mohre[] board;
    private Mohre[][] ashiane;

    public Mench() {
        this.bazikonha = new Bazikon[4];
        this.board = new Mohre[40];
        this.ashiane = new Mohre[4][4];
        Color[] rangha = Color.values();
        for (int i = 0; i < 4; i++) {
            this.bazikonha[i] = new Bazikon(rangha[i]);
        }
    }

    public boolean harkat(Mohre mohre, int tas) {
        int mahalJadid = mohre.getMahal() + tas;
        if (mohre.isInAshiane()) {
            if (mahalJadid > 4) {
                return false; //past the last square in ashiane, it does not move
            }
            else if (ashiane[mohre.getRang().ordinal()][mahalJadid] != null) {
                return false; // same color, it does not move
            }
            else {
                ashiane[mohre.getRang().ordinal()][mohre.getMahal()] = null;
                mohre.setMahal(mahalJadid);
                ashiane[mohre.getRang().ordinal()][mahalJadid] = mohre;
                return true;
            }
        }
        else if (mahalJadid > 40) {
            mohre.setInAshiane(true);
            mohre.setMahal(0);
            ashiane[mohre.getRang().ordinal()][0] = mohre;
            return true;
        }
        else if (board[mahalJadid] != null) {
            if (board[mahalJadid].getRang() == mohre.getRang()) {
                return false; // same color, it does not move
            }
            else {
                board[mahalJadid].setMahal(-1);  // beat the other mohre
            }
        }
        board[mohre.getMahal()] = null;
        mohre.setMahal(mahalJadid);
        board[mahalJadid] = mohre;
        return true;
    }

    public int tass(){
        int t = new Random().nextInt(5);
        return t+1;
    }

    public void behtarinHarkat(Bazikon bazikon, int tas) {
        // Try to enter a mohre into the game
        for (Mohre mohre : bazikon.getMohreha()) {
            if (mohre.getMahal() == -1 && tas == 6) {
                mohre.setMahal(mohre.mahalShoro());
                return;
            }
        }
        // Try to move a mohre into the home area
        for (Mohre mohre : bazikon.getMohreha()) {
            if (!mohre.isInAshiane() && mohre.getMahal() + tas == 40) {
                harkat(mohre, tas);
                return;
            }
        }
        // Try to beat a mohre
        for (Mohre mohre : bazikon.getMohreha()) {
            int mahalJadid = mohre.getMahal() + tas;
            if (mahalJadid > 40) {
                mahalJadid = mahalJadid - 40; // wrap around to the start of the board
            }
            if (board[mahalJadid] != null && board[mahalJadid].getRang() != mohre.getRang()) {
                harkat(mohre, tas);
                return;
            }
        }
        // Just move the first mohre that can move
        for (Mohre mohre : bazikon.getMohreha()) {
            if (harkat(mohre, tas)) {
                return;
            }
        }
    }
}