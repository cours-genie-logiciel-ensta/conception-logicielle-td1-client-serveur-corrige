package banqueServer;

//## dependency io 
import java.io.IOException;
//## dependency net 
import java.net.ServerSocket;
//## dependency Socket 
import java.net.Socket;

/**
 * 
 * * <!-- begin-UML-doc --> * <br>
 * <br>
 * * <!-- end-UML-doc --> * @author Root * @generated "UML vers Java
 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServeurTCP {

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * @poseidon-object-id&nbsp;[Ic5495em10906c7af27mm7da0] * <!-- end-UML-doc -->
	 * * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int numeroPort; // ## attribute numeroPort

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * @poseidon-object-id&nbsp;[Ic5495em10906c7af27mm7da7] * <!-- end-UML-doc -->
	 * * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IBanque banqueCentrale; // ## link banqueCentrale

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * @poseidon-object-id&nbsp;[Ic5495em10906c7af27mm7db0] * <!-- end-UML-doc -->
	 * * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Socket clientSocket; // ## link clientSocket

	// Constructors

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * @poseidon-object-id&nbsp;[Ic5495em10906c7af27mm7d99]<br>
	 * @param&nbsp;unNumeroPort&nbsp; * <!-- end-UML-doc --> * @param unNumeroPort
	 * * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param unNumeroPort
	 */
	ServeurTCP(int unNumeroPort) {
		numeroPort = unNumeroPort;
	}

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * @poseidon-object-id&nbsp;[Ic5495em10906c7af27mm7d8c]<br>
	 * @return&nbsp; * <!-- end-UML-doc --> * @return * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IBanque getBanqueCentrale() {
		return banqueCentrale;
	}

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * @poseidon-object-id&nbsp;[Ic5495em10906c7af27mm7d80] * <!-- end-UML-doc -->
	 * * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void go() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(numeroPort);
		} catch (IOException e) {
			System.out.println("Could not listen on port: " + numeroPort + ", " + e);
			System.exit(1);
		}

		for (int nbClient = 0; nbClient <= 3; nbClient++) {
			try {
				/*
				 * **************** Attente du serveur pour l'acces a +sieurs Clients
				 ****************/
				System.out.println(" Attente du serveur pour la communication d'un client ");
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.out.println("Accept failed: " + 6666 + ", " + e);
				System.exit(1);
			}
			ServeurSpecifique st = new ServeurSpecifique(clientSocket, this);
			st.start();
		}

		try {
			serverSocket.close();
		} catch (IOException e) {
			System.out.println("Could not close");
		}
	}

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * @poseidon-object-id&nbsp;[Ic5495em10906c7af27mm7d92]<br>
	 * @param&nbsp;uneBanque&nbsp; * <!-- end-UML-doc --> * @param uneBanque
	 * * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param uneBanque
	 */
	public void setBanqueCentrale(IBanque uneBanque) {
		banqueCentrale = uneBanque;
	}

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * @poseidon-object-id&nbsp;[Ic5495em10906c7af27mm7d86]<br>
	 * @return&nbsp; * <!-- end-UML-doc --> * @return * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public String toString() {
		return "Serveur de banque avec une somme de :" + banqueCentrale;
	}

}
