public class Mohre {
    public Color rang;
    public int mahal;
    public boolean inAshiane;

    public Mohre(Color rang) {
        this.rang = rang;
        this.mahal = -1;
        this.inAshiane = false;
    }

    public int mahalShoro() {
        switch (rang) {
            case Abi:
                return 11;
            case Ghermez:
                return 21;
            case Sabz:
                return 31;
            case Zard:
                return 1;
            default:
                return -1;
        }
    }

    public Color getRang() {
        return rang;
    }

    public int getMahal() {
        return mahal;
    }

    public void setMahal(int mahal) {
        this.mahal = mahal;
    }

    public boolean isInAshiane() {
        return inAshiane;
    }

    public void setInAshiane(boolean inAshiane) {
        this.inAshiane = inAshiane;
    }
}
