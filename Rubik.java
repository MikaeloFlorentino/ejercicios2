/**
 *
 * @author mikaelo
 */
public class Rubik {

    private int[][] getCara(int[][][] cubo, int lado){
        int[][] cara =  new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                cara[i][j]=cubo[lado][i][j];
            }
        }
        return cara;
    }
    private boolean validaCara(int[][][] cubo, int lado){
        int r=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                r+=cubo[lado][i][j];
            }
        }
        return r==(cubo[lado][0][0]*9);
    }
    private boolean validaLados(int[][][] cubo){
        boolean iguales=true;
        for(int i =0;i<5; i++){
            iguales=(cubo[i][0][0]==cubo[i+1][0][0])&&iguales;
        }
        return iguales; 
    }
    private void salir(String valor){
        System.out.println(valor+" esta armado");
        System.exit(0);
    }
    public static void main (String args[]){
        Rubik rubik = new Rubik();
        String SI="Si";
        String NO="No";
        int[][][] cubo= rubik.llenaCubo();
        for(int i=0; i<6; i++){
            for(int j=i+1; j<6; j++){
                if(cubo[i][0][0]==cubo[j][0][0]){
                    rubik.salir(NO);
                }
            }
        }
        
        for(int i=0; i<6; i++){
            if(!rubik.validaCara(cubo, i)){
                rubik.salir(NO);
            }
        }
        rubik.salir(SI);
    }
    
    public int[][][] llenaCubo(){
        int[][][] cubo= new int[6][3][3];
        //lado 0
        cubo[0][0][0]=0;
        cubo[0][0][1]=0;
        cubo[0][0][2]=0;
        cubo[0][1][0]=0;
        cubo[0][1][1]=0;
        cubo[0][1][2]=0;
        cubo[0][2][0]=0;
        cubo[0][2][1]=0;
        cubo[0][2][2]=0;
        //lado 1
        cubo[1][0][0]=1;
        cubo[1][0][1]=1;
        cubo[1][0][2]=1;
        cubo[1][1][0]=1;
        cubo[1][1][1]=1;
        cubo[1][1][2]=1;
        cubo[1][2][0]=1;
        cubo[1][2][1]=1;
        cubo[1][2][2]=1;
        //lado 2
        cubo[2][0][0]=2;
        cubo[2][0][1]=2;
        cubo[2][0][2]=2;
        cubo[2][1][0]=2;
        cubo[2][1][1]=2;
        cubo[2][1][2]=2;
        cubo[2][2][0]=2;
        cubo[2][2][1]=2;
        cubo[2][2][2]=2;
        //lado 3
        cubo[3][0][0]=3;
        cubo[3][0][1]=3;
        cubo[3][0][2]=3;
        cubo[3][1][0]=3;
        cubo[3][1][1]=3;
        cubo[3][1][2]=3;
        cubo[3][2][0]=3;
        cubo[3][2][1]=3;
        cubo[3][2][2]=3;
        //lado 4
        cubo[4][0][0]=4;
        cubo[4][0][1]=4;
        cubo[4][0][2]=4;
        cubo[4][1][0]=4;
        cubo[4][1][1]=4;
        cubo[4][1][2]=4;
        cubo[4][2][0]=4;
        cubo[4][2][1]=4;
        cubo[4][2][2]=4;
        //lado 5
        cubo[5][0][0]=5;
        cubo[5][0][1]=5;
        cubo[5][0][2]=5;
        cubo[5][1][0]=5;
        cubo[5][1][1]=5;
        cubo[5][1][2]=5;
        cubo[5][2][0]=5;
        cubo[5][2][1]=5;
        cubo[5][2][2]=5;
        return cubo;
    }
}
