type Vehicle interface {
    GetType() string
}

type Car struct {}
type Bike struct {}
type Truck struct {}

func (c *Car) GetType() string {
    return "Car"
}

func (b *Bike) GetType() string {
    return "Bike" 
}

func (t *Truck) GetType() string {
    return "Truck" 
}

type VehicleFactory interface {
    CreateVehicle() Vehicle
} 

type CarFactory struct {}
type BikeFactory struct {}
type TruckFactory struct {}

func (c *CarFactory) CreateVehicle() Vehicle {
    return &Car {} 
}

func (b *BikeFactory) CreateVehicle() Vehicle {
    return &Bike {} 
}

func (t *TruckFactory) CreateVehicle() Vehicle {
    return &Truck {}
}






