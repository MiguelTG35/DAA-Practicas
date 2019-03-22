package Miguel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DS_Score
{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Recupero el numero de personajes.

        long[] numeros = new long[n];

        //Completamos cada personaje enemigo
        for (int i = 0; i<n; i++)
        {
            numeros[i] = sc.nextInt();
        }

        int numOledas = sc.nextInt();

        long[] nivelesHereo = new long[numOledas];
        for (int i =0; i< numOledas; i++)
        {
            nivelesHereo[i] = sc.nextInt();
        }

        for (int i = 0; i<numOledas; i++)
        {
            List<Long> bajasEnemigas = enemigosMuertos(numeros, nivelesHereo[i]);
            System.out.println(bajasEnemigas.size() + " " + sumaPuntos(bajasEnemigas));
        }


    }

    private static List<Long> enemigosMuertos(long[] enemigos, long nivelHeroe)
    {
        List<Long> bajasEnemigas = new ArrayList<>();

        int count = 0;

        while(enemigos.length > count && nivelHeroe >= enemigos[count])
        {
            bajasEnemigas.add(enemigos[count]);
            count++;
        }
        return bajasEnemigas;
    }

    private static long sumaPuntos(List<Long> numeros)
    {
        long suma = 0;
        for(int i=0; i<numeros.size(); i++)
        {
            suma += numeros.get(i);
        }
        return suma;
    }

}
