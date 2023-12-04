import java.util.ArrayList;
import java.util.List;

// Component
interface Shape {
    void draw();
}

// Leaf
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Desenhando um círculo");
    }
}

// Leaf
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Desenhando um quadrado");
    }
}

// Composite
class Group implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void draw() {
        System.out.println("Desenhando um grupo:");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

// Client
public class CompositeExample {
    public static void main(String[] args) {
        // Criando formas individuais
        Circle circle = new Circle();
        Square square = new Square();

        // Criando um grupo
        Group group = new Group();
        group.addShape(circle);
        group.addShape(square);

        // Desenhando formas individuais
        System.out.println("Desenhando formas individuais:");
        circle.draw();
        square.draw();

        System.out.println();

        // Desenhando o grupo
        System.out.println("Desenhando o grupo:");
        group.draw();
    }
}
