package mp.texas;

import mp.texas.push.PushService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class BeitretenActivity extends Activity {
	Button beitretenbutton;
	TextView anzahlspieler;
	TextView startkapital;
	TextView blindserhohennach;
	TextView bigBlind;
	TextView computergegner;
	TextView human;
	public static Spinner spielwahl;
	public static ArrayAdapter<String> spinnerAdapter;
	
	public static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	super.handleMessage(msg);
        	String text = (String)msg.obj;
        	spinnerAdapter.add(text);
        	spinnerAdapter.notifyDataSetChanged();
        }
       
	};
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.beitreten);

		
	PushService.actionLaden(getApplicationContext());
		
	spielwahl=(Spinner)findViewById(R.id.spinnerBeitretenSpiele);
	 
	spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1); 
	spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	spielwahl.setAdapter(spinnerAdapter); 
	spinnerAdapter.add("Spiele werden geladen"); 
	
	
	spielwahl.setOnItemSelectedListener(new OnItemSelectedListener() 
	{

		public void onItemSelected(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			Log.d("Modus","gew�hlt");

			if(arg2 == 0){
				beitretenbutton.setEnabled(false);	
			}
			else 
			{
//				Log.d("beitretenActivity0", Integer.toString(arg2));
				beitretenbutton.setEnabled(true);
//				Log.d("beitretenActivity", Integer.toString(App.offeneSpiele.size()));
				App.aktuellesSpielID = App.offeneSpiele.get(arg2-1).getName();
				Log.d("beitretenActivity2", App.getAktuellesSpielID());
				draw(arg2);
			}
			
			
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			Log.d("Modus", "Nichts gew�hlt");
			// TODO Auto-generated method stub
			//draw();
		}             
 
	});
	anzahlspieler=(TextView) findViewById(R.id.BeitretenAnzahlSpieler);
	computergegner=(TextView) findViewById(R.id.BeitretenComputergegner);
	bigBlind=(TextView) findViewById(R.id.BeitretenBigBlind);
	blindserhohennach=(TextView) findViewById(R.id.BeitretenBlindsNach);
	startkapital=(TextView) findViewById(R.id.BeitretenStartkapital);
	
	
	beitretenbutton = (Button) findViewById(R.id.button1);		        			
		beitretenbutton.setOnClickListener(new OnClickListener() {		    				
			public void onClick(View v) 		        								
			{		        															
				startActivity(new Intent(getApplicationContext(),SpielActivity.class));
			
				// Die AUswahl im Spinner muss hier noch mitimplimentiert werden
				// Danach muss 			
				// ClientPokerspielService.actionBeitreten(getApplicationContext())
				// an das dazugeh�rige SPiel (ID) geschickt werden;  //test		
				
				PushService.actionUnsubscribe(getApplicationContext()); //um sich wieder von den Themen abzumelden
				ClientPokerspielService.actionSpielBeitreten(getApplicationContext());
			}		        															
		}); 		
	 }
	 
	
	 private void draw(int arg)
	 {
		 startkapital.setText(String.valueOf(App.offeneSpiele.get(arg-1).getStartkapital()));
		 anzahlspieler.setText(String.valueOf(App.offeneSpiele.get(arg-1).getAlleSpieler().size()));
		 computergegner.setText(String.valueOf(App.offeneSpiele.get(arg-1).getComputergegnerLevel()));
		 bigBlind.setText(String.valueOf(App.offeneSpiele.get(arg-1).getBlindBetrag()));
		 blindserhohennach.setText(String.valueOf(App.offeneSpiele.get(arg-1).getBlindZeitRundenWert()));
	 }
	 
	private Pokerspiel SpieleLaden()
	{
		
		return null;
	}

	
}
