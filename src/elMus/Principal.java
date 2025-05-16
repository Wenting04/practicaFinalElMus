/*30/04/2025*/
/*1º*/

/*prog-ut7-práctica1-Análisis y codificación MANO DE MUS -.pdf*/

/*====================================================================*/
/***********************************************************************/

package elMus;

/*
Pide para subir:
    -> 2 comprimidos
    -> 1 pdf (análisis ejercicio)
    -> Práctica exportada con fuentes


-- - RESUMEN - --:
4 jugadores --> Cada jugador 4 cartas (baraja española) [SIN REPETIR]

Baraja española:
    -> 40 o 48 cartas
    -> 4 palos (tipos): oros, espadas, copas y bastos
    -> Aparece números del 1 a 12 excepto 8 y 9
    -> Nombres especiales:
        10: SOTA
        11: CABALLO
        12: REY

Programa pide:
Repartir aleatoriamente 4 cartas no repetidas e imprimir por pantalla
Saber si hay "juego" y "pares"
Guardar en un fichero de texto la info de cada jugador

"Juego":
-> Cada carta tiene un valor asociado
    [1]     -> valor de 1       (AS o PITO)
    [2]     -> valor de 1       (AS o PITO)
    [3]     -> valor de 10      (= REY)
    [4]     -> valor de 4
    [5]     -> valor de 5
    [6]     -> valor de 6
    [7]     -> valor de 7
    [10]    -> valor de 10
    [11]    -> valor de 10
    [12]    -> valor de 10
-> Al sumar el valor de las 4 cartas, es "juego" si sacas 31 o más
    El orden de MEJOR A PEOR es este:
        1.- 31
        2.- 32
        3.- 40

        4.- 37
        5.- 36
        6.- 35
        7.- 34
        8.- 33

"Pares":
-> Tiene pares si hay 2 o más cartas iguales
    Par: sólo 2 iguales
    Medias: 3 iguales
    Duples: 2 parejas
-> A tener en cuenta
    [1] = [2]       Ambos son pitos
    [3] = [12]      Ambos son reyes


SALIDA (ejemplo):
***************************************************************************************************
JUGADOR 1
[1 de copas] [sota de espadas] [sota de oros] [caballo de espadas]
PARES : Sí pareja
JUEGO: Sí 31
--------------------------------------------------------------------------------------------------
JUGADOR 2
[7 de bastos] [6 de copas] [6 de oros] [7 de oros]
PARES : Sí dobles parejas
JUEGO: NO
--------------------------------------------------------------------------------------------------
JUGADOR 3
[rey de bastos] [3 de espadas] [7 de espadas] [4 de espadas]
PARES : Sí Pareja
JUEGO: Sí 31
--------------------------------------------------------------------------------------------------
JUGADOR 4
[5 de copas] [2 de bastos] [2 de oros] [1 de oros]
PARES : Sí medias
JUEGO: No
***************************************************************************************************


COSAS A SUBIR AL AV:

Práctica 1.- Documento PDF. Análisis del problema
    El programa debe resolver:
1.- Clases necesarias (debemos analizarlo)
2.- Estructuras de datos necesario. Cómo representar la baraja. Cómo representar las 4 cartas de cada jugador
3.- No debe haber ni [8] ni [9] en la baraja
4.- Cómo resolver la diferenciación de los 4 palos. Por ejemplo, de qué manera diferencia tu programa el 7 de bastos del 7 de espadas, etc
5.- Resolver situación donde, dada una carta, esa misma NO puede volver a darse (se retira de la baraja)
6.- Cálculo del "juego" y "pares" de cada jugador
7.- Incorpora los gráficos que estimes oportunos (aporta ayuda)
8.- No hay herencia necesariamente
9.- Obligatorio uso del POO
10.- Fichero es de texto y con formato antes expuesto con las jugadas de cada jugador

Práctica 2.- Codificación java de la solución
*/

/* Principal, Mano y Carta
1.- Tener Array de 4 posiciones --> JUGADORES

Como en U6Ejer - Hoja1Ej2
2.- Dentro de cada Array instanciamos 'Mano.java'
    Solo tenemos que darle nombre

3.- Llamar método para generar aleatoriamente cartas
    Dentro de 'Mano.java' vamos a asignar las cartas aleatoriamente y descubrimos si par y juego o no

4.- Imprimimos
*/
public class Principal {
    public static void main(String[] args) {
        
        //Crear Array de 4 posiciones que guarden 4 manos
        Mano jugador[] = new Mano[4];
        
        //Instanciar del 0 al 3, poniendo sólo nombre
            //Y generar mano para cada uno
        for (int i = 0; i < jugador.length; i++) {
            jugador[i] = new Mano ("JUGADOR "+(i+1));
            jugador[i].generarMano();
        }
        
        //Imprimir
        imprimir(jugador);
    }//main
    
    /*====================================================================*/
    //Imprimir
    
    private static void imprimir(Mano jugador[]){
        System.out.println("SALIDA:");
        System.out.println("***************************************************************************************************");
        
        for (int i = 0; i < jugador.length; i++) {
            jugador[i].imprimirMano();
            if (i < (jugador.length-1))
                System.out.println("--------------------------------------------------------------------------------------------------");
        }
        System.out.println("***************************************************************************************************");
    }
    
}//Principal