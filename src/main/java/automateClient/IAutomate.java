
package automateClient;



/**
 * 
 * * <!-- begin-UML-doc -->
 * * <!-- end-UML-doc -->
 * * @author Root
 * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface IAutomate {
    
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @return
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    boolean connexionBanque();
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
    */
    void deconnexionBanque();
    
    /**
     * 
     * 
     * * <!-- end-UML-doc -->
     * * @param unRetrait
     * * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     * @param unRetrait
    */
    void retrait(int unRetrait);
    
}

