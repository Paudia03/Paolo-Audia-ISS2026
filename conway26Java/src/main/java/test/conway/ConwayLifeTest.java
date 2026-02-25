package conway;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import conway.domain.Life;
import conway.domain.LifeInterface;

import static org.junit.Assert.*;

public class ConwayLifeTest {

    @Before
    public void setup() {
        System.out.println("setup"); 
    }

    @After
    public void down() {
        System.out.println("down");
    }

    @Test
    public void testOscilla() {
        System.out.println("testOscilla ---------");
        LifeInterface liferules = new Life(5, 5); // Segnerà ERRORE ROSSO: è normale!
        
        liferules.setCell(2, 1, true);
        liferules.setCell(2, 2, true);
        liferules.setCell(2, 3, true);
        System.out.println("testOscilla | Stato Iniziale:\n" + liferules.gridRep());

        liferules.nextGeneration();
        System.out.println("testOscilla | after 1 gen:\n" + liferules.gridRep());
        
        assertTrue(liferules.isAlive(1, 2));
        assertTrue(liferules.isAlive(2, 2));
        assertTrue(liferules.isAlive(3, 2));
    }
}