
import business.DeliveryService;
import data.Serializator;
import presentation.LogInGUI;

public class Main {

	public static void main(String[] args) {
		Serializator s = new Serializator();
		DeliveryService ds = s.deserialize();
		//DeliveryService ds = new DeliveryService();
		LogInGUI gui = new LogInGUI(ds);
		gui.setVisible(true);
	}
	

}
