package banqueServer;

/**
 * 
 * * <!-- begin-UML-doc --> * <!-- end-UML-doc --> * @author Root * @generated
 * "UML vers Java
 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class MainServeur {

	/**
	 * 
	 * 
	 * * @param&nbsp;args * <!-- end-UML-doc --> * @param args * @generated "UML
	 * vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Banque MAGICBANQUE = new Banque(10000, new DemandeRetraitSimple(),
		// new DemandeDepotSimple());
		Banque MAGICBANQUE = new Banque(10000);
		/* MontantBanqueGUI MonGUI = */ new MontantBanqueGUI(MAGICBANQUE);
		/* DerniereOperationGUI OperGUI = */ new DerniereOperationGUI(MAGICBANQUE);
		System.out.println(MAGICBANQUE);
		MAGICBANQUE.ouvrirBanque();
	}

}
