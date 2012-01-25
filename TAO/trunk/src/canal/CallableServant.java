package canal;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;

import sensor.EntryVersion;



public interface CallableServant extends Callable<EntryVersion> {
	
	public void update(Canal epoqueCP);
	
	public ScheduledFuture<EntryVersion> getValue();
	
	public void setCanal(Canal canal);
	
	//public void setServant(ScheduledFuture<Integer> f1);
}
