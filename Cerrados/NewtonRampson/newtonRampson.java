package Cerrados.NewtonRampson;

public class newtonRampson {
     // funcion a evaluar f(x) = -3x^5 + 9x^4 + x -10
     public static double f(double x) {
        return -3 * Math.pow(x, 5) + 9 * Math.pow(x, 4) + x - 10;
    }

    // derivada de la funcion f(x) = -3x^5 + 9x^4 + x -10
    public static double df(double x) {
        return -15 * Math.pow(x, 4) + 36 * Math.pow(x, 3) + 1;
    }

    public static void main(String[] args) {
        double x0 = 3; // intervalo inicial
        double tol = 0; // tolerancia
        double error = 1; // error relativo
        int iter = 0; // contador de iteraciones
        double x1 = 0; // valor de x1
        // newton-rampson no necesita un intervalo porque ya debe tener f(x) Derivada
        // solo se nesesita un valor inicial para empezar a iterar
        while (error > tol) {
            x1 = x0 - (f(x0) / df(x0)); // formula de newton-rampson
            error = Math.abs(x1 - x0);
            x0 = x1;
            iter++;
        }
        System.out.println("La raiz es: " + x1);
        System.out.println("El error relativo es de: " + error);
        System.out.println("El numero de iteraciones es: " + iter);
    }
}
