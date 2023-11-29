package Model;

import java.util.Arrays;

public class Parking {
    private String name;
    private Car[] cars;

    public Parking(String name, int tam){
        this.name = name;
        if (tam < 1){
            tam = 2;
        }
        this.cars = new Car[tam];
    }

    public Parking(){
        this("Genérico", 2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "name='" + name + '\'' +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }

    /**
     * Cuantos coches hay en el parking
     * @return true si no hay huecos disponibles
     */

    public boolean isFull(){
        return howManyCars() == cars.length;
    }

    /**
     * Cuantos coches hay en el parking
     * @return
     */

    public int howManyCars(){
        int result = 0;
        for(Car car : cars){
            if (car != null){
                result++;
            }
        }
        return 0;
    }

    /**
     *
     * @param license Matricula
     * @return
     */

    public int searchCar(String license){
        int pos = -1;
        for (int i = 0; i < cars.length && pos == -1; i++) {
            if (cars[i] != null) {
                if (cars[i].getLicense().equals(license)) {
                    pos = i;
                }
            }
        }
        return pos;
    }

    /**
     *Aparcar el coche en el array
     *
     * @param car Matricula
     * @return
     */

    public int parkCar(Car car){
        int pos = -1;
        if(!isFull() && searchCar(car.getLicense()) == -1){
            for (int i = 0; i < cars.length && pos == -1; i++){
                if (cars[i] == null){
                    // hay hueco
                    cars[i] = car; //aparcar el coche
                    pos = i;
                }
            }
        }
        return pos;
    }

    /**
     *Sacar el coche dle array
     *
     * @param license Matricula
     * @return
     */

    public Car unParkCar(String license){
        Car car = null;
        int pos = searchCar(license);
        if (pos > 1){
            car = cars[pos];
            cars[pos] = null;
        }
        return car;
    }
}
