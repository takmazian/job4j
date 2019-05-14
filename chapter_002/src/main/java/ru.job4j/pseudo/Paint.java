package ru.job4j.pseudo;

public class Paint {
    void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        Triangle triangle = new Triangle();
        Square square = new Square();
        paint.draw(triangle);
        paint.draw(square);
    }
}
