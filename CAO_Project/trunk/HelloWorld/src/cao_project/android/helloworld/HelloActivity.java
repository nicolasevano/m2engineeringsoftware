package cao_project.android.helloworld;
import android.app.Activity; 
import android.os.Bundle; 
import android.widget.TextView; 
/************************************************
*HelloActivity class definition
************************************************/

public class HelloActivity extends android.app.Activity{

	@Override
	public void onCreate( Bundle savedInstanceState ){
		//TODO auto generated method
		super.onCreate(savedInstanceState);
		setContentView( R.layout.HelloActivity );
	}
}
