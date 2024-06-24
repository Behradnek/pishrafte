public class Circle extends Shape {
    private float raduis;
    private double Mpi = Math.PI;
    private float pi = (float) Mpi;

    public Circle(float raduis){
        this.raduis = raduis;
    }

    @Override
    public float area(){
        return pi*raduis*raduis;
    }

    @Override
    public String toString(){
        return("This is a circle with Radius: " + raduis);
    }
}
