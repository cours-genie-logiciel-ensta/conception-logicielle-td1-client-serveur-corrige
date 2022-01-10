package banqueServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//## dependency swing 
//## class MontantBanqueGUI 
import javax.swing.JFrame;
//## dependency JTextField 
import javax.swing.JTextField;

/**
 * Une interface graphique triviale (un seul {@link JTextField}) qui affiche un
 * label représentant la dernière opération
 *
 */
@SuppressWarnings("serial")
public class MontantBanqueGUI extends JFrame implements PropertyChangeListener {

	private JTextField sommeTextField; // ## link testField

	/**
	 * @param laBanque
	 */
	public MontantBanqueGUI(Banque banque) {
		super();
		this.setTitle("Compte en banque");
		sommeTextField = new javax.swing.JTextField();
		this.add(sommeTextField);

		// On "écoute" la banque
		banque.getPropertyChangeSupport().addPropertyChangeListener(this);

		sommeTextField.setBackground(new java.awt.Color(255, 128, 0));
		sommeTextField.setPreferredSize(new java.awt.Dimension(250, 108));
		sommeTextField.setFont(new java.awt.Font("Antique Olive", 1, 20));
		sommeTextField.setText(String.valueOf(banque.getLeCompte().getSomme()));
		this.pack();
		this.setVisible(true);
		getContentPane().setBackground(new java.awt.Color(255, 128, 64));
		getContentPane().setForeground(new java.awt.Color(255, 128, 0));
	}

	/**
	 * Cette méthode est appelée quand un objet "écouté" notifie une modification
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() instanceof Banque) {
			if (evt.getPropertyName().equals("somme")) {
				sommeTextField.setText(String.valueOf(((Banque) evt.getSource()).getLeCompte().getSomme()));
			}
		}
	}

}
