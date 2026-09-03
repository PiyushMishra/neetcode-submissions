class Square:

    def __init__(self, side_length: float = 0.0):
        self.side_length = side_length

    def get_side(self):
        return self.side_length;

class SquareHole:
    def __init__(self, side_length: float):
        self.side_length = side_length

    def canFit(self, square: Square):
        return square.get_side() <= self.side_length;

class Circle:
    def __init__(self, radius: float):
        self.radius = radius;

    def get_radius(self):
        return self.radius;    


class CircleToSquareAdapter(Square):

    def __init__(self, circle: Circle):
        self.circle = circle;

    def get_side(self):
        return self.circle.get_radius()*2;   


