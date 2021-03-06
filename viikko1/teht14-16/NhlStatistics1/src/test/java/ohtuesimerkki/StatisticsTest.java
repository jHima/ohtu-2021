package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    
    @Test
	public void etsiPelaaja() {
    	
    	Player uusi = stats.search("Kurri");
    	String nimi = uusi.getName();

		// Pelaaja löytyy
		assertEquals(nimi, "Kurri");
	}
    
    @Test
	public void etsiPuuttuvaPelaaja() {
    	
    	Player uusi = stats.search("Joku");

		// Pelaajae ei löydy
		assertEquals(uusi, null);
	}
    
    @Test
	public void etsiJoukkue() {
    	int luku = stats.team("EDM").size();

		// Joukkue löytyy
		assertEquals(3, luku);
	}
    
    @Test
	public void etsiParas() {

    	int luku = stats.topScorers(2).size();

		// Joukkue löytyy
		assertEquals(3, luku);
	}
    
    
    
    
}
