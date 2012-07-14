/*
 * Speicherklasse f�r die Gemeinschaftskarten, enth�lt lediglich diese, und kann sie alle zur�ckgeben
 */
package mp.texas;

import java.util.ArrayList;

public class Gemeinschaftskarten 
{
	private Karte karte1;
	private Karte karte2;
	private Karte karte3;
	private Karte karte4;
	private Karte karte5;
	
	
	//Toter Konstruktor
	public Gemeinschaftskarten(Karte karte0, Karte karte1, Karte karte2, Karte karte3, Karte karte4)
	{
		this.karte1=karte0;
		this.karte2=karte1;
		this.karte3=karte2;
		this.karte4=karte3;
		this.karte5=karte4;
	}

	public ArrayList<Karte> getGemeinschaftskarten()
	{
		ArrayList<Karte> temp=new ArrayList<Karte>();
		temp.add(karte1);
		temp.add(karte2);
		temp.add(karte3);
		temp.add(karte4);
		temp.add(karte5);
		return temp;
	}
	
}
