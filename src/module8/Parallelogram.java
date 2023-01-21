package module8;

public class Parallelogram extends Shape{
    @Override
    public String getName(Shape shape) {
        return "Figure's name is " + shape.getClass().getSimpleName();
    }
}
