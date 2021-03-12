package Aplicacion;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class CheckersTest.
 *
 * @author Alayon Molina
 * @author Castro Ortega
 * @version 3.0
 */
public class CheckersTest
{
    @Test 


    public void deberiaAdicionarFichasEnElTableroDeConfiguracion(){
        Checkers checkers=new Checkers(5);
        checkers.add(true,1,2,"Predeterminada");
        checkers.add(false,2,3,"Predeterminada");
        assertEquals(checkers.getTabEstado(1,2),true);
        assertEquals(checkers.getTabEstado(2,3),true);
    }
    
    @Test 


    public void deberiaAdicionarFichasEnElTableroDeJuego(){
        Checkers checkers=new Checkers(5);
        checkers.add(true,1,2,"Predeterminada");
        checkers.add(false,2,3,"Predeterminada");
        checkers.swap();
        assertEquals(checkers.getTabEstado2(1,2),true);
        assertEquals(checkers.getTabEstado2(2,3),true);
    }
    @Test
    
    
    public void deberiaEliminarFichasEnConfiguracion(){
        Checkers checkers = new Checkers(8);
        checkers.add(true, 2, 3,"Predeterminada");
        checkers.add(false, 3, 4,"Predeterminada");
        checkers.remover(2,3);
        checkers.remover(3,4);
        assertEquals(checkers.getTabEstado(2,3), false);
        assertEquals(checkers.getTabEstado(3,4), false);
    
    }
    @Test
    
    public void deberiaguardaryrecuperartablero(){
        
        Checkers checkers1 = new Checkers(8);
        checkers1.add(true, 2, 3,"Predeterminada");
        checkers1.add(false, 3, 4,"Predeterminada");
        checkers1.save("esto es una prueba");
        checkers1.remover(2, 3);
        checkers1.remover(3, 4);
        assertEquals("-.-.-.-..-W-.-.--.-B-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-", checkers1.recover("esto es una prueba"));
    }
    @Test
    public void deberiaSaltarCorrectamente(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,6,3,"Predeterminada");
        checkers.add(false,5,4,"Predeterminada");
        checkers.add(false,3,6,"Predeterminada");
        checkers.swap();
        checkers.select(6,3);
        checkers.jump(true,true);
        assertEquals(true, checkers.getTabEstado2(2,7));
        assertEquals(false, checkers.getTabEstado2(5,4));
        assertEquals(false, checkers.getTabEstado2(3,6));
      
    }
    @Test
    public void noDeberianSalirseLasFichas()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.add(true, 2, 3,"Predeterminada");
        checkers1.swap();
        checkers1.select(2, 3);
        checkers1.shift(true, true);
        checkers1.shift(true, true);
        assertEquals(true, checkers1.getTabEstado2(1,4));
    }
    
    @Test
    public void deberiaConsultarLasFichasEnElTableroDeConfiguracion(){
        
        Checkers checkers = new Checkers(8);
        checkers.add(true, 7,2,"Predeterminada");
        int [][][]lista2 = checkers.consult();
        int fila = lista2[1][0][0];
        int columna = lista2[1][0][1];
        assertEquals(7,fila);
        assertEquals(2,columna);
        
    
    }
    @Test
    public void deberiaConsultarLasFichasEnElTableroDeJuego(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,7,2,"Predeterminada");
        checkers.swap();
        int [][][]lista2 = checkers.consult();
        int fila = lista2[0][0][0];
        int columna = lista2[0][0][1];
        assertEquals(7,fila);
        assertEquals(2,columna);
    }
    
    // Pruebas ciclo 4
    
    
    @Test
    public void deberiaProletarianMorirAlSerRey(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,3,6,"Proletarian");
        checkers.add(false,2,7,"Proletarian");
        assertEquals(false, checkers.getTabEstado2(1,8));
        assertEquals(false, checkers.getTabEstado2(2,7));
    }

    @Test
    public void noDeberiaLazySaltarDosVeces(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,6,3,"Lazy");
        checkers.add(false,5,4,"Predeterminada");
        checkers.add(false,3,6,"Predeterminada");
        checkers.swap();
        checkers.select(6,3);
        checkers.jump(true,true);
        assertEquals(true, checkers.getTabEstado2(4,5));
        assertEquals(false, checkers.getTabEstado2(5,4));
        assertEquals(true, checkers.getTabEstado2(3,6));
    }
    @Test
    public void deberiaLazySaltarUnaVez(){
        Checkers checkers = new Checkers(8);
        checkers.add(false,3,6,"Lazy");
        checkers.add(true,4,5,"Predeterminada");
        checkers.swap();
        checkers.select(3,6);
        checkers.jump(false,false);
        assertEquals(true, checkers.getTabEstado2(5,4));
    }
    @Test
    public void noDeberiaLibertarianCapturarFichas(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,6,3,"Libertarian");
        checkers.add(false,5,4,"Predeterminada");
        checkers.add(false,3,6,"Predeterminada");
        checkers.swap();
        checkers.select(6,3);
        checkers.jump(true,true);
        assertEquals(true, checkers.getTabEstado2(5,4));
        assertEquals(true, checkers.getTabEstado2(3,6));
    }
    public void deberiaLibertarianSaltarCorrectamente(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,6,3,"Libertarian");
        checkers.add(false,5,4,"Predeterminada");
        checkers.add(false,3,6,"Predeterminada");
        checkers.swap();
        checkers.select(6,3);
        checkers.jump(true,true);
        assertEquals(true, checkers.getTabEstado2(2,7));
    }
    
    @Test
    public void noDeberiaPowerfulDejarseCapturar(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,6,3,"Predeterminada");
        checkers.add(false,5,4,"Powerful");
        checkers.add(false,3,6,"Powerful");
        checkers.swap();
        checkers.select(6,3);
        checkers.jump(true,true);
        assertEquals(true, checkers.getTabEstado2(5,4));
        assertEquals(true, checkers.getTabEstado2(3,6));
    }
    @Test
    public void deberiaPowerfulCapturarOtrasFichas(){
        Checkers checkers = new Checkers(8);
        checkers.add(false,3,6,"Powerful");
        checkers.add(true,4,5,"Predeterminada");
        checkers.swap();
        checkers.select(3,6);
        checkers.jump(false,false);
        assertEquals(false, checkers.getTabEstado2(4,5));
    }
    @Test
    public void deberiaHurriedSaltarDosVeces(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,4,5,"Hurried");
        checkers.swap();
        checkers.select(4,5);
        checkers.shift(true, true);
        assertEquals(true, checkers.getTabEstado2(2,7));
        
    }
    @Test
    public void noDeberiaHurriedSalirseDelTablero(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,4,5,"Hurried");
        checkers.swap();
        checkers.select(4,5);
        checkers.shift(true, true);
        checkers.shift(true, true);
        assertEquals(true, checkers.getTabEstado2(1,8));
    }
    @Test
    public void deberiaTraidoraCambiarANegro(){
        Checkers checkers = new Checkers(8);
        checkers.add(true,4,5,"Traidora");
        checkers.add(false,3,6,"Predeterminada");
        checkers.swap();
        checkers.select(4,5);
        checkers.jump(true,true);
        assertEquals("red", checkers.getColorFicha());
    }
    @Test
    public void deberiaTraidoraCambiarABlanco(){
        Checkers checkers = new Checkers(8);
        checkers.add(false,3,6,"Traidora");
        checkers.add(true,4,5,"Predeterminada");
        checkers.swap();
        checkers.select(3,6);
        checkers.jump(false,false);
        assertEquals("white", checkers.getColorFicha());
    }
    
}

