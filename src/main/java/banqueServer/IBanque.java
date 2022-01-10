
package banqueServer;

/**
 * API représentant la banque gérant un compte bancaire
 *
 */
public interface IBanque {

	public int demandeDepot(int unDepot);

	public int demandeRetrait(int unRetrait);

	public int getDerniereOperation();

}
