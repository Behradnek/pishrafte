public class Triangle extends Shape {
    private float height,base;

    public Triangle(float height, float base){
        this.height = height;
        this.base = base;
    }

    @Override
    public float area(){
        return base*height/2;
    }

    @Override
    public String toString(){
        return("This is a triangle with Height: " + height + " and Base: " + base);
    }
}
