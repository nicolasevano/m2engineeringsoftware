package lattitude;

import javax.ejb.Remote;


@Remote
public interface PublishPositionService {

	public abstract MaPosition publishPosition(int x, int y, int z);

}