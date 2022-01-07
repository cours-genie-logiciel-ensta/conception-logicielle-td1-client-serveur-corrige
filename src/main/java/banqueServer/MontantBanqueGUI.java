package banqueServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//## dependency swing 
//## class MontantBanqueGUI 
import javax.swing.JFrame;
//## dependency JTextField 
import javax.swing.JTextField;

/**
 * 
 * * <!-- begin-UML-doc --> * <!-- end-UML-doc --> * @author Root * @generated
 * "UML vers Java
 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@SuppressWarnings("serial")
public class MontantBanqueGUI extends JFrame implements PropertyChangeListener {

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JTextField testField; // ## link testField

	/**
	 * @param laBanque
	 */
	public MontantBanqueGUI(Banque laBanque) {
		super();
		this.setTitle("BANQUE STRATEGIQUE");
		testField = new javax.swing.JTextField();
		this.add(testField);

		laBanque.getPropertyChangeSupport().addPropertyChangeListener(this);

		testField.setBackground(new java.awt.Color(255, 128, 0));
		testField.setPreferredSize(new java.awt.Dimension(250, 108));
		testField.setFont(new java.awt.Font("Antique Olive", 1, 20));
		testField.setText(String.valueOf(laBanque.getLeCompte().getSomme()));
		this.pack();
		this.setVisible(true);
		getContentPane().setBackground(new java.awt.Color(255, 128, 64));
		getContentPane().setForeground(new java.awt.Color(255, 128, 0));
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() instanceof Banque) {
			if (evt.getPropertyName().equals("somme")) {
				testField.setText(String.valueOf(((Banque) evt.getSource()).getLeCompte().getSomme()));
			}
		}
	}

}
