public class Rectangle extends Shape {
    protected float lenght, width;

    public Rectangle(float lenght,float width){
        this.lenght = lenght;
        this.width = width;
    }

    @Override
    public float area(){
        return lenght * width;
    }

    @Override
    public String toString(){
        return("This is a rectangle with Length: " + lenght + " and Width: " + width);
    }
}
