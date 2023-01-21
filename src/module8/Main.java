package module8;

public class Main {
    public static void main(String[] args) {
        Shape[] figures = new Shape[] {new Circle(), new Quad(), new Triangle(), new Trapeze(), new Parallelogram()};

        for (Shape figure: figures) {
            new ShapeName(figure).printShapeName();
        }
    }
}
