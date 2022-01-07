
package banqueServer;


public interface IBanque {
    
    
	public int demandeDepot(int unDepot);
    
	public int demandeRetrait(int unRetrait);
    
    public int getDerniereOperation();
        
    public void setTypeOperation(String typeOperation);
    
}
