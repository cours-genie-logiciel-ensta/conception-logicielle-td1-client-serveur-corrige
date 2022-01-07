package banqueServer;

import java.util.*;

public class Banque extends Observable implements IBanque {
    
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
    private String typeOperation;		//## attribute typeOperation 
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
    */
    private int derniereoperation;		//## attribute derniereoperation 
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
    */
    public ServeurTCP serveurBanque;		//## link serveurBanque 
        
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @param uneSomme
     * * @param x
     * * @param y
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     * @param uneSomme
     * @param x
     * @param y
    */
    public  Banque( int uneSomme ) {
		leCompte = new CompteBancaire( uneSomme );
        this.setTypeOperation("Aucune Operation");
        
        serveurBanque = new ServeurTCP(6666);
        serveurBanque.setBanqueCentrale(this);
    }
    
    
    public int getDerniereOperation() {
        return derniereoperation;
    }
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @return
    */
	public CompteBancaire getLeCompte() {
		return leCompte;
	}
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @return
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    public String getTypeOperation() {
        return typeOperation;
    }
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @param operation
     * * @return
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     * @param operation
    */
    
    public synchronized int demandeRetrait(int unRetrait) {        
        int valeurRetiree;
        
        if ( leCompte.getSomme()-unRetrait >0 ) { 	
        	leCompte.setSomme( leCompte.getSomme() - unRetrait);
        	valeurRetiree = unRetrait;
        } else {
        	valeurRetiree=unRetrait-leCompte.getSomme();
        	leCompte.setSomme(0);
        }
        typeOperation = "Retrait";
        this.setChanged();
        this.notifyObservers();
        
        return valeurRetiree;
    }


    public synchronized int demandeDepot(int unDepot) {
		leCompte.setSomme(unDepot);
        typeOperation = "Depot";

        this.setChanged();
        this.notifyObservers();
        
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
     * * <!-- end-UML-doc -->
     * * @param typeOperation
     * @param typeOperation
    */
    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @return
    */
    public String toString() {
        return "La Banque possede un compte avec la somme de " + leCompte.getSomme();
    }
    
}
