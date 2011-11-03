package lattitude;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(mappedName="publishPositionBean")
public class PublishPositionBean implements PublishPositionService {


	
	@PersistenceContext EntityManager em;
	
	@Override
	public MaPosition publishPosition( int x, int y, int z ){
		
		System.err.println( "x = " + x + ",y = " + y + ",z = " + z );
		MaPosition p = new MaPosition(x,y,z);
		em.persist( p );
		return p;
		
	} 
	
}
