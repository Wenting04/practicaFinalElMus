/*15/05/2025*/
/*2º*/

/*prog-ut7-práctica1-Análisis y codificación MANO DE MUS -.pdf*/

/*====================================================================*/
/***********************************************************************/

package elMus;
/*
1.- Nos dan el nombre (atributo y constructor)
2.- Tenemos un Array de 4 posiciones --> La MANO (4 cartas por jugador)
3.- Necesito método para generar carta aleatoria
    Número
    Palo
    Valor
4.- Mandarlo a 'Cartas.java'
5.- Método si par y tipo o no, si juego o no
    PAR --> Comparar valores (con get valor en 'Carta.java')
    JUEGO --> Sumar valor cartas (con get tmb)
6.- Método para imprimir
*/
public class Mano {
    
    //Atributos
    private String nombre;
    private Carta carta[] = new Carta [4];
    
    private int num;
    private int aleatorio;
    private String palo;
    
    /*====================================================================*/
    //Constructor
    public Mano(String nombre) {
        this.nombre = nombre;
    }
    
    /*====================================================================*/
    //Métodos
    
    private void generarCartas(){
        
        for (Carta i:carta) {
            num = aleatorioNum();
            palo = aleatorioPalo();
            
            i = new Carta (num, palo);
        }
        
    }// Genere cartas (excluye 8 y 9)
    
    private int aleatorioNum(){
        
        do{
           aleatorio = (int)(Math.random()*11+1); 
        }while ( (aleatorio != 8) || (aleatorio != 9));
        
        return aleatorio;
    }
    
    private String aleatorioPalo(){

        String alePalo;

        aleatorio = (int)(Math.random()*3);
        
        switch (aleatorio) {
            case 0:
                alePalo = "ORO";
                break;
            case 1:
                alePalo = "ESPADAS";
                break;
            case 2:
                alePalo = "COPAS";
                break;
            default:
                alePalo = "BASTO";
                break;
        }
        
        return alePalo;
    }
    
}//Mano