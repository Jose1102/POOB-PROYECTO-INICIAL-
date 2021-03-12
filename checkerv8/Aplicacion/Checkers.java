package Aplicacion;

import Presentacion.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * A class that creates a simulation of the checkers game.
 *
 * @author Alayón Molina 
 * @author Castro Ortega
 * @version 2.0 (15/02/2020)
 */
public class Checkers
{
    public static int conta;
    private Board tablero;
    

    private boolean estado;
    public static boolean op;

    /**
     * Calls the class Board and Fichas, for create a board with its tokens.
     * 
     * @param width size of the board.
     */
    public Checkers(int width)
    {
        Rectangle fondo = new Rectangle();
        fondo.changeSize(800,800);
        fondo.changeColor("gray");
        fondo.makeVisible();
        tablero = new Board(width, 0, 0);
       
        
        this.conta = width;
    }
   
    /**
     * Make visible the board and tokens, If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        tablero.makeVisible();

    
    }
    /**
     * Make invisible the board and tokens, If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        tablero.makeInvisible();
 
        
    
        op = true;
    }
    /**
     * Calls to class Fichas to add tokens on the board.
     *
     * @param color the color of the tokens, True = white, False = red.
     * @param men the positions of the tokens in the board, initialized in 1 (row, column).
     */
    public void add(boolean color, int[][] men, String tipo)
    {
        tablero.adicionar(color,men,conta);
    }
    /**
     * Calls to class Fichas to add a king token on the board.
     *
     * @param King the color of the token, True = white, False = red.
     * @param row row where the king token will be put.
     * @param column column where the king token will be put.
     */
    public void add(boolean King, int row, int column, String tipo)
    {
        if(tipo.equals("Predeterminada")){
            tablero.addKing(King, row, column, conta);
        
        }else if(tipo.equals("Proletarian")){
            tablero.addProletario(King,  row,  column,  conta);
        
        }else if(tipo.equals("Hurried")){
            tablero.addHurried(King,  row,  column,  conta);
        
        }else if(tipo.equals("Powerful")){
            tablero.addPowerful(King,  row,  column,  conta);
        
        }else if(tipo.equals("Traidora")){
            tablero.addTraidora(King,  row,  column,  conta);
        
        }else if(tipo.equals("Lazy")){
            tablero.addLazy(King,  row,  column,  conta);
        
        }else if(tipo.equals("Libertarian")){
            tablero.addLibertarian(King,  row,  column,  conta);
        
        }

    }

    /**
     * Calls to class Fichas to select a token to move.
     *
     * @param row  row in where is found the token to move.
     * @param column column in where is found the token to move.
     */
    public void select(int row, int column)
    {
        Circle circul1 = new Circle();
        tablero.seleccionarFicha(row,column);
    }
    
    /**
     * Calls to class Fichas to remove a token
     * 
     * @param row row in where is found the token to remove.
     * @param column column in where is found the token to remove.
     */
    public void remover(int row, int column)
    {
        tablero.remover(row,column);
    
    }
    
    /**
     * Calls to class Fichas to remove tokens
     * 
     * @param pieces positions of the tokens to remove.
     */
    public void remover(int[][] pieces)
    {
        tablero.remover(pieces);
        
    }

    /**
     * Calls to class Fichas to swap the game board with the configuration board.
     */
    public void swap() 
    {
        tablero.swap();
    }
    /**
     * Checks that the last operation was correct.
     * @return  If the last operation was correct then true, else ,false.
     */
    public boolean ok(){
        return op;
    
    }
    /**
     * Calls to class Fichas to consult the position of the tokens. 
     * @return  the position of the tokens on a list.
     */
    public int[][][] consult(){
        return tablero.consultar();
    }
    /**
     * Calls to class Fichas to move a selected token
     * 
     * @param top vertical control of the token. 
     * @param right horizontal control of the token.
     */
    public void shift(boolean top, boolean right)
    {
        tablero.shift(top,right);
    }
    
    /**
     * Calls to class Fichas to jump tokens with a selected token.
     * 
     * @param top vertical control of the token.
     * @param right horizontal control of the token.
     */
    public void jump(boolean top, boolean right)
    {
        tablero.jump(top,right);
    }
    /**
     * Finish the execution.
     */
    public void finish(){
        System.exit(0);
    }
    /**
    * Calls to class Fichas to save the configuration board in a string
    * 
    * @return ent the string of the configuration board
    */
    public String write()
    {
    
        return tablero.write();
    }
    /**
    * Calls to class Fichas to save the configuration board in a HashMap
    * 
    * @param name the name of the key in HashMap
    */
    public void save(String name){
        tablero.save(name);
    }
    /**
    * Calls to class Fichas to read a String and draws it on the configuration board.
    * 
    * @param checherboard a string with a saved board
    */
    public void read(String checherboard){
        tablero.read(checherboard);
    }
    /**
    * Calls to class Fichas to recover a configuration board saved in a HashMap
    * 
    * @param name the name of hey in HashMap
    * @return c the string of a configuration board
    */
    public String recover(String name){
        return tablero.recover(name);
    }
    /**
     * Calls to class Board and return getTabEstado of the Matriz tabEstado
     * @param fila the number of the row
     * @param columna the number of the column
     * @return getTabEstado
     */
    public boolean getTabEstado(int fila, int columna){
        return tablero.getTabEstado(fila,columna);
    }
    
    /**
     * Calls to class Board and return getTabEstado of the Matriz tabEstado2
     * @param fila the number of the row
     * @param columna the number of the column
     * @return getTabEstado2
     */
    public boolean getTabEstado2(int fila, int columna){
        return tablero.getTabEstado2(fila,columna);
    }
    /**
     * Calls to class Board and return color of the Matriz tabEstado2
     * @param fila the number of the row
     * @param columna the number of the column
     * @return getTabEstado2
     */
    public String getColorFicha(){
        return tablero.getColorFicha();
    }
    /**
     * Calculates the row and column from a single number
     * @param calc A single number
     * @return env A list with the row and column
     */
    public int[][] calculatePos(int calc){
        return tablero.calculatePos(calc);
    }
    /**
     * Determinate the necesary token for a movement
     * @param disp the positions that going be occupy
     * @param n1 position 1 of the movement
     * @paran n2 position 2 of the movement
     * @return num the position of the necesary token for a movement
     */
    public int calculatesPos2(ArrayList<Integer> disp, int n1, int n2){
        return tablero.calculatesPos2(disp, n1, n2);
    }
    /**
     * calls the class Board calculateShift2 
     * @param n is a ArrayList of Integer
     * @return valorShift of the method calculateShift2
     */
    public boolean[] calculateShift(ArrayList<Integer> n){
        return tablero.calculateShift2(n);
    
    }
    
    public boolean[] calculateJump(ArrayList<Integer> n){
        return tablero.calculateJump2(n);
    
    }
    public void removerGame(int row, int column){
        tablero.removerGame(row, column);
    }
    
}
