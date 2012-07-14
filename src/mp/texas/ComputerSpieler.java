/*
 * Enth�lt alle wichtigen Funktionen f�r COMPUTERGEGNER, insbesondere
 * die k�nstliche Intelligenz zum setzen
 */
package mp.texas;

import java.security.PublicKey;

import android.util.Log;




public class ComputerSpieler extends Spieler 
{
	private int intelligenz;

	
	//Konstruktor wenn Profil des Gegners bekannt ist
	public ComputerSpieler(Profil profilarg, int chipsarg, int intelligenz) 
	{
		super(profilarg, chipsarg);
		this.intelligenz=intelligenz;
	}

	//Konstruktor der das Profil noch erstellt
	public ComputerSpieler(int computerlevel, int chipsarg, int id) {
		// TODO Auto-generated constructor stub
		super(new Profil(id), chipsarg);
		intelligenz=computerlevel;
	}

	
	
	public int setzen(Pokerspiel pokerspiel)
	{
		Log.d(profil.getName(),"dran");
		return 150;
	}

	
	
	
}
