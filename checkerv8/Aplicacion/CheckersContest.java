package Aplicacion;

import java.util.*;
import java.lang.Math;

/**
 * Simulates and solves problem c Checks Post Facto
 *
 * @author Alayón Molina
 * @author Castro Ortega
 * @version 1.0
 */
public class CheckersContest
{
    // instance variables - replace the example below with your own

    private static Checkers partida;
    private Checkers partida2;

    /**
     * Constructor for objects of class CheckersContest
     */
    public CheckersContest()
    {
        // initialise instance variables
        partida = new Checkers(8);
        partida2 = new Checkers(8);
        
    }

    /**
     * Solves the problem with input
     * @param player which player makes the first move 
     * @param moves list of the moves 
     * @return solution the result of execution
     */
    public String[] solve(char player, String[] moves)
    {
        ArrayList<Integer> disp = new ArrayList<Integer>();
        String[] resultado = new String[2];
        boolean color; 
        HashMap<Integer,ArrayList<Integer>> guiones = new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> equis = new HashMap<Integer,ArrayList<Integer>>();
        if(player == 'W'){
            color = true;
        } else {
            color = false;
        }
        for(int s = 0; s < moves.length; s++){
            String numeros = "";
            ArrayList<Character> caract1 = new ArrayList<Character>();
            ArrayList<Integer> new1 = new ArrayList<Integer>();
            
            for(int m=0; m < moves[s].length(); m++){
                if(moves[s].charAt(m) != 'x' && moves[s].charAt(m) != '-'){
                    numeros += moves[s].charAt(m);
                } else {
                    int num = Integer.parseInt(numeros);
                    caract1.add(moves[s].charAt(m));
                    new1.add(num);
                    numeros = "";
                 }
            }
            int num = Integer.parseInt(numeros); 
            new1.add(num);
            if(caract1.get(0) == '-'){
                 int numero = new1.get(0);
                 int[][] env = partida.calculatePos(numero);
                 partida.add(color, env[0][0], env[0][1],"Predeterminada");
                 disp.add(new1.get(1));
                 guiones.put(s,new1);
                 
            } else {
                equis.put(s,new1);
                for(int i = 0; i<new1.size();i++){
                    
                    if(i==0){
                        int[][] pos = partida.calculatePos(new1.get(0));
                        partida.add(color, pos[0][0], pos[0][1],"Predeterminada");
                    } else {
                        int prePos = partida.calculatesPos2(disp, new1.get(i-1), new1.get(i));
                        if(prePos != 0){
                            partida.add(!color, partida.calculatePos(prePos),"Predeterminada");
                            disp.add(new1.get(i));
                            
                        }
                        
                    }
                }
            }
            color = !color;
        }
        resultado[0] = partida.write();
        partida2.makeInvisible();
        partida2.read(resultado[0]);
        partida2.swap();
        for(Integer key: guiones.keySet()){
            int[][] posi = partida2.calculatePos(guiones.get(key).get(0));
            partida2.select(posi[0][0],posi[0][1]);
            boolean[] listBool = partida2.calculateShift(guiones.get(key));
            partida2.shift(listBool[0],listBool[1]);
        }
        for(Integer key: equis.keySet()){
            int[][] posi = partida2.calculatePos(equis.get(key).get(0));
            boolean[] listBool = partida2.calculateJump(equis.get(key));
            partida2.select(posi[0][0],posi[0][1]);
            partida2.jump(listBool[0],listBool[1]);
            for(int i=0; i<equis.get(key).size();i++){
                if((equis.get(key).get(i)>28 || equis.get(key).get(i)<5) && i<equis.get(key).size()-1){
                    int[][] posi2 = partida2.calculatePos(equis.get(key).get(i));
                    ArrayList<Integer> variable = new ArrayList<Integer>();
                    variable.add(equis.get(key).get(i)); 
                    variable.add(equis.get(key).get(i+1));
                    boolean[] listJump =  partida2.calculateJump(variable);
                    partida2.jump(listJump[0],listJump[1]);
                }
            }
        }
        partida2.swap();
        resultado[1] = partida2.write();
        partida.makeInvisible();
        partida2.makeInvisible();
        return resultado;
    }
    public void simulate(char player, String[] moves, boolean slow){
        
        partida2.makeVisible();
        solve(player, moves);
        partida2.makeVisible();
    
    }
}
