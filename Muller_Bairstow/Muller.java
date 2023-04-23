package Muller_Bairstow;

// Realizado por Juan Pablo Bautista CLavijo 20211578104 y Jhoan Stik Hernández García 20212578003

public class Muller {

    public static double f(double x) {
         return 2*Math.pow(x, 5) - 4*Math.pow(x, 3) + x - 12;
     }
    public static double muller(double a, double b, double c, double d, double x0, double x1, double x2, double tolerance, int maxIterations) {
         double h0, h1, delta0, delta1, aVal, bVal, cVal, R, x3, fx3;
         for (int i = 0; i < maxIterations; i++) {
             h0 = x1 - x0;
             h1 = x2 - x1;
             delta0 = (f(x1) - f(x0))/h0;
             delta1 = (f(x2) - f(x1))/h1;
             aVal = (delta1 - delta0)/(h1 + h0);
             bVal = aVal*h1 + delta1;
             cVal = f(x2);
             R = Math.sqrt(Math.pow(bVal, 2) - 4*aVal*cVal);
             double denominator = (bVal < 0) ? bVal - R : bVal + R;
             x3 = x2 - (2*cVal/denominator);
             fx3 = f(x3);
             if (Math.abs(fx3) < tolerance) {
                 return x3;
             }
             x0 = x1;
             x1 = x2;
             x2 = x3;
             int cantIteraciones = i + 1;
             System.out.println("la cantidad de iteraciones para encontrar la raiz usando el metodo de muller es: " + cantIteraciones+ " iteraciones");
         }
        return x2;
     }

     public static void main(String[] args) {
         double x0 = 1;
         double x1 = 1.5;
         double x2 = 2;
         double tolerance = 0.0001;
         int maxIterations = 100;
         double x3 = muller(2, -4, 1, -12, x0, x1, x2, tolerance, maxIterations);
         System.out.println("La raiz del polinomio es: " + x3);
     } 
 }