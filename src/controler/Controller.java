package controler;

import model.BattleField;
import client.view.ClientView;

public class Controller {
	private ClientView clientView;
	private BattleField battleField;
	public BattleField getBattleField() {
		return battleField;
	}

	public void setBattleField(BattleField battleField) {
		this.battleField = battleField;
	}

	public Controller(ClientView clientView) {
		super();
		this.clientView = clientView;
	}

	public ClientView getClientView() {
		return clientView;
	}

	public void setClientView(ClientView clientView) {
		this.clientView = clientView;
	}
	

	
}
