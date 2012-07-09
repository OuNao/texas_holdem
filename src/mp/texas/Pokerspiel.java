package mp.texas;

import java.util.ArrayList;

import android.util.Log;

public class Pokerspiel 
{
	private String name;
	private int startkapital;  // wird vorl�ufig zur �bergabe aus SPielEInstellungenAct. gebraucht
	private int pot;
	private Blatt blatt;
	private final int Runden=1; //??
	private final int Zeit=2; //??
	private int blindZeitRundenWert;
	private String blindModus;
	private int blindBetrag;
	private Spieler aktiverSpieler;
	private ArrayList<Spieler> alleSpieler = new ArrayList<Spieler>();
	private Spieler lastRaise;
	private int einsatz;
	private Spieler smallBlindSpieler;
	
	public Pokerspiel(){
		//leere Konstruktor zur Spieler�ffnung
	}
	
	public Pokerspiel(int startkapitalarg, int blindZeitRundenWertarg, String blindModusarg, int blindBetragarg){
		this.startkapital=startkapitalarg;
		this.blindBetrag=blindBetragarg;
		this.blindZeitRundenWert=blindZeitRundenWertarg;
		this.blindModus=blindModusarg;
	}
	
	public Pokerspiel(ArrayList<Spieler> alleSpieler, int Startkapital, String blindModus, int blindZeitRundenWert, int blindBetrag)
	{
		this.setAlleSpieler(alleSpieler);
		this.blindModus=blindModus;
		this.blindBetrag=blindBetrag;
		this.blindZeitRundenWert=blindZeitRundenWert;
		
		for (Spieler n: alleSpieler)
		{
			n.setChips(Startkapital);
		}
		//alleSpieler=(ArrayList<Spieler>) spielerMischen(alleSpieler);
		//smallBlindSpieler=alleSpieler.get(0);
		//aktiverSpieler=alleSpieler.get(0);
	}
	
	public void austeilen()
	{
		blindWeitergeben();
		blatt.blattMischen(blatt.getKarten());
		for(Spieler n:getAlleSpieler())
		{
			n.setHand(blatt.handGeben());
		}
		blindsEinzahlen();
	}
	
	
	////////////////////////////////////////////////////////////////////////////
	///////////////////////////BLINDS VERWALTEN/////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	public void blindsEinzahlen()
	{
		
	}
	
	public void blindWeitergeben()
	{
		
	}
	
	///////////////////////////////////////////////////////////////////////////
	/////////////////////////Bietrunden////////////////////////////////////////
	private void Preflop()
	{
		//Bietrunde vor den ersten Gemeinschaftskarten
	}
	
	private void Flop()
	{
		//Bietrunde nach den ersten 3 Karten
	}
	
	private void TurnCard()
	{
		//Bietrunde nach der TurnCard
	}
	
	private void RiverCard()
	{
		//Bietrunde nach der RiverCard
	}
	
	

	
	
