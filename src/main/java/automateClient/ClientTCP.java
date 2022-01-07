
package automateClient;

import java.io.*;
//## dependency net 
import java.net.*;
//## auto_generated
import java.net.Socket;
//## dependency PrintStream 
import java.io.PrintStream;
//## dependency BufferedReader 
import java.io.BufferedReader;

/**
 * 
 * * <!-- begin-UML-doc -->
 * * <br><br><br>
 * * <!-- end-UML-doc -->
 * * @author Root
 * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ClientTCP {
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private int numeroPort;		//## attribute numeroPort 
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private String nomServeur;		//## attribute nomServeur 
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private BufferedReader socIn;		//## link socIn 
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private PrintStream socOut;		//## link socOut 
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    private Socket socketServeur;		//## link socketServeur 
    
    
    // Constructors
    
    /**
     * 
     * 
     * * <br><br><br>@param&nbsp;unNomServeur&nbsp;<br>@param&nbsp;unNumero&nbsp;
     * * <!-- end-UML-doc -->
     * * @param unNomServeur
     * * @param unNumero
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     * @param unNomServeur
     * @param unNumero
    */
    public  ClientTCP(String unNomServeur, int unNumero) {
        numeroPort = unNumero;
        nomServeur = unNomServeur;
    }
    
    /**
     * 
     * 
     * * <br><br><br>@return&nbsp;
     * * <!-- end-UML-doc -->
     * * @return
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    public boolean connexionServeur() {
        try {
        	socketServeur = new Socket(nomServeur, numeroPort);
        	socOut = new PrintStream(socketServeur.getOutputStream());
        	socIn = new BufferedReader(new InputStreamReader(
        			socketServeur.getInputStream()));
        
        } catch (UnknownHostException e) {
        	System.err.println("Serveur inconnu : " + e);
        
        } catch (Exception e) {
        	System.err.println("Exception:  " + e);
        
        }
        
        return true;
    }
    
    /**
     * 
     * 
     * * <br><br><br>@return&nbsp;<br>@param&nbsp;uneChaine&nbsp;
     * * <!-- end-UML-doc -->
     * * @param uneChaine
     * * @return
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     * @param uneChaine
    */
    public String connexionTransmettreChaine(String uneChaine) {
        String msgServeur = null;
        if (connexionServeur() == true) {
        	try {
        
        		System.out.println("Client " + uneChaine);
        		socOut.println(uneChaine);
        		socOut.flush();
        
        		msgServeur = socIn.readLine();
        		System.out.println("Client msgServeur " + msgServeur);
        		deconnexionServeur();
        	} catch (Exception e) {
        		System.err.println("Exception:  " + e);
        	}
        }
        
        return msgServeur;
    }
    
    /**
     * 
     * 
     * * <br><br>
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    public void deconnexionServeur() {
        try {
        	socOut.close();
        	socIn.close();
        	socketServeur.close();
        } catch (Exception e) {
        	System.err.println("Exception:  " + e);
        }
    }
    
    /**
     * 
     * 
     * * <br><br><br>@return&nbsp;<br>@param&nbsp;uneChaine&nbsp;
     * * <!-- end-UML-doc -->
     * * @param uneChaine
     * * @return
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     * @param uneChaine
    */
    public String transmettreChaine(String uneChaine) {
        String msgServeur = null;
        try {
        
        	System.out.println("Client " + uneChaine);
        
        	socOut.println(uneChaine);
        	socOut.flush();
        
        	msgServeur = socIn.readLine();
        
        	System.out.println("Client msgServeur " + msgServeur);
        
        } catch (UnknownHostException e) {
        	System.err.println("Serveur inconnu : " + e);
        } catch (Exception e) {
        	System.err.println("Exception:  " + e);
        }
        return msgServeur;
    }
    
}

