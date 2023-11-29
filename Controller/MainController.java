package Controller;

import Model.Car;
import Model.Parking;
import View.Menu;

public class MainController {
    /**
     * Modelo
     */
    public static Parking parking;
    public static void starApp(String nameParking, int spots){
        parking = new Parking(nameParking,spots);
        int option = -1;
        do {
            option = Menu.mainMenu();
            mainController(option);
        }while(option != 5);
    }

    public static void mainController(int option){
        switch (option){
            case 1: //listar todos los coches
                System.out.println("*************");
                System.out.println(parking);
                System.out.println("*************");
                break;
            case 2: //mostrar cuantos coches hay en el parking
                int nCars = parking.howManyCars();
                if (nCars == 0){
                    System.out.println("No hay coches");
                }else if (nCars == 1){
                    System.out.println("Hay 1 coche");
                }else{
                    System.out.println("Hay " + nCars + " coches" + (nCars > 1? "s" : ""));
                }
                break;
            case 3://aparcar coche
                if (parking.isFull()){
                    System.out.println("Lo siento, no hay espacio");
                }else{
                    //pido datos del coche
                    String license = Menu.parkingMenu_step1();
                    String model = Menu.parkingMenu_step2();
                    int age = Menu.parkingMenu_step3();
                    Car caToBeInserted = new Car(license, model, age);
                    int parked = parking.parkCar(caToBeInserted);
                    if (parked == -1){
                        System.out.println("Error al aparcar el coche");
                    }else{
                        System.out.println("Hemos aparcado el coche en la plaza " + parked);
                    }
                }
                break;
            case 4://sacar coche
                String license = Menu.unparkingMenu();
                Car carToBeUnparked = parking.unParkCar(license);
                if (carToBeUnparked == null){
                    System.out.println("Error al sacar el coche");
                }else{
                    System.out.println("El coche que sacamos es " + carToBeUnparked);
                }
                break;
            case 5://cerrar programa
                break;
            default:
                System.out.println("Opción incorrecta");
        }
    }
}
