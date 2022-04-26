import java.io.IOException;

import javax.swing.UIManager;

import controller.AppController;
import view.GUI;

public final class Main {
	
	private Main() {
	}

	//main method from where application is activated
	//default functionalities by javax.swing
	public static void main(String[] args) throws IOException {
		try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e) {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception f) {
                f.printStackTrace();
            }
        }
        new AppController();
		new GUI();
    }
}
