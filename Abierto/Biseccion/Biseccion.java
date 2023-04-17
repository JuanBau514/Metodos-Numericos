package Abierto.Biseccion;

public class Biseccion {
    
    // funcion a evaluar f(x) = in(x²)+2x³-6x
    public static double f(double x) {
        return Math.sin(x) + 2 * Math.pow(x, 3) - 6 * x;
    }

    public static void main(String[] args) {
        double a = 0, b = 1, c = 0, error = 0;
        int iteraciones = 0;
        while (Math.abs(b - a) > error) {
            c = (a + b) / 2; // metodo de biseccion
            if (f(a) * f(c) < 0) {
                b = c;
            } else {
                a = c;
            }
            iteraciones++;
        }
        System.out.println("La raiz es: " + c);
        System.out.println("Iteraciones: " + iteraciones);
        System.out.println("El Error relativo es de: " + error);
    }
    
}
