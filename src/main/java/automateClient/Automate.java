package automateClient;

import java.beans.PropertyChangeSupport;

//----------------------------------------------------------------------------
// BanqueStrategie/Automate.java                                                                  
//----------------------------------------------------------------------------

//## package BanqueStrategie 

/**
 * 
 * * <!-- begin-UML-doc --> * <!-- end-UML-doc --> * @author Root * @generated
 * "UML vers Java
 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Automate implements IAutomate {

	/**
	 * 
	 * 
	 * * @param&nbsp;args * <!-- end-UML-doc --> * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int sommePoche; // ## attribute sommePoche

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ClientTCP monClientTCP; // ## link monClientTCP

	/**
	 * Support for Observable/Observer scheme
	 */
	private PropertyChangeSupport pcSupport;

	// Constructors

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param unClient * @param sommenpoche * @generated
	 * "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param unClient
	 * @param sommenpoche
	 */
	public Automate(ClientTCP unClient, int sommenpoche) {

		pcSupport = new PropertyChangeSupport(this);

		sommePoche = sommenpoche;
		// sommePoche=0;
		monClientTCP = unClient;

	}

	public PropertyChangeSupport getPropertyChangeSupport() {
		return pcSupport;
	}

	@Override
	public boolean connexionBanque() {
		return monClientTCP.connexionServeur();
	}

	@Override
	public void deconnexionBanque() {
		monClientTCP.deconnexionServeur();
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param laSomme * @return * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param laSomme
	 */
	public int demandeDepot(int laSomme) {

		int derniereSommePoche = getSommePoche();
		int valeurCompte = 0;
		String valeurRetour = monClientTCP.transmettreChaine("depot " + laSomme);
		valeurCompte = Integer.parseInt(valeurRetour);
		retrait(laSomme);
		// depot(valeurCompte);

		pcSupport.firePropertyChange("sommePoche", derniereSommePoche, getSommePoche());

		return valeurCompte;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param laSomme * @return * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param laSomme
	 */
	public int demandeRetrait(int laSomme) {

		int derniereSommePoche = getSommePoche();
		int valeurRetrait = 0;
		String valeurRetour = monClientTCP.transmettreChaine("retrait " + laSomme);
		valeurRetrait = Integer.parseInt(valeurRetour);
		depot(valeurRetrait);
		// retrait(valeurRetrait);

		pcSupport.firePropertyChange("sommePoche", derniereSommePoche, getSommePoche());

		return valeurRetrait;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param unDepot * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param unDepot
	 */
	public void depot(int unDepot) {
		sommePoche += unDepot;

		System.out.println("Somme en poche finale " + sommePoche);
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @return * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getSommePoche() {
		return sommePoche;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param unRetrait * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param unRetrait
	 */
	@Override
	public void retrait(int unRetrait) {
		sommePoche -= unRetrait;
		System.out.println("Somme en poche finale " + sommePoche);
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param sommePoche * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param sommePoche
	 */
	public void setSommePoche(int sommePoche) {
		this.sommePoche = sommePoche;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @return * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public String toString() {
		return "Somme en poche : " + sommePoche;
	}

}
