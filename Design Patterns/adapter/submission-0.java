class SquareHole {
    private final double side;

    public SquareHole(double side) {
        this.side = side;
    }

    public boolean canFit(Square square) {
        return square.getLength() <= side;
    }
}

class Square {
    protected double length;

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}

class Circle {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class CircleToSquareAdapter extends Square {

    private final Circle circle;

    public CircleToSquareAdapter(Circle circle) {
        super(0);    // adapter computes length dynamically
        this.circle = circle;
    }

    @Override
    public double getLength() {
        return circle.getRadius() * 2;
    }
}