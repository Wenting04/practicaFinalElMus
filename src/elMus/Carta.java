/*15/05/2025*/
/*3º*/

/*prog-ut7-práctica1-Análisis y codificación MANO DE MUS -.pdf*/

/*====================================================================*/
/***********************************************************************/

package elMus;
/*
1.- Debe tener:
    1) int      Número
    2) String   Palo
    3) int      Valor
    4) boolean  Par
    5) int      TipoPar
    6) boolean  Juego
2.- Generamos aleatoriamente Número y Palo
3.- Método averiguar Valor
4.- Método para averiguar Par
    Caso afirmativo: Averiguar Tipo
5.- Método para averiguar Juego
*/
public class Carta {
    
    //Atributos
    private int         num;
    private String      Palo;
    private int         valor;
    private boolean     par;
    private int         tipoPar;
    private boolean     juego;
    
    /*====================================================================*/
    //Constructor

    public Carta(int num, String Palo) {
        this.num = num;
        this.Palo = Palo;
        valor = calcValor();
    }
    
    /*====================================================================*/
    //Métodos
    
    //Averiguar valor
    private int calcValor(){
        
        int calc;
        
        switch (num) {
            case 1:
                calc = 1;
                break;
            case 2:
                calc = 1;
                break;
            case 3:
                calc = 10;
                break;
            case 4:
                calc = 4;
                break;
            case 5:
                calc = 5;
                break;
            case 6:
                calc = 6;
                break;
            case 7:
                calc = 7;
                break;
            case 10:
                calc = 10;
                break;
            case 11:
                calc = 10;
                break;
            default:
                calc = 10;
                break;
        }
        
        return calc;
    }
    
    //Si es par o no
    private void par(){
        //Comparar valores de cada carta
    }
    
    //Caso afirmativo en par: descubrir tipo (Par, Medias o Duples)
    private void tipoPar(){
        
    }
    
    //Si es juego o no
    private void juego(){
        //Sumar valores de cada carta
        
    }
}//Carta