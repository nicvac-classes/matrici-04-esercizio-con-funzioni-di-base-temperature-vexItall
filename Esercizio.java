//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    public static Scanner in = new Scanner( System.in );
    public static Random random = new Random();

    //Valori multipli di ritorno per il metodo calcolaMassimo
    public static record Max(int massimo, int rIdx, int cIdx) { }

    // Metodo per calcolare il massimo nella matrice
    public static Max calcolaMassimo(int[][] M, int nR, int nC) {
        //SCRIVERE QUI IL CODICE RICHIESTO DALL'ESERCIZIO

        int massimo = 0;
        int maxR = 0;
        int maxC = 0;

        for(int i = 0; i < nR; ++i){
            for(int j = 0; j < nC; ++j){
                if(M[i][j] > massimo){
                    massimo = M[i][j];
                    maxR = i;
                    maxC = j;
                }
            }
        }

        return new Max(massimo, maxR, maxC);

    }

    // Metodo per calcolare la media di una colonna
    public static float calcolaMedia(int[][] M, int nR, int iC) {
        
        float somma = 0;
        
        for(int i = 0; i < nR; ++i){
            somma += M[i][iC];
        }

        float media = somma / nR;

        return media;
    }

    // Metodo per riempire la matrice con valori casuali
    // Già risolto nell'esercizio precedente
    public static void riempiCasuale( int[][] M, int RIGHE, int COLONNE, int valMin, int valMax) {
        Random rand = new Random();
        for (int i=0; i <= RIGHE-1; i=i+1 ) {
            for (int j=0; j <= COLONNE-1; j=j+1) {
                M[i][j] = valMin + rand.nextInt((valMax+1)-valMin);
            }
        }
    }

    public static void main(String args[]) {
        //SCRIVERE QUI IL CODICE RICHIESTO DALL'ESERCIZIO

        int[][] M = new int[7][5];

        int nR = 7;
        int nC = 5;

        riempiCasuale(M, nR, nC, 280, 300);

        UtilsMatrice.visualizza(M);

        System.out.println();

        Max max = calcolaMassimo(M, nR, nC);

        System.out.println("Temperatura massima: " + max.massimo + "°");
        System.out.println("Giorno: " + max.rIdx + "°");
        System.out.println("Fascia oraria: " + max.cIdx + "°");

        System.out.println();

        float[] Vm = new float[nC];

        for(int j = 0; j < nC; ++j){
            Vm[j] = calcolaMedia(M, nR, j);
        }

        System.out.println("Temperature medie per fasce orarie: ");
        
        for(int i = 0; i < Vm.length; ++i){
            System.out.println((i+1) + "° : " + Vm[i]);
        }

    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md