package Aplicacion;



import Presentacion.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Create a Board that can be manipulated and that draws itself on a canvas..
 *
 * @author Alayón Molina
 * @author Castro Ortega
 * @version 1.0 (05/02/2020)
 */
public class Board
{
    // instance variables - replace the example below with your own
    private int x;
    private Rectangle black;
    private Rectangle white;
    private Rectangle black2;
    private Rectangle white2;
    private static int conta;
    private int filas;
    public ArrayList<Rectangle> tablero = new ArrayList<Rectangle>();
    public ArrayList<Rectangle> tablero2 = new ArrayList<Rectangle>();
    private int fila;
    private int columna;
    public ArrayList<Dama> damas = new ArrayList<Dama>();
    public ArrayList<Dama> damas2 = new ArrayList<Dama>();
    public boolean tabEstado[][][]={};
    public boolean tabEstado2[][][]={};
    private int elect;
    private String electColor;
    private HashMap<String, String> saveMap = new HashMap<String, String>();
    protected int width;
    protected int moveX;
    protected int moveY;
    /**
     * Create a Board with given parameters.
     * @param width desired size for the Board. 
     * @param moveX Xposition of the Board.
     * @param moveX Yposition of the Board.
     */
    public Board(int width, int moveX, int moveY)
    {
        this.width = width;
        this.moveX = moveX;
        this.moveY = moveY;
        white = new Rectangle();
        white.changeSize(width*30, width* 30);
        white.moveP(moveX, moveY);
        white.changeColor("white");
        tablero.add(white);
        for(int i = 0; i < (width); i++){
            if((width%2==1) && (i%2==1)){
                filas = width/2 + 1;}  
            else {
                filas = width/2;
           
            }
            for(int o = 0; o < (filas); o++){
               
               black = new Rectangle();
               black.moveP(moveX, moveY);
               black.changeColor("black");
               
               if((i%2)==0){
                   black.moveHorizontal(o*60+30);
               } else {
                   black.moveHorizontal(o*60);
               }
               black.moveVertical(i*30);
               tablero.add(black);
            }
        }
        
        white2 = new Rectangle();
        white2.changeSize(width*30, width* 30);
        white2.moveP(width*30 +40, width*30 +40);
        white2.changeColor("white");
        tablero2.add(white2);
        for(int i = 0; i < (width); i++){
            if((width%2==1) && (i%2==1)){
                filas = width/2 + 1;}  
            else {
                filas = width/2;
           
            }
            for(int o = 0; o < (filas); o++){
               
               black2 = new Rectangle();
               black2.moveP(width*30 +40, width*30 +40);
               black2.changeColor("black");
               
               if((i%2)==0){
                   black2.moveHorizontal(o*60+30);
               } else {
                   black2.moveHorizontal(o*60);
               }
               black2.moveVertical(i*30);
               tablero2.add(black2);
            }
        }
        
        tabEstado = new boolean[width][width][2];
            for(int i = 0; i < width; i++){
                for(int j = 0; j < width; j++){
                    tabEstado[i][j][0] = false;
                }
            }
            tabEstado2 = new boolean[width][width][2];
            for(int n = 0; n < width; n++){
                for(int m = 0; m < width; m++){
                    tabEstado2[n][m][0] = false;
                }
            }
        elect = -1;
        electColor = "vacio";
        Checkers.op = true;
    }

    /**
     * Return a ArrayLIst of the board
     */
    public ArrayList getTablero()
    {
        // put your code here
        return tablero;
    }
    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        // put your code here
        for(int i = 0; i < tablero.size(); i++){
            Rectangle rec = tablero.get(i);
            rec.makeVisible();
        }
        for(int i = 0; i < tablero2.size(); i++){
            Rectangle rec2 = tablero2.get(i);
            rec2.makeVisible();
        }
        for(int i = 0; i < damas2.size(); i++){
                damas2.get(i).makeVisible();
            }
            
