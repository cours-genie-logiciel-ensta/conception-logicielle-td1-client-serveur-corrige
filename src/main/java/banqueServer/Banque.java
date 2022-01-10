package banqueServer;

import java.beans.PropertyChangeSupport;

/**
 * Représente une banque gérant un compte bancaire particulier
 *
 */
public class Banque implements IBanque {

	// Le compte bancaire géré
	private CompteBancaire leCompte;

	private String typeOperation;
	private int derniereoperation;

	public ServeurTCP serveurBanque;

	/**
	 * Support du mécanisme Observable/Observer
	 */
	private PropertyChangeSupport pcSupport;

	/**
	 * Création de l'objet Banque: crée le compte bancaire avec la somme initiale
	 * 
	 * @param uneSomme
	 */
	public Banque(int uneSomme) {

		pcSupport = new PropertyChangeSupport(this);

		// Creation du compte bancaire
		leCompte = new CompteBancaire(uneSomme);
		this.setTypeOperation("Aucune Operation");

		// Initialisation du serveur TCP
		serveurBanque = new ServeurTCP(6666);
		serveurBanque.setBanque(this);
	}

	public PropertyChangeSupport getPropertyChangeSupport() {
		return pcSupport;
	}

	@Override
	public int getDerniereOperation() {
		return derniereoperation;
	}

	public CompteBancaire getLeCompte() {
		return leCompte;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

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

		leCompte.setSomme(leCompte.getSomme() + unDepot);
		typeOperation = "Depot";

		pcSupport.firePropertyChange("somme", valeurInitiale, leCompte.getSomme());
		pcSupport.firePropertyChange("typeOperation", dernierTypeOperation, typeOperation);

		return unDepot;
	}

	public void ouvrirBanque() {
		serveurBanque.go();
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	@Override
	public String toString() {
		return "La Banque possede un compte avec la somme de " + leCompte.getSomme();
	}

}
