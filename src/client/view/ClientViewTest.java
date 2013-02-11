package client.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.BattleField;

import controler.Controller;

public class ClientViewTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final BattleField battleField = new BattleField();
		battleField.putAllRandom();
		/*ClientView clientView =  new ClientView();
		clientView.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		clientView.setVisible(true);*/
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ClientView clientView =  new ClientView();
				clientView.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				clientView.setVisible(true);
				
			}
		});
		//clientView.displayShips();

	}
}
