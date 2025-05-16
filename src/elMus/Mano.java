/*15/05/2025*/
/*2º*/

/*prog-ut7-práctica1-Análisis y codificación MANO DE MUS -.pdf*/

/*====================================================================*/
/***********************************************************************/

package elMus;

import java.util.ArrayList;

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
    private String      tipoPar;
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
        carta[0] = new Carta();
        
        for (int i=1; i < carta.length; i++) {
            do{
                carta[i] = new Carta();
                repetir = comprobar(i); //Desde donde estoy [i], voy comprobando de 1 en 1 desde los anteriores hasta el actual
            }while ( repetir == true );
        }
        
        par();
        juego();
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
        
        int cont1 = 0, cont2 = 0;
        int i = 0;
        
        //0 -> No repetido      1 -> Sí repetido
        int contPar[] = {0, 0, 0, 0};
        
        do{
            //Cuando es 1, se salta pq ya tiene pareja
            if ( contPar[i] == 0){
                //Miro si en la posición en el que estoy[i] y en el que compuebo[j] tiene valores iguales
                for (int j = 0; j < i; j++) {

                   if (   carta[carta.length-i].getValor() == carta[j].getValor()   ){
                       contPar[carta.length-i] = 1;
                       contPar[j] = 1;
                   }
                   
                   //Marco con 1 las que sí son pareja para poder luego descartarlas
                }
                
                for (int j: contPar) {
                    cont1 = cont1 + j;
                }
                
                if ((cont1 == 2) && (i == 0)){
                    
                    ArrayList<Integer> arrayCero = new ArrayList<Integer>();
                    
                    //En caso de que sólo haya 2 cartas iguales, buscamos qué posición del array es 0, y comparamos entre ellas
                    for (int j = 0; j < contPar.length; j++) {
                        if (contPar[j] == 0)
                            arrayCero.add(j);
                    }
                    
                    if (  carta[ arrayCero.get(0) ].getValor() == carta[ arrayCero.get(1) ].getValor()   ){
                        contPar[arrayCero.get(0)] = 2;
                        contPar[arrayCero.get(1)] = 2;
                    }
                    
                    for (int j: contPar) {
                        if ( j == 2 )
                            cont2 = cont2 + (j-1);
                    }
                }
            }
            
            i++;
            
        }while(i < 3);
        
        if ( cont1 == 0 )
            par = false;
        else
            par = true;
        
        tipoPar(cont1, cont2);
    }
    
    //Caso afirmativo en par: descubrir tipo (Par, Medias o Duples)
    private void tipoPar(int cont1, int cont2){
        
        if( cont1 == 4 )
            tipoPar = "DUPLEX";         //4 cartas iguales
        if (cont1 == 3)
            tipoPar = "MEDIA";          //3 cartas iguales
        if ( cont1 == 2 ){
            if (cont2 == 2)
                tipoPar = "DUPLEX";     //2 pares iguales
            else
                tipoPar = "PAR";        //2 cartas iguales
        }
    }
    
    //Si es juego y su suma
    private void juego(){
        
        //Sumar valores de cada carta --> Get de Valor
        for (int i = 0; i < carta.length; i++) {
            sumaJuego = sumaJuego + carta[i].getValor();
        }
        
        //Es juego si [31, 40] (se incluye dichos números)
        if ( (sumaJuego >= 31) && (sumaJuego <= 40) )
            juego = true;
        else
            juego = false;
        
        //Si quiero hacer un ranking tengo que hacerlo en 'Principal.java'
    }
    
    /***********************************************************************/
    
    //Imprimir
    public void imprimirMano(){
        System.out.println(nombre);
        for (Carta i: carta) {
            if ( i.getNum() == 10 ){
                System.out.print("[SOTA DE " + i.getPalo() + "] ");
            }else if ( i.getNum() == 11 ){
                System.out.print("[CABALLO DE " + i.getPalo() + "] ");
            }else if ( i.getNum() == 12 ){
                System.out.print("[REY DE " + i.getPalo() + "] ");
            }else{
                System.out.print("[" + i.getNum() + " DE " + i.getPalo() + "] ");
            }
        }
        
        System.out.println("");
        
        if (par == true)
            System.out.println("PARES: SÍ " + tipoPar);
        else
            System.out.println("PARES: NO");
        
        if (juego == true)
            System.out.println("JUEGO: SÍ " + sumaJuego);
        else
            System.out.println("JUEGO: NO");
        
    }
    
    /*
    JUGADOR 1
    [1 de copas] [sota de espadas] [sota de oros] [caballo de espadas]
    PARES : Sí pareja
    JUEGO: Sí 31
    */
    
}//Mano