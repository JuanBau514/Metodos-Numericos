package Abierto.MaximoDeUnaFuncion;

public class maxFuncion {

    // funcion a evaluar f(x) = -2x⁶ - 1.5x³ + 10x + 2
    public static double f(double x) {
        return -2 * Math.pow(x, 6) - 1.5 * Math.pow(x, 3) + 10 * x + 2;
    }

    // funcion derivada de f'(x) = -12x⁵ - 4.5x² + 10
    public static double fDerivada(double x) {
        return -12 * Math.pow(x, 5) - 4.5 * Math.pow(x, 2) + 10;
    }

    // segunda derivada de f''(x) = -60x⁴ - 9x
    public static double fSegundaDerivada(double x) {
        return -60 * Math.pow(x, 4) - 9 * x;
    }
    
    public static void main(String[] args) {

        double x0 = -1; // intervalo inicial
        double tol = 0; // tolerancia
        double error = 1; // error relativo
        int iter = 0; // contador de iteraciones
        double x1 = 2; // valor de x1
        while (error > tol) {
            x1 = x0 - (f(x0) / fDerivada(x0)); // formula para encontrar la raiz usando newton-rampson
            error = Math.abs(x1 - x0);
            x0 = x1;
            iter++;
        }
        System.out.println("La raiz es: " + x1);
        System.out.println("El error relativo es de: " + error);
        System.out.println("El numero de iteraciones es: " + iter);

        // encontrando el maximo o extremo de la funcion
        double x2 = -1; // intervalo a la izquierda a evaluar
        double x3 = 2; // intervalo a la derecha a evaluar

        // si la segunda derivada es menor a 0 entonces el maximo entonces el maximo esta entre x1 y x2
        if (fSegundaDerivada(x1) < 0) {
            System.out.println("El maximo esta entre " + x2 + " y " + x1);
        } else {
            System.out.println("El maximo esta entre " + x1 + " y " + x3);
        }
        System.out.println();

        // Encontrando el valor punto donde se encuentra el maximo
        double x4 = 0; // valor de x4
        double x5 = 0; // valor de x5
        if(fSegundaDerivada(x1) < 0){
            x4 = (x2 + x1) / 2;
        }else{
            x4 = (x1 + x3) / 2;
        }
        System.out.println("El valor del punto maximo en x es : " + x4);
        x5 = f(x4);
        System.out.println("El valor del punto maximo en y es : " + x5);
        
    }
}