	public ArrayList<Spieler> ShowDown()
	{
		
		int[] best={0,0};
		ArrayList<Spieler> aktive=new ArrayList<Spieler>();
		for(Spieler n:getAlleSpieler())
		{
			if(n.isNochDrin())
			{
				aktive.add(n);
			}
			
		}
		
		ArrayList<Spieler> sieger=new ArrayList<Spieler>();
	
		for(Spieler n:aktive)
		{
			int[] temp=RoyalFlush(n.getHand());
			if(temp[0]!=0)
			{
				int besser = intHigher(best, temp);
				if(besser==2)
				{
					sieger.clear();
					sieger.add(n);
				}
				if(besser==3)
				{
					sieger.add(n);
				}
				
			}
		}
		if(sieger.size()>0)
		{return sieger;}
		
		for(Spieler n:aktive)
		{
			if(StraightFlush(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
			
		for(Spieler n:aktive)
		{
			if(Vierling(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
		
		for(Spieler n:aktive)
		{
			if(FullHouse(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
		
		for(Spieler n:aktive)
		{
			if(Flush(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
		
		for(Spieler n:aktive)
		{
			if(Straight(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
		
		for(Spieler n:aktive)
		{
			if(Drilling(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
		
		for(Spieler n:aktive)
		{
			if(ZweiPaar(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
		
		
		for(Spieler n:aktive)
		{
			if(EinPaar(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
		
		for(Spieler n:aktive)
		{
			if(HighCard(n.getHand())!=null);
			{sieger.add(n);}
		}
		if(sieger.size()>0)
		{return sieger;}
		return sieger;
	}
	
	
	//Bewertung der Hand
	
	//1
	private int[] RoyalFlush(Hand hand)
	{
		
		return null; //0 hei�t kein RoyalFlush
					//1 hei�t RoyalFlush
	}
	
	//2
	private int[] StraightFlush(Hand hand)
	{
		return null;	//0 hei�t kein Straight Flush
					//ansonsten gibt die Zahl den Wert der h�chsten Karte an
	}
	
	//3
	private int[] Vierling(Hand hand)
	{
		
		return null;	//0 hei�t kein Vierling
					//ansonsten gibt die Zahl den Wert des Vierlings an
	}
	
	//4
	private int[] FullHouse(Hand hand)
	{
		return null;	//0 hei�t kein Full House
					//ansonsten gibt die Zahl zuerst den Drilling und danach die des Paares
	}
	
	//5
	private int[] Flush(Hand hand)
	{
		return null; //0 ansonsten die Werte absteigend der Karten des Flush
	}
	
	//6
	private int[] Straight(Hand hand)
	{
		return null;	//0 fall nicht, ansonsten wird der Wert der h�chsten Karte zur�ckgegeben
	}
	
	//7
	private int[] Drilling(Hand hand)
	{
		return null;	//0 falls nicht, ansonsten wird der Wert des Drilling zur�ckgegeben
					//sowie der Wert der 4te und 5ten Karte 
	}
	
	//8
	private int[] ZweiPaar(Hand hand)
	{
		return null; //0 falls nicht, ansonsten wird zuerst der Wert des h�chsten Paares und dann der des zweiten Paares zur�ckgegeben
					//sowie die f�nft h�chste Karte
	}
	
	//9
	private int[] EinPaar(Hand hand)
	{
		return null; //0 falls nicht, ansonten der Kartenwert des Paares
					// dritte vierte und f�nfte Karte
	}
	
	//10
	private int[] HighCard(Hand hand)
	{
		return null; //Wert der h�chsten Karten
	}
	
	private int intHigher(int[] int1, int[] int2)
	{
		for(int i=0;i<int2.length;i++)
		{
			if(int1[i]>int2[i])
			{
				return 1;	//int1 ist gr��er
			}
			
			if(int1[i]<int2[i])
			{
				return 2;	//int2 ist gr��er
			}
		}
		return 3;			//beide gleich
	}
	
	public ArrayList<Spieler> spielerMischen(ArrayList<Spieler> liste)
	{
		if(liste.size() == 0)
			return liste;
		else
		{
			for(int i=0;i<1000;i++)
			{
				int rand1=(int)(Math.random()*liste.size());
				int rand2=(int)(Math.random()*liste.size());
				Spieler temp=liste.get(rand1);
				liste.remove(rand1);
				liste.add(rand2, temp);
			}
		}
		return liste;
	}


	public int getStartkapital() {
		return startkapital;
	}

	public void setStartkapital(int startkapital) {
		this.startkapital = startkapital;
	}

	public int getBlindZeitRundenWert() {
		return blindZeitRundenWert;
	}

	public void setBlindZeitRundenWert(int blindZeitRundenWert) {
		this.blindZeitRundenWert = blindZeitRundenWert;
	}

	public String getBlindModus() {
		return blindModus;
	}

	public void setBlindModus(String blindModus) {
		this.blindModus = blindModus;
	}

	public int getBlindBetrag() {
		return blindBetrag;
	}

	public void setBlindBetrag(int blindBetrag) {
		this.blindBetrag = blindBetrag;
	}

	public ArrayList<Spieler> getAlleSpieler() {
		return alleSpieler;
	}

	public void setAlleSpieler(ArrayList<Spieler> alleSpieler) {
		this.alleSpieler = alleSpieler;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
