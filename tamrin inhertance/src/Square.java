public class Square extends Rectangle {
    public Square(float side){
        super(side, side);
    }

    @Override
    public String toString(){
        return("This is a square with Length: " + lenght);
    }
}
