class Vehicle(ABC):
    @abstractmethod
    def getType(self) -> str:
        pass

class Bike(ABC):
    def getType(self) -> str:
        return "Bike"

class Car(ABC):
    def getType(self) -> str:
        return "Car"
        
class Truck(ABC):
    def getType(self) -> str:
        return "Truck"

class VehicleFactory(ABC):
    def createVehicle(self) -> Vehicle:
        pass

class CarFactory(VehicleFactory):
    def createVehicle(self) -> Vehicle:
        return Car();

class BikeFactory(VehicleFactory):
    def createVehicle(self) -> Vehicle:
        return Bike();

class TruckFactory(VehicleFactory):
    def createVehicle(self) -> Vehicle:
        return Truck();                
