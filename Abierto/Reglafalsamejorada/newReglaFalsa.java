package Abierto.Reglafalsamejorada;

public class newReglaFalsa {

    // Función a evaluar f(x) = - x^3 - 10x + 9
    public static double f(double x) {
        return -Math.pow(x, 3) - 10 * x + 9;
    } 

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

    public void aceleracionAitken () {
        double x0 = 0; // intervalo inicial derecho
        double x2 = 0; // valor intermedio entre los intervalos
        double x1 = 1; // intervalo final izquierdo
        double errorEsperado = 0; // tolerancia
        double error = 1; // error relativo
        int iter = 0; // contador de iteraciones
        double tol = 1e-16; // tolerancia
        while (error > errorEsperado) {
            x2 = (x0 + x1) / 2; // valor intermedio entre los intervalos
            if (f(x0) * f(x2) < 0) {
                x1 = x2;
            } else {
                x0 = x2;
            }
            error = Math.abs(x1 - x0);
            iter++;
            if (error < tol) {
                break;
            }
            if (iter > 10000) {
                System.out.println("se pudo encontrar la raiz");
                break;
            }
        }

        System.out.println("La raiz es: " + x1);
        System.out.println("El error relativo es de: " + error);
        System.out.println("El numero de iteraciones es: " + iter);
    }

    public static void main(String[] args) {
        newReglaFalsa reglaFalsa = new newReglaFalsa();
        reglaFalsa.aceleracionAitken();
        reglaFalsa.reglaFalsa(0.5, -1, 0);
        }
}
