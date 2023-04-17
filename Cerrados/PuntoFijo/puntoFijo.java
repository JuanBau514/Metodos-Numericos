package Cerrados.PuntoFijo;

public class puntoFijo {

     // funcion a evaluar f(x) = -3x^5 + 9x^4 + x -10
     public static double f(double x) {
        return -3 * Math.pow(x, 5) + 9 * Math.pow(x, 4) + x - 10;
    }

    public static void main(String[] args) {
        double x0 = -1; // intervalo inicial izquierda
        double x1 = 0; // intervalo final derecha
        double tol = 0; // tolerancia
        double error = 1; // error relativo
        int iter = 0; // contador de iteraciones
        double x2 = 0; // valor de x2 (punto fijo entre x0 y x1)
        while (error > tol) {
            x2 = (x0 + x1) / 2; // punto fijo
            if (f(x0) * f(x2) < 0) {
                x1 = x2;
            } else {
                x0 = x2;
            }
            error = Math.abs(x2 - x1);
            iter++;
        }
        System.out.println("La raiz es: " + x2);
        System.out.println("El error relativo es de: " + error);
        System.out.println("El numero de iteraciones es: " + iter);
    }
}
