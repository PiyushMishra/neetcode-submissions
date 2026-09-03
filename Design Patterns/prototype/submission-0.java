interface Shape {
    Shape clone();
}

class Square implements Shape {
   
    int side;

    public Square(int side) {
        this.side = side;
    }

    public int getLength() {
        return side;
    }

    @Override
    public Square clone() {
       return new Square(getLength()); 
    }
}


class Rectangle implements Shape {
   
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this.width, this.height); 
    }
}


class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        // Write your code here
        return shapes.stream().map(s  -> s.clone()).collect(Collectors.toList());
    }
}






















// interface Shape {
//     Shape clone();
// }

// class Rectangle implements Shape {
//     private int width;
//     private int height;

//     public Rectangle(int width, int height) {
//         this.width = width;
//         this.height = height;
//     }

//     public int getWidth() {
//         return this.width;
//     }

//     public int getHeight() {
//         return this.height;
//     }

//     @Override
//     public Shape clone() {
//         // Write your code here
//     }
// }

// class Square implements Shape {
//     private int length;

//     public Square(int length) {
//         this.length = length;
//     }

//     public int getLength() {
//         return this.length;
//     }

//     @Override
//     public Shape clone() {
//         // Write your code here
//     }
// }

// class Test {
//     public List<Shape> cloneShapes(List<Shape> shapes) {
//         // Write your code here
//     }
// }
