package termProject;

import java.awt.EventQueue;

public class Program {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				LoginPage lp = new LoginPage();
			}
		});
	}

}
