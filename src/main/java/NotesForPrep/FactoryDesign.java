package NotesForPrep;

class Circle implements  Shape{
    int r;

    Circle(int r)
    {
        this.r = r;
    }

    public void printArea()
    {
        System.out.println("Area of Circle is:"+(2*3.14*r));
    }
}

class Square implements Shape{
    int side;
    Square(int side)
    {
        this.side=side;
    }
    @Override
    public void printArea()
    {
        System.out.println("Area of Square is:"+(side*side));
    }

}

interface Shape{

   void printArea();
}

class ShapeFactory{


    Shape fetchShape(int r, String sf)
    {
        if(sf.equals("Circle"))
            return new Circle(r);
        if(sf.equals("Square"))
            return new Square(r);
        return null;
    }
}


public class FactoryDesign {

    public static void main(String[] args) {
        ShapeFactory SF = new ShapeFactory();

        SF.fetchShape(10,"Circle").printArea();
        SF.fetchShape(10,"Square").printArea();

    }
}
