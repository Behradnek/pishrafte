public class Bazikon {
    private Mohre[] mohreha;

    public Bazikon(Color rang) {
        this.mohreha = new Mohre[4];
        for (int i = 0; i < 4; i++) {
            this.mohreha[i] = new Mohre(rang);
        }
    }

    public Color rangMohre() {
        return this.mohreha[0].getRang();
    }

    public Mohre[] getMohreha() {
        return mohreha;
    }
}