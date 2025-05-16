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

Y tedremos el número de la carta, su palo y el valor
*/
public class Carta {
    
    //Atributos
    private int         num;
    private String      palo;
    private int         aleatorio;
    private int         valor;
    
    /*====================================================================*/
    //Constructor

    public Carta() {
        generarCarta();
        valor = calcValor();
    }

    /***********************************************************************/
    //Getter
    
    public int getValor(){
        return valor;
    }

    public int getNum() {
        return num;
    }

    public String getPalo() {
        return palo;
    }

    /*====================================================================*/
    //Métodos
    
    /**********************************************************************/
    //Generar aleatoriamente el Número y el Palo
    
    public void generarCarta() {
        num = aleatorioNum();
        palo = aleatorioPalo();
    } // Genere cartas (excluye 8 y 9)
    
    
    public int aleatorioNum(){
        
        do{
           aleatorio = (int)(Math.random()*11+1); 
        }while ( (aleatorio == 8) || (aleatorio == 9));
        
        return aleatorio;
    }
    
    public String aleatorioPalo(){

        String alePalo;

        aleatorio = (int)(Math.random()*3+1);
        
        switch (aleatorio) {
            case 1:
                alePalo = "ORO";
                break;
            case 2:
                alePalo = "ESPADAS";
                break;
            case 3:
                alePalo = "COPAS";
                break;
            default:
                alePalo = "BASTO";
                break;
        }
        
        return alePalo;
    }
    /**********************************************************************/
    
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
}//Carta