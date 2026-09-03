struct SquareHole {
    square_hole_length: f64,
}

trait SquareLike {
    fn get_side(&self) -> f64;
}

impl SquareHole {
    fn can_fit(&self, square_like: &dyn SquareLike) -> bool {
        self.square_hole_length >= square_like.get_side()
    }

    fn new(square_hole_length: f64) -> Self {
        SquareHole {
            square_hole_length
        }
    }
}

struct Square {
    side_length: f64
}

impl Square {
    fn new(side_length: f64) -> Self {
        Self { 
            side_length
        }
    }
}

impl SquareLike for Square {
    fn get_side(&self) -> f64 {
        self.side_length
    }
}

struct Circle {
    radius: f64
}

impl Circle {
    fn new(radius: f64) -> Self {    
        Self {radius}
    }
}

struct CircleToSquareAdapter {
    circle: Circle,
}

impl CircleToSquareAdapter {
    fn new(circle: Circle) -> Self {
        Self {
            circle
        }
    }
}

impl SquareLike for CircleToSquareAdapter {
    fn get_side(&self) -> f64 {
        self.circle.radius * 2 as f64
    }
}