        for(int j = 0; j < damas.size(); j++){
            damas.get(j).makeVisible();
        }
        
        
    }
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        // put your code here
        for(int i = 0; i < tablero.size(); i++){
            Rectangle rec = tablero.get(i);
            rec.makeInvisible();
        }
        for(int i = 0; i < tablero2.size(); i++){
            Rectangle rec2 = tablero2.get(i);
            rec2.makeInvisible();
        }
        for(int i = 0; i < damas2.size(); i++){
                damas2.get(i).makeInvisible();
            }
            
        for(int j = 0; j < damas.size(); j++){
            damas.get(j).makeInvisible();
        }
    }
    /**
         * Creates tokens to put on the board
         * @param color the color of the tokens, True = white, False = red.
         * @param men the positions of the tokens in the board, initialized in 1 (row, column).
         * @param conta size of the board.
         */
        public  void adicionar(boolean color, int[][] men,int conta){
            for(int i = 0; i < men.length; i++)
            {
                fila = men[i][0] -1;
                columna = men[i][1] -1;
                Token ficha = new Token();

                if((fila == 0 && color) || (fila == conta-1 && !color)){
                    ficha.makeKing();
                    } 
                    
                addFicha(color, fila, columna, conta, ficha);     
            }
            
            if(Checkers.op){
                Checkers.op = true;
            }
        }
        /**
         * Creates a king token to put on the board.
         *
         * @param color the color of the token, True = white, False = red.
         * @param row row where the king token will be put.
         * @param column column where the king token will be put.
         * @param conta size of the board
         */
        public void addKing(boolean color, int row, int column, int conta){
            fila = row -1;
            columna = column -1;
            Token ficha = new Token();
            ficha.makeKing();
            addFicha(color, fila, columna, conta,ficha);
            if(Checkers.op){
                Checkers.op = true;
            }
        }
        
        /**
         * Creates a king token to put on the board.
         *
         * @param color the color of the token, True = white, False = red.
         * @param row row where the king token will be put.
         * @param column column where the king token will be put.
         * @param conta size of the board
         */
        public void addProletario(boolean color, int row, int column, int conta){
            fila = row -1;
            columna = column -1;
            Proletarian prole = new Proletarian();
            
            addFicha(color, fila, columna, conta,prole);
            if(Checkers.op){
                Checkers.op = true;
            }
        }
        
        /**
         * Creates a king token to put on the board.
         *
         * @param color the color of the token, True = white, False = red.
         * @param row row where the king token will be put.
         * @param column column where the king token will be put.
         * @param conta size of the board
         */
        public void addHurried(boolean color, int row, int column, int conta){
            fila = row -1;
            columna = column -1;
            Hurried hurried = new Hurried();
            
            addFicha(color, fila, columna, conta,hurried);
            if(Checkers.op){
                Checkers.op = true;
            }
        }
        
        /**
         * Creates a Powerful token to put on the board.
         *
         * @param color the color of the token, True = white, False = red.
         * @param row row where the Powerful token will be put.
         * @param column column where the Powerful token will be put.
         * @param conta size of the board
         */
        public void addPowerful(boolean color, int row, int column, int conta){
            fila = row -1;
            columna = column -1;
            Powerful power = new Powerful();
            
            addFicha(color, fila, columna, conta,power);
            if(Checkers.op){
                Checkers.op = true;
            }
        }
        /**
         * Creates a Traidora token to put on the board.
         *
         * @param color the color of the token, True = white, False = red.
         * @param row row where the Traidora token will be put.
         * @param column column where the Traidora token will be put.
         * @param conta size of the board
         */
        public void addTraidora(boolean color, int row, int column, int conta){
            fila = row -1;
            columna = column -1;
            Traidora traidora = new Traidora();
            
            addFicha(color, fila, columna, conta,traidora);
            if(Checkers.op){
                Checkers.op = true;
            }
        }
        /**
         * Creates a Lazy token to put on the board.
         *
         * @param color the color of the token, True = white, False = red.
         * @param row row where the Lazy token will be put.
         * @param column column where the Lazy token will be put.
         * @param conta size of the board
         */
        public void addLazy(boolean color, int row, int column, int conta){
            fila = row -1;
            columna = column -1;
            Lazy lazy = new Lazy();
            
            addFicha(color, fila, columna, conta,lazy);
            if(Checkers.op){
                Checkers.op = true;
            }
        }
        
        /**
         * Creates a Libertarian token to put on the board.
         *
         * @param color the color of the token, True = white, False = red.
         * @param row row where the Libertarian token will be put.
         * @param column column where the Libertarian token will be put.
         * @param conta size of the board
         */
        public void addLibertarian(boolean color, int row, int column, int conta){
            fila = row -1;
            columna = column -1;
            Libertarian liber = new Libertarian();
            
            addFicha(color, fila, columna, conta,liber);
            if(Checkers.op){
                Checkers.op = true;
            }
        }
        
        /**
         * Saves the configuration board in a HashMap
         * 
         * @param name the name of the key in HashMap
         */
        public void save(String name){
            String contenido = write();
            saveMap.put(name,contenido);
            
        }
        /**
         * Reads a String and draws it on the configuration board.
         * 
         * @param checkerboard a string with a saved board
         */
        public void read(String checkerboard){
            makeInvisible();
            
            
            for(int i = 0; i < Checkers.conta; i++){
                for(int j = 0; j < Checkers.conta; j++){
                    tabEstado[i][j][0] = false;
                }
            }
            damas.clear();
            
            for(int n = 0; n < checkerboard.length() ; n++){
                char c = checkerboard.charAt(n);
                Token ficha = new Token();
                Proletarian prole = new Proletarian();
                int x = n%Checkers.conta;
                int y = n/Checkers.conta;
                if(c=='W'){
                    ficha.makeKing();
                    addFicha(true, y, x, Checkers.conta,ficha);
                }
                if(c=='w'){
                    addFicha(true, y, x, Checkers.conta, ficha);
                }
                if(c=='B'){
                    ficha.makeKing();
                    addFicha(false, y, x, Checkers.conta,ficha);
                }
                if(c=='b'){
                    addFicha(false, y, x, Checkers.conta, ficha);
                }
                if(c == 'p'){
                    
                    addFicha(true, y, x, Checkers.conta, prole);
                }
                if(c == 'P'){
                    
                    addFicha(false, y, x, Checkers.conta, prole);
                }
            }
            
            makeVisible();
        }
        /**
         * Recovers a configuration board saved in a HashMap
         * 
         * @param name the name of hey in HashMap
         * @return c the string of a configuration board
         */
        public String recover(String name){
            String c = saveMap.get(name);
            try{
                if(c.length() == (Checkers.conta)*(Checkers.conta)){
                    read(c);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Llave no encontrada","Alerta!",JOptionPane.WARNING_MESSAGE);
            }
            return c;
        }
        /**
         * Adds a token on the board.
         *
         * @param color the color of the token, True = white, False = red.
         * @param fila row where the token will be put.
         * @param columna column where the token will be put.
         * @param conta size of the board.
         * @param circulo token.
         */
        public void addFicha(boolean color, int fila, int columna, int conta, Dama ficha){
            if((fila < conta) && (columna < conta))
            {
                if((fila%2!=0) && (columna%2 == 0)  && (tabEstado[fila][columna][0] == false)){
                    if(color){
                        String color_blanco = "white";
                        ficha.changeColor(color_blanco);
                        ficha.changeColorFijo(color_blanco);
                        tabEstado[fila][columna][1] = true;
                    } else {
                        String color_rojo = "red";
                        ficha.changeColor(color_rojo);
                        ficha.changeColorFijo(color_rojo);
                        tabEstado[fila][columna][1] = false;
                    }
                    ficha.changePosition(columna*30+(conta*30+40), fila*30+(conta*30+40));
                    ficha.makeVisible();
                     
                    damas.add(ficha);
                    tabEstado[fila][columna][0] = true;
                } else if((columna%2!= 0) && (fila%2 == 0) && (tabEstado[fila][columna][0] == false)) {
                    if(color){
                        String color_blanco = "white";
                        ficha.changeColor(color_blanco);
                        ficha.changeColorFijo(color_blanco);
                        tabEstado[fila][columna][1] = true;
                    } else {
                        String color_rojo = "red";
                        ficha.changeColor(color_rojo);
                        ficha.changeColorFijo(color_rojo);
                        tabEstado[fila][columna][1] = false;
                    }
                    ficha.changePosition(columna*30+(conta*30+40), fila*30+(conta*30+40));
                    ficha.makeVisible();
                    
                    damas.add(ficha);
                    tabEstado[fila][columna][0] = true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La posición está ocupada o no esta permitida","Alerta!",JOptionPane.WARNING_MESSAGE);
                        Checkers.op = false;
                    }
            } else {
                JOptionPane.showMessageDialog(null, "La posición está ocupada o no esta permitida","Alerta!",JOptionPane.WARNING_MESSAGE);
                Checkers.op = false;
            }
        }
        /**
         * Saves the configuration board in a string
         * 
         * @return ent the string of the configuration board
         */
        public String write()
        {   
            String tableroString = "";
            int con = 0;
         
            for(int i=0; i<Checkers.conta; i++){
                
                for(int j=0; j<Checkers.conta;j++){
                    if(con%2==0){
                        if(j%2 == 0){
                            
                            tableroString += "-";
                        } 
                        else {
                            tableroString += ".";
                        }
                    
                    }
                    else{
                        if(j%2 == 0){
                            
                            tableroString += ".";
                        } 
                        else {
                            tableroString += "-";
                        }
                    }
                    
                }
                con +=1;
            }
            String ent = tableroString;
            for(Dama s: damas){
                int x1 = s.getPositionX() - (Checkers.conta*30+40);
                int y1 = s.getPositionY() - (Checkers.conta*30+40);
                int x = x1/30;
                int y = y1/30;
                boolean color = tabEstado[y][x][1];
                boolean King = s.getIsKing();
                
                String se;
                
                int pos = y * Checkers.conta + x;
                if(color){
                    
                    if(King){
                        se = "W";
                    } else {
                        se = "w";
                    
                    }
                    if(s instanceof Proletarian ){
                        se = "p";
                    }
                } else {
                    if(King){
                        se = "B";
                    } else{
                        se = "b";
                    }
                    if(s instanceof Proletarian ){
                        se = "P";
                    }
                }
                String nuevo = new StringBuilder(ent).replace(pos,pos + 1, se).toString();
                ent = nuevo;
                
            }
            return ent;
            
    }
    /**
     * Selects a token to move.
     *
     * @param row  row in where is found the token to move.
     * @param column column in where is found the token to move.
     */
    public void seleccionarFicha(int row, int column){
        if(elect >= 0){
            damas2.get(elect).changeColor(electColor);
        }
        if(tabEstado2[row -1][column -1][0] == true){
            for(int i = 0; i < damas2.size(); i++) {
                if((damas2.get(i).getPositionX() == (column-1)*30) && (damas2.get(i).getPositionY() == (row-1)*30)){
                    if(elect != i){
                        electColor = damas2.get(i).getColor();
                    }
                    damas2.get(i).changeColor("yellow");
                    elect = i;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "La posición está vacía","Alerta!",JOptionPane.WARNING_MESSAGE);
            Checkers.op = false;
        }
        if(Checkers.op){
            Checkers.op = true;
        }
    }
    
    /**
     * Removes a token
     * 
     * @param row row in where is found the token to remove.
     * @param column column in where is found the token to remove.
     */
    public void remover(int row, int column){
        if(tabEstado[row -1][column -1][0] == true){
            for(int i = 0; i < damas.size(); i++) {
                if((damas.get(i).getPositionX() == (column-1)*30+(Checkers.conta*30+40)) && (damas.get(i).getPositionY() == (row-1)*30+(Checkers.conta*30+40))){
                    damas.get(i).makeInvisible();
                    damas.remove(i);
                    tabEstado[row -1][column -1][0] = false;
                }
            }
        }
        Checkers.op = true;    
    }
    /**
     * Removes a token in game board.
     * 
     * @param row row in where is found the token to remove.
     * @param column column in where is found the token to remove.
     */
    public void removerGame(int row, int column){
        if(tabEstado2[row][column][0] == true){
            for(int i = 0; i < damas2.size(); i++) {
                if((damas2.get(i).getPositionX() == (column)*30) && (damas2.get(i).getPositionY() == (row)*30) && (damas2.get(i).puedeSerComido())){
                    
                    damas2.get(i).makeInvisible();
                    damas2.remove(i);
                    tabEstado2[row][column][0] = false;
                    
                }
            }
            
        }
        Checkers.op = true;    
    }
    /**
     * Removes tokens
     * 
     * @param pieces positions of the tokens to remove.
     */
    public void remover(int[][] pieces)
    {
        for(int i=0; i<pieces.length;i++){
            int fila = pieces[i][0];
            int columna = pieces[i][1];
            if(tabEstado[fila-1][columna-1][0] == true){
                for(int j = 0; j < damas.size(); j++) {
                    remover(fila,columna);
                    
                }
            }
            else{
            JOptionPane.showMessageDialog(null, "La posición está vacía","Alerta!",JOptionPane.WARNING_MESSAGE);
            Checkers.op = false;
        }
        }
        if(Checkers.op){
            Checkers.op = true;
        }
    }
    
    /**
     * Swaps the game board with the configuration board.
     */
    public void swap(){
        ArrayList<Dama> swapFile = new ArrayList<Dama>();
      
        if(elect >= 0){
            damas2.get(elect).changeColor(electColor);
        }
        elect = -1;
        for(int i = 0; i < damas.size(); i++){
            swapFile.add(damas.get(i));
        }
        damas.clear();
        for(int i = 0; i < damas2.size(); i++){
            damas.add(damas2.get(i));
        }
        damas2.clear();
        for(int i = 0; i < swapFile.size(); i++){
            damas2.add(swapFile.get(i));
        }
        
        for(int i = 0; i < Checkers.conta; i++){
            for(int j = 0; j < Checkers.conta; j++){
                tabEstado[i][j][0] = false;
            }
        }
        
        for(int n = 0; n < Checkers.conta; n++){
            for(int m = 0; m < Checkers.conta; m++){
                tabEstado2[n][m][0] = false;
            }
        }
        
        for(int i = 0; i < damas2.size(); i++){
            int x = damas2.get(i).getPositionX()-(Checkers.conta*30+40);
            int y = damas2.get(i).getPositionY()-(Checkers.conta*30+40);
            String color = damas2.get(i).getColorFijo();
            if(color.equals("white")){
                tabEstado2[y/30][x/30][1] = true;
            } else {
                tabEstado2[y/30][x/30][1] = false;
            }
            
            tabEstado2[y/30][x/30][0] = true;
            damas2.get(i).changePosition(x, y);
        }
        
        for(int j = 0; j < damas.size(); j++){
            int x = damas.get(j).getPositionX();
            int y = damas.get(j).getPositionY();
            String color = damas.get(j).getColorFijo();
            if(color.equals("white")){
                tabEstado[y/30][x/30][1] = true;
            } else {
                tabEstado[y/30][x/30][1] = false;
            }
            tabEstado[y/30][x/30][0] = true;
            damas.get(j).changePosition(x+(Checkers.conta*30+40), y+(Checkers.conta*30+40));
        }
        
        Checkers.op = true;
    }
    
    /**
     * Consults the position of the tokens. 
     * @return  the position of the tokens on a list.
     */
    public int[][][] consultar(){
        int[][][] consulta;
        int size;
        if(damas.size() >= damas2.size()){
            size = damas.size();
        } else {
            size = damas2.size();
        }
        consulta = new int[2][size][2];
        for(int j = 0; j < size; j++){
            if(j < damas2.size()){
                int x = damas2.get(j).getPositionX();
                int y = damas2.get(j).getPositionY();
                consulta[0][j][0] = (y/30) + 1;
                consulta[0][j][1] = (x/30) + 1;
            } 
            if(j >= damas2.size()){
                consulta[0][j][0] = -1;
                consulta[0][j][1] = -1;
            } 
            if(j < damas.size()){
                int x = damas.get(j).getPositionX()-(Checkers.conta*30+40);
                int y = damas.get(j).getPositionY()-(Checkers.conta*30+40);
                consulta[1][j][0] = (y/30) + 1;
                consulta[1][j][1] = (x/30) + 1;
            }
            if(j >= damas.size()){
                consulta[1][j][0] = -1;
                consulta[1][j][1] = -1;
            }
            
        }
        
        Checkers.op = true;
        return consulta;
    }
    
    /**
     * Moves a selected token
     * 
     * @param top vertical control of the token. 
     * @param right horizontal control of the token.
     */
    public void shift(boolean top, boolean right){
        if(elect >= 0){
            int x = damas2.get(elect).getPositionX();
            int y = damas2.get(elect).getPositionY();
            String color_fijo = damas2.get(elect).getColorFijo();
            int y1 = (y)/30;
            int x1 = (x)/30;
            boolean King = damas2.get(elect).getIsKing();
            
            
            if((top == true) && (top == true) ){
                if(((0 <= x1 + 1)&&(x1+1 < Checkers.conta))&&((0 <= y1 - 1)&&(y1-1 < Checkers.conta)) && (color_fijo == "white" || King) ){
                    if(tabEstado2[y1-1][x1+1][0] == false){
                        if(y1 - 1 == 0){
                            tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();

                        }
                        damas2.get(elect).changePosition((x+30), (y-30));
                        tabEstado2[y1][x1][0] = false;
                        if(tabEstado2[y1][x1][1]){
                            tabEstado2[y1-1][x1+1][1] = true;
                        } else {
                            tabEstado2[y1-1][x1+1][1] = false;
                        }
                        tabEstado2[y1-1][x1+1][0] = true;
                    } 
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }    
            } 
            if((top == true) && (right == false)){
                if(((0 <= x1 - 1)&&(x1-1 < Checkers.conta))&&((0 <= y1 - 1)&&(y1-1 < Checkers.conta)) && (color_fijo == "white"|| King)){
                    if(tabEstado2[y1-1][x1-1][0] == false){
                        if(y1 - 1 == 0){
                            tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                            
                        }
                        damas2.get(elect).changePosition((x-30), (y-30));
                        tabEstado2[y1][x1][0] = false;
                        if(tabEstado2[y1][x1][1]){
                            tabEstado2[y1-1][x1-1][1] = true;
                        } else {
                            tabEstado2[y1-1][x1-1][1] = false;
                        }
                        tabEstado2[y1-1][x1-1][0] = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }
            }
            if(!top && right){
                if(((0 <= x1 + 1)&&(x1+1 < Checkers.conta))&&((0 <= y1 + 1)&&(y1+1 < Checkers.conta)) && (color_fijo=="red" || King) ){
                    if(tabEstado2[y1+1][x1+1][0] == false){
                        if(y1 + 1 == Checkers.conta -1){
                            tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                        }
                        damas2.get(elect).changePosition(x+30, y+30);
                        tabEstado2[y1][x1][0] = false;
                        if(tabEstado2[y1][x1][1]){
                            tabEstado2[y1+1][x1+1][1] = true;
                        } else {
                            tabEstado2[y1+1][x1+1][1] = false;
                        }
                        tabEstado2[y1+1][x1+1][0] = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }   
            }
            if(!top && !right){
                if(((0 <= x1 - 1)&&(x1-1 < Checkers.conta))&&((0 <= y1 + 1)&&(y1+1 < Checkers.conta)) && (color_fijo=="red" || King)){
                    if(tabEstado2[y1+1][x1-1][0] == false){
                        if(y1 + 1 == Checkers.conta -1){
                            tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                        }
                        damas2.get(elect).changePosition(x-30, y+30);
                        tabEstado2[y1][x1][0] = false;
                        if(tabEstado2[y1][x1][1]){
                            tabEstado2[y1+1][x1-1][1] = true;
                        } else {
                            tabEstado2[y1+1][x1-1][1] = false;
                        }
                        tabEstado2[y1+1][x1-1][0] = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                } 
            }
        }
        
        if(damas2.get(elect).debeSaltarOtraVez()){
            
            
            int x = damas2.get(elect).getPositionX();
            int y = damas2.get(elect).getPositionY();
            String color_fijo = damas2.get(elect).getColorFijo();
            int y1 = (y)/30;
            int x1 = (x)/30;
            boolean King = damas2.get(elect).getIsKing();
            
            
            if((top == true) && (top == true) ){
                if(((0 <= x1 + 1)&&(x1+1 < Checkers.conta))&&((0 <= y1 - 1)&&(y1-1 < Checkers.conta)) && (color_fijo == "white" || King) ){
                    if(tabEstado2[y1-1][x1+1][0] == false){
                        if(y1 - 1 == 0){
                            tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();

                        }
                        damas2.get(elect).changePosition((x+30), (y-30));
                        tabEstado2[y1][x1][0] = false;
                        if(tabEstado2[y1][x1][1]){
                            tabEstado2[y1-1][x1+1][1] = true;
                        } else {
                            tabEstado2[y1-1][x1+1][1] = false;
                        }
                        tabEstado2[y1-1][x1+1][0] = true;
                    } 
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }    
            } 
            if((top == true) && (right == false)){
                if(((0 <= x1 - 1)&&(x1-1 < Checkers.conta))&&((0 <= y1 - 1)&&(y1-1 < Checkers.conta)) && (color_fijo == "white"|| King)){
                    if(tabEstado2[y1-1][x1-1][0] == false){
                        if(y1 - 1 == 0){
                            tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                            
                        }
                        damas2.get(elect).changePosition((x-30), (y-30));
                        tabEstado2[y1][x1][0] = false;
                        if(tabEstado2[y1][x1][1]){
                            tabEstado2[y1-1][x1-1][1] = true;
                        } else {
                            tabEstado2[y1-1][x1-1][1] = false;
                        }
                        tabEstado2[y1-1][x1-1][0] = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }
            }
            if(!top && right){
                if(((0 <= x1 + 1)&&(x1+1 < Checkers.conta))&&((0 <= y1 + 1)&&(y1+1 < Checkers.conta)) && (color_fijo=="red" || King) ){
                    if(tabEstado2[y1+1][x1+1][0] == false){
                        if(y1 + 1 == Checkers.conta -1){
                            tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                        }
                        damas2.get(elect).changePosition(x+30, y+30);
                        tabEstado2[y1][x1][0] = false;
                        if(tabEstado2[y1][x1][1]){
                            tabEstado2[y1+1][x1+1][1] = true;
                        } else {
                            tabEstado2[y1+1][x1+1][1] = false;
                        }
                        tabEstado2[y1+1][x1+1][0] = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }   
            }
            if(!top && !right){
                if(((0 <= x1 - 1)&&(x1-1 < Checkers.conta))&&((0 <= y1 + 1)&&(y1+1 < Checkers.conta)) && (color_fijo=="red" || King)){
                    if(tabEstado2[y1+1][x1-1][0] == false){
                        if(y1 + 1 == Checkers.conta -1){
                            tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                        }
                        damas2.get(elect).changePosition(x-30, y+30);
                        tabEstado2[y1][x1][0] = false;
                        if(tabEstado2[y1][x1][1]){
                            tabEstado2[y1+1][x1-1][1] = true;
                        } else {
                            tabEstado2[y1+1][x1-1][1] = false;
                        }
                        tabEstado2[y1+1][x1-1][0] = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                } 
            }
            
        }
    }
    
  
    
    /**
     * Jumps tokens with a selected token.
     * 
     * @param top vertical control of the token.
     * @param right horizontal control of the token.
     */
    public void jump(boolean top,boolean right)
    {
        
    
       if(elect >= 0){
            int x = damas2.get(elect).getPositionX();
            int y = damas2.get(elect).getPositionY();
            String color_fijo = damas2.get(elect).getColorFijo();
            int y1 = (y)/30;
            int x1 = (x)/30;
            boolean King = damas2.get(elect).getIsKing();
            int x2 = x1;
            int y2 = y1;
            int xp = x;
            int yp = y;
            if((top == true) && (top == true) ){
                if(((0 <= x1 + 2)&&(x1 + 2 < Checkers.conta))&&((0 <= y1 - 2)&&(y1 - 2 < Checkers.conta)) && (color_fijo == "white" || King) ){
                    boolean disp = true;
                    
                    while(((0 <= x2 + 2)&&(x2 + 2 < Checkers.conta))&&((0 <= y2 - 2)&&(y2 - 2 < Checkers.conta)) && (color_fijo == "white" || King) && disp){
                        disp = false;
                        if(tabEstado2[y2-1][x2+1][0] == true && (tabEstado2[y2-1][x2+1][1] != tabEstado2[y2][x2][1])){
                            
                            if(y2 - 2 == 0){
                                tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                            }
                            damas2.get(elect).changePosition((xp+60), (yp-60));
                            tabEstado2[y1][x1][0] = false;
                            if(tabEstado2[y2][x2][1]){
                                tabEstado2[y2-2][x2+2][1] = true;
                            } else {
                                tabEstado2[y2-2][x2+2][1] = false;
                            }
                            tabEstado2[y2-2][x2+2][0] = true;
                            
                            if(damas2.get(elect).debeComer()){
                                
                                removerGame(y2-1,x2+1);
                            }
                            disp = damas2.get(elect).debeContinuar(); 
                            
                            
                            if(damas2.get(elect).debeTraicionar()){
                                
                                electColor = "red";
                                damas2.get(elect).changeColorFijo("red");
                                tabEstado2[y2][x2][1] = false;
                            
                            }
                            x2 += 2;
                            y2 -= 2;
                            xp += 60;
                            yp -= 60;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }    
            } 
            if((top == true) && (right == false)){
                if(((0 <= x1 - 2)&&(x1-2 < Checkers.conta))&&((0 <= y1 - 2)&&(y1-2 < Checkers.conta)) && (color_fijo == "white"|| King)){
                    boolean disp = true;
                    while(((0 <= x2 - 2)&&(x2 - 2 < Checkers.conta))&&((0 <= y2 - 2)&&(y2 - 2 < Checkers.conta)) && (color_fijo == "white" || King) && disp){
                        disp = false;
                        if(tabEstado2[y2-1][x2-1][0] == true && (tabEstado2[y2-1][x2-1][1] != tabEstado2[y2][x2][1])){
                            if(y2 - 2 == 0){
                                tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                            }
                            damas2.get(elect).changePosition((xp-60), (yp-60));
                            tabEstado2[y1][x1][0] = false;
                            if(tabEstado2[y2][x2][1]){
                                tabEstado2[y2-2][x2-2][1] = true;
                            } else {
                                tabEstado2[y2-2][x2-2][1] = false;
                            }
                            tabEstado2[y2-2][x2-2][0] = true;
                            if(damas2.get(elect).debeComer()){
                                removerGame(y2-1,x2-1);
                            }
                            disp = damas2.get(elect).debeContinuar(); 
                            
                            if(damas2.get(elect).debeTraicionar()){
                                electColor = "red";
                                damas2.get(elect).changeColorFijo("red");
                                tabEstado2[y2][x2][1] = false;
                            
                            }
                            x2 -= 2;
                            y2 -= 2;
                            xp -= 60;
                            yp -= 60;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }
            }
            if(!top && right){
                if(((0 <= x1 + 2)&&(x1+2 < Checkers.conta))&&((0 <= y1 + 2)&&(y1+2 < Checkers.conta)) && (color_fijo=="red" || King) ){
                    boolean disp = true;
                    while(((0 <= x2 + 2)&&(x2 + 2 < Checkers.conta))&&((0 <= y2 + 2)&&(y2 + 2 < Checkers.conta)) && (color_fijo == "red" || King) && disp){
                        disp = false;
                        if(tabEstado2[y2+1][x2+1][0] == true && (tabEstado2[y2+1][x2+1][1] != tabEstado2[y2][x2][1])){
                            if(y2 + 2 == Checkers.conta-1){
                                tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                            }
                            damas2.get(elect).changePosition((xp+60), (yp+60));
                            tabEstado2[y1][x1][0] = false;
                            
                            if(tabEstado2[y2][x2][1]){
                                tabEstado2[y2+2][x2+2][1] = true;
                            } else {
                                tabEstado2[y2+2][x2+2][1] = false;
                            }
                            tabEstado2[y2+2][x2+2][0] = true;
                            if(damas2.get(elect).debeComer()){
                                
                                removerGame(y2+1,x2+1);
                            }
                            disp = true;
                            try{
                                disp = damas2.get(elect).debeContinuar(); 
                            }
                            catch(IndexOutOfBoundsException e){
                                elect = elect - 1;
                            }
                            try{
                            if(damas2.get(elect).debeTraicionar()){
                                electColor = "white";
                                damas2.get(elect).changeColorFijo("white");
                                tabEstado2[y2][x2][1] = true;
                              
                            
                            }
                            }
                            catch(IndexOutOfBoundsException m){
                            }
                            
                         
                            x2 += 2;
                            y2 += 2;
                            xp += 60;
                            yp += 60;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                }   
            }
            if(!top && !right){
                if(((0 <= x1 - 2)&&(x1-2 < Checkers.conta))&&((0 <= y1 + 2)&&(y1+2 < Checkers.conta)) && (color_fijo=="red" || King)){
                    boolean disp = true;
                    while(((0 <= x2 - 2)&&(x2 - 2 < Checkers.conta))&&((0 <= y2 + 2)&&(y2 + 2 < Checkers.conta)) && (color_fijo == "red" || King) && disp){
                        disp = false;
                        if(tabEstado2[y2+1][x2-1][0] == true && (tabEstado2[y2+1][x2-1][1] != tabEstado2[y2][x2][1])){
                            if(y2 + 2 == Checkers.conta-1){
                                tabEstado2[y1][x1][0] = damas2.get(elect).makeKing();
                            }
                            damas2.get(elect).changePosition((xp-60), (yp+60));
                            tabEstado2[y1][x1][0] = false;
                            if(tabEstado2[y2][x2][1]){
                                tabEstado2[y2+2][x2-2][1] = true;
                            } else {
                                tabEstado2[y2+2][x2-2][1] = false;
                            }
                            tabEstado2[y2+2][x2-2][0] = true;
                            if(damas2.get(elect).debeComer()){
                                removerGame(y2+1,x2-1);
                            }
                            disp = damas2.get(elect).debeContinuar(); 
                            
                            if(damas2.get(elect).debeTraicionar()){
                                electColor = "white";
                                damas2.get(elect).changeColorFijo("white");
                                tabEstado2[y2][x2][1] = true;
                            
                            }
                            x2 -= 2;
                            y2 += 2;
                            xp -= 60;
                            yp += 60;
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido","Alerta!",JOptionPane.WARNING_MESSAGE);
                } 
            }
        } 
    
        
    }
    
    public boolean getTabEstado(int fila, int columna){
        boolean a = tabEstado[fila-1][columna-1][0];
        return a;
    }
    
    
    public boolean getTabEstado2(int fila, int columna){
        boolean b = tabEstado2[fila-1][columna-1][0];
        return b;
    }
    public String getColorFicha(){
        String b = electColor;
        return b;
    }
    public  void setDama(int posicion){
        damas.remove(posicion);
    }
    /**
     * Calculates the row and column from a single number
     * @param calc A single number
     * @return env A list with the row and column
     */
    public int[][] calculatePos(int calc){
        double numero1 = (double)calc;
        double fila = Math.ceil(((numero1*2)/8));
        int n = (int)fila;
        double col1 = Math.ceil(fila/2) - 1.0;
        int n1 = (int)col1;
        int res = calc - (8*n1);
        int col;
        if(res <= 4){
            col = res * 2;
        }else {
            col = res * 2 -9;
        }
      
        int[][] env = new int[1][2];
        env[0][0] = n;
        env[0][1] = col;
        
        return env;
    }
    /**
     * Determinate the necesary token for a movement
     * @param disp the positions that going be occupy
     * @param n1 position 1 of the movement
     * @paran n2 position 2 of the movement
     * @return num the position of the necesary token for a movement
     */
    public int calculatesPos2(ArrayList<Integer> disp, int n1, int n2){
        int num = 0;
        int[][] num1 = calculatePos(n1);
        
        if(num1[0][0] % 2 == 0){
            if(n2 > n1){
                if(disp.indexOf(n1 + 4) == -1){
                    num = n1 + 4;
                } 
            } else {
                if(disp.indexOf(n1 - 4) == -1){
                    num = n1 - 4;
                }
            }
        } else {
            if(n2 > n1){
                if(disp.indexOf(n1 + 5) == -1){
                    num = n1 + 5;
                } 
            } else {
                if(disp.indexOf(n1 - 5) == -1){
                    num = n1 - 5;
                }
            }
        }
        
        return num;
        
    }
    /**
     * Determinate wich is the next movement for shift
     * @param n is a ArrayList of integer
     * @return valorShift that is a list of the boolean
     */
    public boolean[] calculateShift2(ArrayList<Integer> n){
        boolean[] valorShift = new boolean[2];
        if(n.get(0)>n.get(1)){
            if(n.get(0)-4 == n.get(1)){
                valorShift[0]= true;
                valorShift[1] = true;
            }else{
                valorShift[0]= true;
                valorShift[1] = false;
            
            }
        
        }else{
            if(n.get(0)+3 == n.get(1)){
                valorShift[0]= false;
                valorShift[1] = false;
            }else{
                valorShift[0]= false;
                valorShift[1] = true;
            
            }
        
        }
        return valorShift;
    }
    /**
     * Determinate wich is the next movement for jump
     * @param n is a ArrayList of integer
     * @return valorJump that is a list of the boolean
     */
    public boolean[] calculateJump2(ArrayList<Integer> n){
         boolean[] valorJump = new boolean[2];
        if(n.get(0)>n.get(1)){
            if(n.get(0)-7 == n.get(1)){
                valorJump[0]= true;
                valorJump[1] = true;
            }else{
                valorJump[0]= true;
                valorJump[1] = false;
            
            }
        
        }else{
            if(n.get(0)+7 == n.get(1)){
                valorJump[0]= false;
                valorJump[1] = false;
            }else{
                valorJump[0]= false;
                valorJump[1] = true;
            
            }
        
        }
        return valorJump;
        
    
    }
}



