package View;

public class Menu {
    public static int mainMenu(){
        System.out.println("Bienvenidos al ParkingSoft v0.1");
        System.out.println("1. Listar coches");
        System.out.println("2. Cuántos coches hay");
        System.out.println("3. Aparcar coche");
        System.out.println("4. Sacar coche");
        System.out.println("5. Salir");
        return UI.readInt("Elija un opción:");
    }

    public static String parkingMenu_step1(){
        return UI.readString("Inserte la matrícula: ");
    }

    public static String parkingMenu_step2(){
        return UI.readString("Inserte el modelo: ");
    }

    public static int parkingMenu_step3(){
        return UI.readInt("Inserte la edad: ");
    }

    public static String unparkingMenu(){
        return UI.readString("Inserte la matrícula: ");
    }
}
