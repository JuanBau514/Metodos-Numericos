from matplotlib.pyplot import *
from numpy import *


# Funcion para calcular la integral de la funcion usando metodo del trapecio 
def trapecio(f, a, b, n):
    """
    Calcula la aproximación de la integral definida de f(x) en el intervalo [a, b]
    utilizando el método del trapecio con n subintervalos.
    
    Parámetros:
    - f: Función a integrar. Debe ser una función de una variable.
    - a: Límite inferior de integración.
    - b: Límite superior de integración.
    - n: Número de subintervalos.
    
    Retorna:
    - Aproximación de la integral definida.
    """
    h = (b - a) / n  # Tamaño del subintervalo
    s = 0  # Variable para almacenar la sumatoria
    
    # Suma de los valores de f(x) en los puntos intermedios
    for i in range(n):
        s += f(a + i * h)
    
    integral = s * h
    return integral

# Funcion para calcular la integral de la funcion usando metodo de simpson
def simpson(f, a, b, n):
    """
    Calcula la aproximación de la integral definida de f(x) en el intervalo [a, b]
    utilizando el método de Simpson con n subintervalos.
    
    Parámetros:
    - f: Función a integrar. Debe ser una función de una variable.
    - a: Límite inferior de integración.
    - b: Límite superior de integración.
    - n: Número de subintervalos. IMPORTANTE Debe ser un número par.
    
    Retorna:
    - Aproximación de la integral definida.
    """
    h = (b - a) / n  # Tamaño del subintervalo
    sumatoria = f(a) + f(b)
    
    # Suma de los términos impares
    for i in range(1, n, 2):
        x = a + i * h
        sumatoria += 4 * f(x)
    
    # Suma de los términos pares
    for i in range(2, n-1, 2):
        x = a + i * h
        sumatoria += 2 * f(x)
    
    integral = (h / 3) * sumatoria
    return integral


def main():

    def f(x):
        return x**2

    a = 0
    b = 1
    n = 40 # Si se va a usar el metodo de simpson, n debe ser par

    resultado = simpson(f, a, b, n)
    print("Valor de la integral:", resultado)

    # Crear arreglo de puntos para graficar la función
    x = linspace(a-1, b+1, 1000)
    y = f(x)

    # Graficar la función
    plot(x, y, 'b', label='f(x)')

    # Crear los intervalos como barras
    for i in range(n):
        x_intervalo = [a + i * (b - a) / n, a + (i + 1) * (b - a) / n]
        y_intervalo = [f(x_intervalo[0]), f(x_intervalo[1])]
        bar(x_intervalo, y_intervalo, width=(b - a) / n, align='edge', alpha=0.3, color='lightblue', edgecolor='blue')

    legend()
    grid()
    show()


if __name__ == '__main__':
    main()