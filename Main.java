import Controller.MainController;
import View.UI;

public class Main {
    public static void main(String[] args) {
        String name = UI.readString("Inserte el nombre del parking");
        int spots = UI.readInt("Inserte el número de plazas");
        MainController.starApp(name, spots);

        // Aunque hay varias maneras de ponerlo
        //MainController.starApp("IES Francisco de los Ríos", 4);

        //Ó

        //MainController.starApp(UI.readString("Inserte el nombre del parking"), UI.readInt("Inserte el número de plazas"));
    }
}
