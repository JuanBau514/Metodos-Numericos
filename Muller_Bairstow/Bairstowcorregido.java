public class Bairstowcorregido {
    public static void main(String[] args) {
        double coeficientes [] = {2, 0, -4, 0 , 1 ,-12}; // f(x) = 2x^5 - 4x^3 + x - 12
        double b [], c[];
        b = new double[coeficientes.length];
        c = new double[coeficientes.length];
        double r = 1, s = 1, d_r, d_s, r_1, r_2; // r_1 y r_2 son los valores de r y s de la iteracion anterior
        double error = Math.pow(10, -12), e_r=1, e_s=1; // el error deseado del metodo es de 10^-12
        int iteracion = 100000, n, i, j=0; // iteraciones del metodo
        n = coeficientes.length - 1;
        b[0] = 1;
        while(j<iteracion && b[0]!=0 && e_r>error && e_s>error){
            r_1 = r;
            r_2 = s;
            b[1] = coeficientes[1] - r*b[0]; 
            for(i=2; i<=n; i++){
                b[i] = coeficientes[i] - r*b[i-1] - s*b[i-2]; // division sintetica del polinomio
            }
            c[2] = b[2];
            c[3] = b[3] - r*c[2];
            for(i=4; i<=n; i++){ // i=4 porque el polinomio tiene grado 5 y cuando se divide sinteticamente solo se obtine un polinomio de grado 4 o menor
                c[i] = b[i] - r*c[i-1] - s*c[i-2]; // division sintetica del polinomio
            }
            d_r = (c[n-1]*b[n] - c[n]*b[n-1])/(c[n-1]*c[n-3] - c[n-2]*c[n-2]); // dr = (cnbn-1 - cncn-1)/(cn-1cn-3 - cn-2cn-2)
            d_s = (c[n]*b[n-1] - c[n-1]*b[n])/(c[n-1]*c[n-3] - c[n-2]*c[n-2]); // ds = (cncn-1 - cn-1bn)/(cn-1cn-3 - cn-2cn-2)
            r = r + d_r;
            s = s + d_s;
            e_r = Math.abs(r - r_1);
            e_s = Math.abs(s - r_2);
            j++;
        }
        

        r_1 = (r + Math.pow(r*r + 4 *s , 0.5))/2;
        r_2 = (r - Math.pow(r*r + 4 *s , 0.5))/2;
        
        System.out.println("\n"+"El polinomio evaluado es f(x) = 2x^5 - 4x^3 + x - 12");
        System.out.println("La raiz 1 es: " + r_1 + " parte real de la raiz imaginaria en el polinomio "); // raiz compleja
        System.out.println("La raiz 2 es: " + r_2 + "Raiz real del polinomio"+ "\n"); // raiz real
        System.out.println("El error del metodo es: " + error );
        System.out.println("La cantidad de iteraciones es: " + j + "\n");

        System.out.println("Polinomio factorizado es "); 
        System.out.println("f(x) = (x - " + r_1 + ")(x - " + r_2 + ")(x^2 + " + r + "x + " + s + ")");
        

    }
}
