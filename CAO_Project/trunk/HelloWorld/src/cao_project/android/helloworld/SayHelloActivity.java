package cao_project.android.helloworld;
import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
/************************************************
*SayHelloActivity class definition
************************************************/

public class SayHelloActivity extends android.app.Activity{

	@Override
	public void onCreate( Bundle savedInstanceState ){
		//TODO auto generated method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.SayHelloActivity);
		Button btn = (Button) findViewById(R.id.btn_sayhello);
		btn.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View arg0) {
		Intent i = new Intent( SayHelloActivity.this, HelloActivity.class );
		startActivity( i );
		}
		});
	}
}
