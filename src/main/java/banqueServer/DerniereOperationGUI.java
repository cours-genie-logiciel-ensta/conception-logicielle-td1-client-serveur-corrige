
package banqueServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//## dependency swing 
//## class DerniereOperationGUI 
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
public class DerniereOperationGUI extends JFrame implements PropertyChangeListener {

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JTextField testField; // ## link testField

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param b * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param b
	 */
	public DerniereOperationGUI(Banque b) {
		super();

		b.getPropertyChangeSupport().addPropertyChangeListener(this);

		this.setTitle("DERNIERE OPERATION");
		testField = new javax.swing.JTextField();
		this.add(testField);

		testField.setBackground(new java.awt.Color(255, 128, 0));
		testField.setPreferredSize(new java.awt.Dimension(250, 108));
		testField.setFont(new java.awt.Font("Antique Olive", 1, 20));
		testField.setText(String.valueOf(b.getTypeOperation()));
		this.pack();
		this.setVisible(true);
		getContentPane().setBackground(new java.awt.Color(255, 128, 64));
		getContentPane().setForeground(new java.awt.Color(255, 128, 0));
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() instanceof Banque) {
			if (evt.getPropertyName().equals("typeOperation")) {
				testField.setText(((Banque) evt.getSource()).getTypeOperation());
			}
		}
	}
}
