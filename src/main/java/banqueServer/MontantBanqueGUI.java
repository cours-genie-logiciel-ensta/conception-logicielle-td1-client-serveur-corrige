package banqueServer;

//## auto_generated
import java.util.*;
//## dependency swing 
import javax.swing.*;
//## class MontantBanqueGUI 
import javax.swing.JFrame;
//## class MontantBanqueGUI 
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
public class MontantBanqueGUI extends JFrame implements Observer {
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private JTextField testField;		//## link testField 
    
    
    
    /**
     * @param laBanque
    */
    public  MontantBanqueGUI(Banque laBanque) {
        super();
        this.setTitle("BANQUE STRATEGIQUE");
        testField = new javax.swing.JTextField();
        this.add(testField);
        
        laBanque.addObserver(this);
        
        testField.setBackground(new java.awt.Color(255, 128, 0));
        testField.setPreferredSize(new java.awt.Dimension(250, 108));
        testField.setFont(new java.awt.Font("Antique Olive", 1, 20));
        testField.setText(String.valueOf(laBanque.getLeCompte().getSomme()));
        this.pack();
        this.setVisible(true);
        getContentPane().setBackground(new java.awt.Color(255, 128, 64));
        getContentPane().setForeground(new java.awt.Color(255, 128, 0));
    }
    
    /**
     * @param o
     * @param arg
    */
    public void update(Observable o, Object arg) {
        this.testField.setText(String.valueOf(((Banque) o).getLeCompte().getSomme()));
    }
    
}
