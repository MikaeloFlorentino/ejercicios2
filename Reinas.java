/**
 *
 * @author mikaelo
 */
public class Reinas {
    int [][]tablero;
    public Reinas(int [][]tablero){
        this.tablero=tablero;
    }
    /**
     * Evalua por la posición inicial la la sumatoria en X y Y
     * @param posicion
     * @return boolan
     */
    private boolean evaluaTableroFilaColumna(int posicion){
        boolean retorno=true;
        int acumuladoFila=0;
        int acumuladoColumna=0;
        for(int i=0; i<8; i++){
            acumuladoFila+=tablero[posicion][i];
            acumuladoColumna+=tablero[i][posicion];
        }
        retorno=(acumuladoFila==1)||(acumuladoColumna==1);
        //si no hay error y  posicion es menor a 7 se vuelve a ejecutar
        if(posicion<7&&retorno){
            evaluaTableroFilaColumna(posicion+1);
        }
        return retorno;
    }
    /**
     * Evalua las 2 diagonales y las superposiciona en 4 acumuladores que van del 0,0->7-7 y del 7,0->0,7
     * en los vectores X y Y
     * @param posicion
     * @return 
     */
    private boolean evaluaTableroDiagonales(int posicion){
        boolean retorno=true;
        int acumuladoDiagonalx1=0;
        int acumuladoDiagonalx2=0;
        int acumuladoDiagonaly1=0;
        int acumuladoDiagonaly2=0;
        int pivoteY=7-posicion;
        for(int i=0; i<8-posicion; i++){
            acumuladoDiagonalx1+=tablero[posicion+i][i];
            acumuladoDiagonalx2+=tablero[i][posicion+i];
            acumuladoDiagonaly1+=tablero[pivoteY-i][i];
            acumuladoDiagonaly2+=tablero[i][pivoteY-i];
        }
        retorno=(acumuladoDiagonalx1<=1)&&(acumuladoDiagonalx2<=1)&&(acumuladoDiagonaly1<=1)&&(acumuladoDiagonaly2<=1);
        //si no hay error y  posicion es menor a 7 se vuelve a ejecutar
        if(posicion<7&&retorno){
        
            retorno=evaluaTableroDiagonales(posicion+1);
        }
        return retorno;
    }
    /**
     * Sirve para correr las ejecciones de las validaciones
     */
    private void evaluaTablero(){
        String salida="no";
        if(evaluaTableroFilaColumna(0)){
            if(evaluaTableroDiagonales(0)){
                salida="si";
            }
        }
        System.out.println(salida);
    }
    
    public static void main(String mikaelo[]){
        int [][]tablero   = { 
                {1,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,1,0,0},
                {0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,1,0},
                {0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0} };
        
        Reinas r = new Reinas(tablero);
        r.evaluaTablero();
    }
    
}

/*int [][]tablero   = { 
                {1,0,0,1,0,0,0,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0} };*/
        /*int [][]tablero   = { 
                {1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0} };*/
        /*int [][]tablero   = { 
                {1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0} };*/
        /*int [][]tablero   = { 
                {1,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0},
                {0,0,0,1,0,0,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,1} };*/
        /*int [][]tablero   = { 
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,1,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,0},
                {0,0,1,0,0,0,0,0},
                {0,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0} };*/
