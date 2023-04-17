package Abierto.Reglafalsamejorada;

public class newReglaFalsa {

    // Función a evaluar f(x) = - x^3 - 10x + 9
    public static double f(double x) {
        return -Math.pow(x, 3) - 10 * x + 9;
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

    public void aceleracionAitkenBiseccion () {
        
    }

    public static void main(String[] args) {
        newReglaFalsa reglaFalsa = new newReglaFalsa();
        reglaFalsa.aceleracionAitken();

        }

}
