package Cerrados.Secante;

public class secante {
    
    // funcion a evaluar f(x) = -3x^5 + 9x^4 + x -10
    public static double f(double x) {
        return -3 * Math.pow(x, 5) + 9 * Math.pow(x, 4) + x - 10;
    }

    public static void main(String[] args) {
        double x0 = 2; // intervalo inicial
        double x1 = 3; // intervalo final
        double tol = 0; // tolerancia
        double error = 1; // error relativo
        int iter = 0; // contador de iteraciones
        double x2 = 0; // valor de x2
        while (error > tol) {
            x2 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0)); // formula de la secante
            error = Math.abs(x2 - x1);
            x0 = x1;
            x1 = x2;
            iter++;
        }
        System.out.println("La raiz es: " + x2);
        System.out.println("El error relativo es de: " + error);
        System.out.println("El numero de iteraciones es: " + iter);
    
    }
}