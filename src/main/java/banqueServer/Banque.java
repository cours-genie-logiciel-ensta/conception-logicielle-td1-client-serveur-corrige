package banqueServer;

import java.beans.PropertyChangeSupport;

public class Banque implements IBanque {

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc -->
	 */
	private CompteBancaire leCompte;

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc -->
	 */
	private String typeOperation; // ## attribute typeOperation

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc -->
	 */
	private int derniereoperation; // ## attribute derniereoperation

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc -->
	 */
	public ServeurTCP serveurBanque; // ## link serveurBanque

	/**
	 * Support for Observable/Observer scheme
	 */
	private PropertyChangeSupport pcSupport;

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param uneSomme * @param x * @param y * @generated
	 * "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param uneSomme
	 * @param x
	 * @param y
	 */
	public Banque(int uneSomme) {

		pcSupport = new PropertyChangeSupport(this);

		leCompte = new CompteBancaire(uneSomme);
		this.setTypeOperation("Aucune Operation");

		serveurBanque = new ServeurTCP(6666);
		serveurBanque.setBanqueCentrale(this);
	}

	public PropertyChangeSupport getPropertyChangeSupport() {
		return pcSupport;
	}

	@Override
	public int getDerniereOperation() {
		return derniereoperation;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @return
	 */
	public CompteBancaire getLeCompte() {
		return leCompte;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @return * @generated "UML vers Java
	 * (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getTypeOperation() {
		return typeOperation;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param operation * @return * @generated "UML vers
	 * Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 * 
	 * @param operation
	 */

	@Override
	public synchronized int demandeRetrait(int unRetrait) {
		int valeurRetiree;

		String dernierTypeOperation = typeOperation;
		int valeurInitiale = leCompte.getSomme();

		if (leCompte.getSomme() - unRetrait > 0) {
			leCompte.setSomme(leCompte.getSomme() - unRetrait);
			valeurRetiree = unRetrait;
		} else {
			valeurRetiree = unRetrait - leCompte.getSomme();
			leCompte.setSomme(0);
		}
		typeOperation = "Retrait";

		pcSupport.firePropertyChange("somme", valeurInitiale, leCompte.getSomme());
		pcSupport.firePropertyChange("typeOperation", dernierTypeOperation, typeOperation);

		return valeurRetiree;
	}

	@Override
	public synchronized int demandeDepot(int unDepot) {

		String dernierTypeOperation = typeOperation;
		int valeurInitiale = leCompte.getSomme();

		leCompte.setSomme(unDepot);
		typeOperation = "Depot";

		pcSupport.firePropertyChange("somme", valeurInitiale, leCompte.getSomme());
		pcSupport.firePropertyChange("typeOperation", dernierTypeOperation, typeOperation);

		return unDepot;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc -->
	 */
	public void ouvrirBanque() {
		serveurBanque.go();
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @param typeOperation
	 * 
	 * @param typeOperation
	 */
	@Override
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	/**
	 * 
	 * 
	 * * <!-- end-UML-doc --> * @return
	 */
	@Override
	public String toString() {
		return "La Banque possede un compte avec la somme de " + leCompte.getSomme();
	}

}
