package lattitude;

import javax.ejb.Remote;

@Remote
public interface PublishHistoriqueService {
	public abstract Historique publishHistorique(User user, MaPosition position);
}
