from abc import ABC, abstractmethod;

class Shape(ABC):
    @abstractmethod
    def clone(self):
        pass

class Square:
    def __init__(self, length: int):
        self.length = length;

    def get_length(self) -> int:
        return self.length;    

    def clone(self) -> Square:
        return Square(self.length);    

class Rectangle:
    def __init__(self, width: int, height: int):
        self.height = height;
        self.width = width;

    def get_width(self) -> int:
        return self.width;

    def get_height(self) -> int:
        return self.height;    

    def clone(self) -> Rectangle:
        return Rectangle(self.width,self.height)

class Test:
    def clone_shapes(self, shapes: list[Shape]):
        return [s.clone() for s in shapes];     































# from abc import ABC, abstractmethod

# class Shape(ABC):
#     @abstractmethod
#     def clone(self):
#         pass

# class Square(Shape):
#     def __init__(self, length: int):
#         self.length = length

#     def get_length(self) -> int:
#         return self.length

#     def clone(self) -> Shape:
#         # Write your code here

# class Rectangle(Shape):
#     def __init__(self, width: int, height: int):
#         self.width = width
#         self.height = height

#     def get_width(self) -> int:
#         return self.width

#     def get_height(self) -> int:
#         return self.height

#     def clone(self) -> Shape:
#         # Write your code here

# class Test:
#     def clone_shapes(self, shapes: List[Shape]) -> List[Shape]:
#         # Write your code here
