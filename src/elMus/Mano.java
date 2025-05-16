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
        10 -> SOTA
        11 -> CABALLO
        12 -> REY
    Valor
4.- Mandarlo a 'Cartas.java'
5.- Método si par y tipo o no, si juego o no
    PAR --> Comparar valores (con get valor en 'Carta.java')
    JUEGO --> Sumar valor cartas (con get tmb)
    a) Método averiguar Valor
    b) Método para averiguar Par
        Caso afirmativo: Averiguar Tipo
            Par:    2 cartas iguales
            Media:  3 cartas iguales
            Duplex: 4 cartas iguales    o   2 Pares (es decir, 2 igual y otros 2 igual, pero entre ellas son diferentes)
    c) Método para averiguar Juego
6.- Método para imprimir
*/
public class Mano {
    
    //Atributos
    private String      nombre;
    private Carta       carta[] = new Carta [4];

    private boolean     par;
    private int         tipoPar;
    private boolean     juego;
    private int         sumaJuego = 0;
    
    /*====================================================================*/
    //Constructor
    public Mano(String nombre) {
        this.nombre = nombre;
    }
    
    /*====================================================================*/
    //Métodos
    
   //Generar carta sin repetir
    public void generarMano(){
        boolean repetir = false;
        
        //La primera, la de posición 0, no lo revisamos
        for (int i=1; i < carta.length; i++) {
            do{
                carta[i].generarCarta();
                repetir = comprobar(i); //Desde donde estoy [i], voy comprobando de 1 en 1 desde los anteriores hasta el actual
            }while ( repetir == true );
        }
    }
    
    /***********************************************************************/
    //Comprobar si anteriores hay repetido
    private boolean comprobar(int i){
        boolean repetir = false;
        boolean numIgual, paloIgual;
        
        //Vemos si en algún punto del Array, comparamos el actual con el que vamos a comparar y tanto num y palo sale true = hay repetido
        for (int j = 0; j < i; j++) {
            numIgual = numIgual(i, j);
            paloIgual = paloIgual(i, j);
            
            if (  (numIgual == true) && (paloIgual == true)  )
                repetir = true;
        }
        
        return repetir;
    }
    
    private boolean numIgual(int i, int j){
        boolean igual = false;
        
        //Miro si en la posición en el que estoy[i] y en el que compuebo[j] tiene números iguales
        if (   carta[i].getNum() == carta[j].getNum()   )
            igual = true;
        
        return igual;
    }
    
    private boolean paloIgual(int i, int j){
        boolean igual = false;
        
        //Miro si en la posición en el que estoy[i] y en el que compuebo[j] tiene números iguales
        if (   carta[i].getPalo().equals( carta[j].getPalo() )   )
            igual = true;
        
        return igual;
    }
    /***********************************************************************/
    
    //Si es par y su tipo
    private void par(){
        int cont = 0;
        
        //Comparar valores de cada carta --> Get de Valor
        for (int i = 1; i < carta.length; i++) {
             //Miro si en la posición en el que estoy[i] y en el que compuebo[j] tiene valores iguales
             for (int j = 0; j < i; j++) {
                if (   carta[i].getValor() == carta[j].getValor()   )
                    cont++;
            }
        }
    }
    
    //Caso afirmativo en par: descubrir tipo (Par, Medias o Duples)
    private void tipoPar(){
        
    }
    
    //Si es juego y su suma
    private void juego(){
        
        //Sumar valores de cada carta --> Get de Valor
        for (int i = 0; i < carta.length; i++) {
            sumaJuego = sumaJuego + carta[i].getValor();
        }
        
        //Es juego si [31, 40] (se incluye dichos números)
        if ( (sumaJuego < 31) || (sumaJuego > 40) )
            juego = true;
        else
            juego = false;
        
        //Si quiero hacer un ranking tengo que hacerlo en 'Principal.java'
    }
    
    /***********************************************************************/
    
    //Imprimir
    
}//Mano