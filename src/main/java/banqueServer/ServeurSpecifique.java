package banqueServer;

//## dependency io 
import java.io.*;
//## dependency net 
import java.net.*;
//## auto_generated
import java.util.*;
//## dependency lang 
import java.lang.*;
//## dependency Socket 
import java.net.Socket;
//## class ServeurSpecifique 
import java.lang.Thread;

/**
 * 
 * * <!-- begin-UML-doc -->
 * * <br>
 * * <!-- end-UML-doc -->
 * * @author Root
 * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
class ServeurSpecifique extends Thread {
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private Socket clientSocket;		//## link clientSocket 
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private ServeurTCP monServeur;		//## link monServeur 
    
    
    /**
     * 
     * 
     * * <br><br><br>@param&nbsp;uneSocket&nbsp;<br>@param&nbsp;unServeur&nbsp;
     * * <!-- end-UML-doc -->
     * * @param uneSocket
     * * @param unServeur
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     * @param uneSocket
     * @param unServeur
    */
    public  ServeurSpecifique(Socket uneSocket, ServeurTCP unServeur) {
        super("ServeurThread");
        
        clientSocket = uneSocket;
        monServeur = unServeur;
    }
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    public void run() {
        String inputReq;
        
        try {
        	BufferedReader is = new BufferedReader(new InputStreamReader(
        			clientSocket.getInputStream()));
        	PrintStream os = new PrintStream(clientSocket.getOutputStream());
        	System.out.println("Serveur avec  Client ");
        
        	if ((inputReq = is.readLine()) != null) {
        		System.out.println(" Msg 2 Re�u " + inputReq);
        		String chaines[] = inputReq.split(" ");
        		System.out.println(" Ordre Re�u " + chaines[0]);
        		if (chaines[0].contentEquals("retrait")) {
        			int valeur = (new Integer(chaines[1])).intValue();
        
        			System.out.println(" valeur demandee  " + valeur);
        
        			int valeurRetrait = monServeur.getBanqueCentrale()
        					.demandeRetrait(valeur);
        
        			String valeurExpediee = "" + valeurRetrait;
        			System.out.println(" Retrait dans serveur "
        					+ valeurExpediee);
        
        			os.println(valeurExpediee);
        
        			System.out.println(monServeur);
        		}
        		if (chaines[0].contentEquals("depot")) {
        			int valeur = (new Integer(chaines[1])).intValue();
        
        			System.out.println(" valeur demandee  " + valeur);
        
        			int valeurDepot = monServeur.getBanqueCentrale()
        					.demandeDepot(valeur);
        
        			String valeurExpediee = "" + valeurDepot;
        			System.out.println(" D�pot dans serveur " + valeurExpediee);
        
        			os.println(valeurExpediee);
        
        			System.out.println(monServeur);
        		}
        	}
        	clientSocket.close();
        	os.close();
        	is.close();
        
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
}
