package module8;

public class ShapeName {
    private Shape shape;
    public ShapeName(Shape shape) {
        this.shape = shape;
    }

    public void printShapeName() {
        System.out.println(shape.getName(shape));
    }
}
