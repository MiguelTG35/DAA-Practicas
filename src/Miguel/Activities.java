package Miguel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Activities
{

    // Prints a maximum set of activities that can be done by a single
    // person, one at a time.
    // n   -->  Total number of activities
    // s[] -->  An array that contains start time of all activities
    // f[] -->  An array that contains finish time of all activities
    public static void printMaxActivities(int s[], int f[], int n)
    {
        int i, j;

        // The first activity always gets selected
        i = 0;
        System.out.print(i + " ");

        int count = 0;
        // Consider rest of the activities
        for (j = 1; j < n; j++) {
            // If this activity has start time greater than or
            // equal to the finish time of previously selected
            // activity, then select it
            if (s[j] >= f[i]) {
                System.out.print(j + " ");
                i = j;
                count++;
            }
        }
        System.out.println(count);
    }

    // driver program to test above function
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Numero de casos que se van a crear

        List<Actividad> listaCasos = new ArrayList<>();
        //Ejecutamos los casos
        for (int i = 0; i < n; i++)
        {
            Scanner sc2 = new Scanner(System.in);
            //Recuperamos el tamaño de las actividades por cada caso.
            int tamActividad = sc2.nextInt();

            //Leo la cadena como un string para tener todos los numeros
            Scanner sc3 = new Scanner((System.in));
            String strFirstLine = sc3.nextLine();

            //Lo convierto a un string
            String[] items = strFirstLine.split(" ");

            //Inicializamos los arrays con el tamaño requerido
            int inicios[] = new int[tamActividad];
            int finales[] = new int[tamActividad];

            int contadorInicio = 0;
            int contadorFinal = 0;
            for(int j = 0; j< items.length; j++)
            {
                //Indice impar
                if (j%2 != 0)
                {
                inicios[contadorInicio] = Integer.parseInt(items[j]);
                contadorInicio++;
                }
                else //Indice es par.
                {
                    finales[contadorFinal] = Integer.parseInt(items[j]);
                    contadorFinal++;
                }
            }

            Actividad actividad = new Actividad(inicios, finales);

            listaCasos.add(actividad);
        }

        for (int i = 0; i < listaCasos.size(); i++)
        {
            printMaxActivities(listaCasos.get(i).getInicios(), listaCasos.get(i).getFinales(), n);

        }

    }

    public static class Actividad
    {
        private int[] inicios;
        private int[] finales;

        public Actividad(int[] inicios, int[] finales) {
            this.inicios = inicios;
            this.finales = finales;
        }

        public int[] getInicios() {
            return inicios;
        }

        public int[] getFinales() {
            return finales;
        }
    }

}
