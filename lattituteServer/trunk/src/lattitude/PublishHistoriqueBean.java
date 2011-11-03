package lattitude;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless( mappedName="publishHistoriqueBean" )
public class PublishHistoriqueBean implements PublishHistoriqueService{

	@PersistenceContext EntityManager em;
	
	@Override
	public Historique publishHistorique( User user, MaPosition position ) {
		
		System.err.println( "user " + 
						    user.getName() + 
						    " add position in historique: x = " + 
						    position.x + 
						    "y = " + 
						    position.y + 
						    "z = " + position.z );
		Historique h = new Historique( user, position );
		
		em.persist( h );
		return h;
	}

}
