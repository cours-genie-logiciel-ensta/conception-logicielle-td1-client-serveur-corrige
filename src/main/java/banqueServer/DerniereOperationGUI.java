
package banqueServer;

//## auto_generated
import java.util.*;
//## dependency swing 
import javax.swing.*;
//## class DerniereOperationGUI 
import javax.swing.JFrame;
//## dependency Observer 
import java.util.Observer;
//## dependency Observable 
import java.util.Observable;
//## dependency JTextField 
import javax.swing.JTextField;


/**
 * 
 * * <!-- begin-UML-doc -->
 * * <!-- end-UML-doc -->
 * * @author Root
 * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class DerniereOperationGUI extends JFrame {
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private JTextField testField;		//## link testField 
    
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @param b
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     * @param b
    */
    public  DerniereOperationGUI(Banque b) {
        super();
        
		// banque addObserver
		
		
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
    
    /**
     * 
     * 
    */

	// code to insert in update
	//        this.testField.setText(String.valueOf(((Banque) o).getTypeOperation()));
    
	
	
}
