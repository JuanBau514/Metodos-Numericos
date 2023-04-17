package Abierto.Biseccion;

public class Biseccion {
    

        // Función a evaluar
        public static double f(double x) {
            return Math.log(x*x) - 2 * Math.pow(x, 3) - 6 * x;
        }
    
        // Método que encuentra la raíz de la función utilizando el método de bisección
        public static double biseccion(double a, double b, double error) {
            double c = 0;
            int iteraciones = 0;
    
            while (Math.abs(b - a) > error) {
                c = (a + b) / 2;
                double fc = f(c); // Valor de la función en el punto medio del intervalo
                if (fc == 0) { // Si el valor absoluto de la función en el punto medio del intervalo es menor a la tolerancia
                    break; // Se detiene el ciclo
                }
                if (f(a) * fc < 0) { // Si el producto de los valores de la función en los extremos del intervalo es menor a 0
                    b = c; // El extremo superior del intervalo se mueve al punto medio
                } else {
                    a = c; // El extremo inferior del intervalo se mueve al punto medio
                }
                iteraciones++;
            }
            System.out.println("La raiz es: " + c);
            System.out.println("Iteraciones: " + iteraciones);
            System.out.println("El Error relativo es de: " + error);
            return c;
        }
    
        public static void main(String[] args) {
            double a = 1.5; // Extremo superior del intervalo
            double b = -0.5; // Extremo inferior del intervalo
            double error = 1e-12; // Error relativo
            biseccion(a, b, error);
        }
}
