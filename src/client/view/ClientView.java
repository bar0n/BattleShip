package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.BattleField;

public class ClientView extends JFrame {

	private static final long serialVersionUID = 1L;

	public BattleField getBattleField() {
		return battleField;
	}

	public void setBattleField(BattleField battleField) {
		this.battleField = battleField;
	}

	private BattleField battleField;
	private FieldPanel leftField;
	private JPanel rigthField;

	public void displayShips() {

		for (Component cell : leftField.getComponents()) {
			if (cell instanceof Cell) {
				 Cell cellThis = (Cell)cell;
				if (battleField.isPointBusy(cellThis.getXx(),cellThis.getYy())){
					cellThis.setText("X");
					cellThis.setBackground(Color.BLUE);
				}
			}

		}
	}

	public ClientView() {

		setLayout(new BorderLayout());
		JSplitPane center = new JSplitPane();

		leftField = new FieldPanel();
		rigthField = new FieldPanel();

		center.setLeftComponent(leftField);
		center.setRightComponent(rigthField);

		add(center, "Center");
		center.setResizeWeight(0.5);
		center.setOneTouchExpandable(true);
		setResizable(false);

		setLocationRelativeTo(null);
		pack();

	}

	public static class FieldPanel extends JPanel {

		private static final long serialVersionUID = -2774385827669413884L;

		public FieldPanel() {

			init();

		}

		private void init() {
			setLayout(new GridLayout(11, 11));

			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					if (i == 0 && j == 0) {
						add(new JLabel());
					} else if (i == 0) {

						Character ch = (char) ('À' + j - 1);
						if (j == 10)
							ch = 'Ê';
						JButton lab = new JButton(ch.toString());
						lab.setEnabled(false);
						add(lab);

					} else if (j == 0) {
						Integer ii = i;
						JButton lab = new JButton(ii.toString());
						lab.setEnabled(false);
						add(lab);
					} else {
						Cell cell = new Cell(j - 1, i - 1);
						Dimension size = cell.getSize();						
						size.setSize(size.getHeight(), size.getHeight());
						cell.setSize(size);
						add(cell);
					}
				}
			}

		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // paints background
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.black);
			// g2.drawRect(10, 10, getWidth() - 10, getHeight() - 10);

		}

	}

	public static class Cell extends JButton {

		private static final long serialVersionUID = 1L;
		private int xx;
		private int yy;

		public int getXx() {
			return xx;
		}

		public int getYy() {
			return yy;
		}

		public void setXx(int xx) {
			this.xx = xx;
		}

		public void setYy(int yy) {
			this.yy = yy;
		}

		public Cell(int i, int j) {
			super();
			this.xx = i;
			this.yy = j;
			setPreferredSize(new Dimension(25, 25));
			setSize(25, 25);
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("x=" + xx + " y=" + yy);

				}
			});
		}

	}
}
