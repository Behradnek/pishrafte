import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyPaint {
    private ArrayList<Shape> canvas = new ArrayList<>();

    public void addShape(Shape shape){
        canvas.add(shape);
    }

    public float filledArea(){
        float totalArea = 0;
        for(Shape shape : canvas){
            totalArea += shape.area();
        }
        return totalArea;
    }

    public void printShapes(){
        for(Shape shape : canvas){
            System.out.println(shape);
        }
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
                System.out.println("Select Your Shape:");
                System.out.println("1: Rectangle");
                System.out.println("2: Triangle");
                System.out.println("3: Circle");
                System.out.println("4: End");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();

                if(choice == 4){break;}
                else if (choice == 1) {
                    System.out.println("Enter the lenght: ");
                    float lenght = scanner.nextFloat();
                    System.out.println("Enter the width: ");
                    float width = scanner.nextFloat();
                    if (lenght == width) {
                        addShape(new Square(lenght));
                    } else {
                        addShape(new Rectangle(lenght, width));
                    }                
                } else if (choice == 2) {
                    System.out.println("Enter the height: ");
                    float height = scanner.nextFloat();
                    System.out.println("Enter the base: ");
                    float base = scanner.nextFloat();
                    addShape(new Triangle(height, base));
                } else if (choice == 3) {
                    System.out.println("Enter the radius: ");
                    float raduis = scanner.nextFloat();
                    addShape(new Circle(raduis));
                } else {
                    System.out.println("invalid choice!");
                } 
                if (canvas.size() == 100){break;}
            }
            catch(InputMismatchException e){
                System.out.println("Enter a number!");
                scanner.next();
            }
            catch(Exception e){
                System.out.println("an error occureed");
                break;
            }
        }

        System.out.println("filled area on canvas:" + filledArea());
        printShapes();
        scanner.close();
    }
    public static void main(String[] args) {
        MyPaint paint = new MyPaint();
        paint.menu();
    }
}
