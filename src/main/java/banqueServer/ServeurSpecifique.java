package banqueServer;

//## dependency io 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
//## dependency net 
//## dependency Socket 
import java.net.Socket;

/**
 * 
 * * <!-- begin-UML-doc --> * <br>
 * * <!-- end-UML-doc --> * @author Root * @generated "UML vers Java
 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
class ServeurSpecifique extends Thread {

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * * <!-- end-UML-doc --> * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Socket clientSocket; // ## link clientSocket

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * * <!-- end-UML-doc --> * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ServeurTCP monServeur; // ## link monServeur

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * <br>
	 * 
	 * @param&nbsp;uneSocket&nbsp;<br>
	 * @param&nbsp;unServeur&nbsp; * <!-- end-UML-doc --> * @param uneSocket
	 *                               * @param unServeur * @generated "UML vers Java
	 *                               (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param uneSocket
	 * @param unServeur
	 */
	public ServeurSpecifique(Socket uneSocket, ServeurTCP unServeur) {
		super("ServeurThread");

		clientSocket = uneSocket;
		monServeur = unServeur;
	}

	/**
	 * 
	 * 
	 * * <br>
	 * <br>
	 * * <!-- end-UML-doc --> * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public void run() {
		String inputReq;

		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintStream os = new PrintStream(clientSocket.getOutputStream());
			System.out.println("Serveur avec  Client ");

			if ((inputReq = is.readLine()) != null) {
				System.out.println(" Msg 2 Recu " + inputReq);
				String chaines[] = inputReq.split(" ");
				System.out.println(" Ordre Recu " + chaines[0]);
				if (chaines[0].contentEquals("retrait")) {
					int valeur = Integer.parseInt(chaines[1]);

					System.out.println(" valeur demandee  " + valeur);

					int valeurRetrait = monServeur.getBanqueCentrale().demandeRetrait(valeur);

					String valeurExpediee = "" + valeurRetrait;
					System.out.println(" Retrait dans serveur " + valeurExpediee);

					os.println(valeurExpediee);

					System.out.println(monServeur);
				}
				if (chaines[0].contentEquals("depot")) {
					int valeur = Integer.parseInt(chaines[1]);

					System.out.println(" valeur demandee  " + valeur);

					int valeurDepot = monServeur.getBanqueCentrale().demandeDepot(valeur);

					String valeurExpediee = "" + valeurDepot;
					System.out.println(" Depot dans serveur " + valeurExpediee);

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
