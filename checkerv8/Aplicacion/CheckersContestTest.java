
package Aplicacion;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class CheckersContestTest.
 *
 * @author Alayon Molina
 * @author Castro Ortega
 * @version 1.0
 */

public class CheckersContestTest
{
   @Test 
    public void deberiaPrimerTableroSerCorrecto(){
        CheckersContest contest =new CheckersContest();
        String[] envio = new String[3];
        envio[0] = "21-17";
        envio[1] = "13x22x31x24";
        envio[2] = "19x28";
        String[] resultado =  contest.solve('W',envio);
        System.out.println("resultado");
        System.out.println(resultado[0]);
        assertEquals(resultado[0],"-.-.-.-..-.-.-.--.-.-.-.B-.-.-.--.-.-W-.W-.-.-.--.-w-w-..-.-.-.-");
    }
   @Test
   public void deberiaSegundoTableroSerCorrecto(){
       CheckersContest contest =new CheckersContest();
        String[] envio = new String[3];
        envio[0] = "21-17";
        envio[1] = "13x22x31x24";
        envio[2] = "19x28";
        String[] resultado =  contest.solve('W',envio);
        assertEquals(resultado[1],"-.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-W.-.-.-.-");
    }
}
