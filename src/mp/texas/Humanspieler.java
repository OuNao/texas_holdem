/*
 * Klasse f�r menschliche Spieler, im wesentlichen wichtig f�r die Interaktivit�t
 * die Funktion setzen, fordert zur Eingabe heraus
 */
package mp.texas;

import android.util.Log;

public class Humanspieler extends Spieler {
	public Humanspieler(int startkapital)
	{
		profil=new Profil(App.selbst.getProfil().getName(),App.selbst.getProfil().getAvatar());
		chips=startkapital;
	}
	
	public int setzen(Pokerspiel pokerspiel)
	{
	
		
		return 200;
	}

	@Override
	public void gameover() {
		Log.d("GameOver","Human Player");
		super.gameover();
	}
	
	

}
