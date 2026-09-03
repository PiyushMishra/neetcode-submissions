type SquareHole struct {   
    sideLength float64
}

func NewSquareHole(sideLength float64) *SquareHole {
    return &SquareHole {
        sideLength: sideLength,
    }     
} 

func (sqh *SquareHole) CanFit(square_like SquareLike) bool {
    return sqh.sideLength >= square_like.GetSideLength()      
} 

type SquareLike interface {
    GetSideLength() float64
}

type Square struct {
    sideLength float64
}

func NewSquare(sideLength float64) *Square {
    return &Square {
        sideLength: sideLength,
    }
} 

func (sq *Square) GetSideLength() float64 {
    return sq.sideLength;  
}  

type Circle struct {
    radius float64
}

func NewCircle(radius float64) *Circle {
    return &Circle {
        radius: radius,
    }
}

type CircleToSquareAdapter struct {
    circle *Circle
}

func NewCircleToSquareAdapter(circle *Circle) *CircleToSquareAdapter {
    return &CircleToSquareAdapter {
        circle: circle,
    }
}

func (ctsA *CircleToSquareAdapter) GetSideLength() float64 {
    return ctsA.circle.radius*2;  
}