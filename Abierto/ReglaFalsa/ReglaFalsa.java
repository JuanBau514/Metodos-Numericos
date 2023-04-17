package Abierto.ReglaFalsa;

public class ReglaFalsa {

    // Función a evaluar f(x) = ln(x²) - 2x³ - 6x
    public static double f(double x) {
        return Math.log(x*x) - 2*Math.pow(x,3) - 6*x;
    }

    // Método que encuentra la raíz de la función usando regla falsa
    public static double reglaFalsa(double a, double b, double error) {
        double c = 0;
        int iteraciones = 0;

        while (iteraciones < 1000) {
            double fa = f(a); // Valor de la función en el extremo inferior del intervalo izquierdo
            double fb = f(b); // Valor de la función en el extremo superior del intervalo derecho
            double fc = f(c); // Valor de la función en el punto medio del intervalo

            c = (a*fb - b*fa)/(fb - fa); // Valor de la función en el punto medio del intervalo

            if (Math.abs(fc) < error) { // Si el valor absoluto de la función en el punto medio del intervalo es menor a la tolerancia
                break;
            }

            if (fa * fc < 0) { // Si el producto de los valores de la función en los extremos del intervalo es menor a 0
                b = c;
            } else { // Si el producto de los valores de la función en los extremos del intervalo es mayor a 0
                a = c;
            }

            iteraciones++;
        }

        System.out.println("La raíz es: " + c);
        System.out.println("Iteraciones: " + iteraciones);
        System.out.println("El error relativo es de: " + error);

        return c;
    }

    public static void main(String[] args) {
        reglaFalsa(0.5, -1, 1e-12);
    }
}
