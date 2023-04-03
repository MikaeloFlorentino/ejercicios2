
/**
 *
 * @author mikaelo
 */
public class Sudoku {
    private int [][] numeroSudoku;

    public Sudoku(int[][] numero){
        numeroSudoku=numero;
    }  
    
    /**
     * Valida filas y columnas con acumuladores en texto, usando recursividad
     * @return boolean 
     */
    private boolean evalFilaColuma(int numeroFila){
        boolean retorno=true;
        String almacenadoFila= "";
        String cadenaPivoteFila="";
        String almacenadoColumna= "";
        String cadenaPivoteColumna="";
        for(int i=0; i<9; i++){
            cadenaPivoteFila=String.valueOf(numeroSudoku[numeroFila][i]);
            cadenaPivoteColumna=String.valueOf(numeroSudoku[i][numeroFila]);
            if( (almacenadoFila.contains(cadenaPivoteFila)) ||
                (almacenadoColumna.contains(cadenaPivoteColumna))){
                    retorno=false;
            }else{
                almacenadoFila+=cadenaPivoteFila;
                almacenadoColumna+=cadenaPivoteColumna;
            }
        }
        
        if( (numeroFila<8) && retorno){
            if(! evalFilaColuma(numeroFila+1))
                retorno= evalFilaColuma(numeroFila+1);
        }
        return retorno;
    }
    
    /**
     * Valida cuadrantes de 3x3 que no se repita un valor, usando recursividad
     * @return boolean 
     */
    private boolean evalTercias(int numeroFila, int numeroColumna){
        boolean retorno=true;
        
        String almacenado= "", cadenaPivote="";
        for(int fila=numeroFila; fila<(numeroFila+3); fila++){
            for(int columna=numeroColumna; columna<(numeroColumna+3); columna++){
                cadenaPivote=String.valueOf(numeroSudoku[fila][columna]);
                if(almacenado.contains(cadenaPivote)){
                    retorno=false;
                }else{
                    almacenado=almacenado+cadenaPivote;
                }
            }
        }
        if((numeroColumna<6) && retorno){
            numeroColumna+=3;
            evalTercias(numeroFila,numeroColumna);
        }else if(numeroFila<6){
                numeroColumna=0;
                numeroFila+=3;
                evalTercias(numeroFila,numeroColumna);
        }
        return retorno;
    }
    
    /**
     * Valida las Columnas, Filas y Cuadrates en ciclos
     * @return String 
     */
    public String getEvluacionSudoku(){
        String retorno="Error";
        if(evalFilaColuma(0)){
            if(evalTercias(0, 0)){
                retorno= "Correcto TODO";
            }
        }
        return retorno;
    }
    public static void main(String miguel[]){
        int [][] arregloSudoku = { 
                    {1,2,3,4,5,6,7,8,9},
                    {4,5,6,7,8,9,1,2,3},
                    {7,8,9,1,2,3,4,5,6},
                    {2,3,4,5,6,7,8,9,1},
                    {5,6,7,8,9,1,2,3,4},
                    {8,9,1,2,3,4,5,6,7},
                    {3,4,5,6,7,8,9,1,2},
                    {6,7,8,9,1,2,3,4,5},
                    {9,1,2,3,4,5,6,7,8} };
        
        Sudoku obj = new Sudoku(arregloSudoku); 
        System.out.println(obj.getEvluacionSudoku());
        
    }

}
/*

//Todo Correcto
int [][] arregloSudoku = {
                    {1,2,3,4,5,6,7,8,9},
                    {4,5,6,7,8,9,1,2,3},
                    {7,8,9,1,2,3,4,5,6},
                    {2,3,4,5,6,7,8,9,1},
                    {5,6,7,8,9,1,2,3,4},
                    {8,9,1,2,3,4,5,6,7},
                    {3,4,5,6,7,8,9,1,2},
                    {6,7,8,9,1,2,3,4,5},
                    {9,1,2,3,4,5,6,7,8}
};

//Fila Incorrecta
int [][] arregloSudoku = {
                    {1,1,1,1,1,1,1,1,1},
                    {2,2,2,2,2,2,2,2,2},
                    {3,3,3,3,3,3,3,3,3},
                    {4,4,4,4,4,4,4,4,4},
                    {5,5,5,5,5,5,5,5,5},
                    {6,6,6,6,6,6,6,6,6},
                    {7,7,7,7,7,7,7,7,7},
                    {8,8,8,8,8,8,8,8,8},
                    {9,9,9,9,9,9,9,9,9}
};

//Columna Incorrecta
int [][] arregloSudoku = {
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9}
};


//Incorrecta Area
int [][] arregloSudoku = {
                    {1,2,3,4,5,6,7,8,9},
                    {4,5,6,7,8,9,1,2,3},
                    {8,9,1,2,3,4,5,6,7},
                    {7,8,9,1,2,3,4,5,6},
                    {2,3,4,5,6,7,8,9,1},
                    {5,6,7,8,9,1,2,3,4},
                    {3,4,5,6,7,8,9,1,2},
                    {6,7,8,9,1,2,3,4,5},
                    {9,1,2,3,4,5,6,7,8}
};
*/    
