package canal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import client.Screen;
import client.ScreenImpl;
import sensor.AtomicForwarding;
import sensor.EpoqueForwarding;
import sensor.Sensor;
import sensor.Subject;
import sensor.SensorImpl;

/**
 * Create the canals for local and distant screen. 
 *
 */
public class Main {
	public static void main(String...args){
		
		int i = 0;
		//Sensor sensor1 = new SensorImpl( new EpoqueForwarding()/*AtomicForwarding()*/ );
		//System.out.println("Sensor created");
		//Screen screen11 = new ScreenImpl( 1 );
		//Screen screen12 = new ScreenImpl( 2 );
		//Screen screen13 = new ScreenImpl( 3 );
		//System.out.println("Screen one and Two created");
		//Canal canal1 = new CanalImpl( sensor1, 100);
		//System.out.println("canal created");
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext( "TAOActiveObject.xml" );
		Sensor sensor1 = ( Sensor ) beanFactory.getBean( "sensor1" );
		( ( Subject ) sensor1 ).attach( ( SensorServiceObserver ) beanFactory.getBean( "canal1" ) );
		( ( Subject ) sensor1 ).attach( ( SensorServiceObserver ) beanFactory.getBean( "canal2" ) );
		//System.out.println( "canal attach to sensor" );
		//canal1.attach( screen11 );
		//System.out.println( "Screen1 attach to canal" );
		//canal1.attach( screen12 );
		//System.out.println( "Screen2 attach to canal" );
		//canal1.attach( screen13 );
		//System.out.println( "Screen3 attach to canal" );
		
		while( i < 30 ){
			
			i++;
			sensor1.setValue( i );
			System.out.println("send event sensor updated");
			sensor1.tick();
			try {
				Thread.sleep( 1000 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Sensor value updated.");
			
		}
		
	}
}
