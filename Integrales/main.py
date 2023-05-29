import random
import matplotlib.pyplot as plt
import numpy as np
from scipy.integrate import quad
import random


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
    - Porcentaje de error relativo.
    - Porcentaje de error absoluto.
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

    # Calcular el porcentaje de error relativo y absoluto
    integral_exacta = quad(f, a, b)[0]
    error_relativo = abs((integral - integral_exacta) / integral_exacta) * 100
    error_absoluto = abs(integral - integral_exacta)

    # Crear arreglo de puntos para graficar la función
    x = np.linspace(a-1, b+1, 1000)
    y = f(x)

    # Graficar la función
    plt.plot(x, y, 'b', label='f(x)')
    plt.fill_between(x, y, alpha=0.2, color='green')

    # Graficar los intervalos como rectángulos
    x_intervalos = np.linspace(a, b, n+1)
    for i in range(n):
        intervalo = [x_intervalos[i], x_intervalos[i+1], x_intervalos[i+1], x_intervalos[i], x_intervalos[i]]
        y_intervalo = [0, f(x_intervalos[i]), f(x_intervalos[i+1]), 0, 0]
        plt.bar(x_intervalos[i], f(x_intervalos[i]), width=h, bottom=0, alpha=0.2, color='green')
    
    plt.xlabel('x')
    plt.ylabel('f(x)')
    plt.title('Método de Simpson')
    plt.legend()
    plt.grid()

    plt.show()

    return integral, error_relativo, error_absoluto

def monte_carlo_integration(f, a, b, n):
    """
    Calcula la aproximación de la integral definida de f(x) en el intervalo [a, b]
    utilizando el método de cuadratura de Monte Carlo con n puntos aleatorios.
    
    Parámetros:
    - f: Función a integrar. Debe ser una función de una variable.
    - a: Límite inferior de integración.
    - b: Límite superior de integración.
    - n: Número de puntos aleatorios a generar.
    
    Retorna:
    - Aproximación de la integral definida.
    - Porcentaje de error relativo.
    - Porcentaje de error absoluto.
    """
    # Crear arreglo de puntos para graficar la función
    x = np.linspace(a - 1, b + 1, 1000)
    y = f(x)

    # Graficar la función
    plt.plot(x, y, 'b', label='f(x)')

    # Generar puntos aleatorios y subintervalos
    points = []
    intervals = []
    for i in range(n):
        x = random.uniform(a, b)
        points.append(x)
        interval = (a + i * (b - a) / n, a + (i + 1) * (b - a) / n)
        intervals.append(interval)

    # Graficar los puntos aleatorios y subintervalos
    plt.scatter(points, [0] * n, color='red', marker='o', label='Puntos Aleatorios')
    for interval in intervals:
        x_intervalo = [interval[0], interval[1], interval[1], interval[0], interval[0]]
        y_intervalo = [0, 0, f(interval[1]), f(interval[1]), 0]
        plt.plot(x_intervalo, y_intervalo, color='blue')

    plt.legend()
    plt.grid()
    plt.show()

    total = 0
    for _ in range(n):
        x = random.uniform(a, b)
        total += f(x)
    
    integral = (b - a) * (total / n)

    # Calcular el porcentaje de error relativo y absoluto
    integral_exacta = quad(f, a, b)[0]
    error_relativo = abs((integral - integral_exacta) / integral_exacta) * 100
    error_absoluto = abs(integral - integral_exacta)

    return integral, error_relativo, error_absoluto


def main():

    def f(x):
        return x**2

    a = -2
    b = 1
    n = 1000

    resultado = simpson(f, a, b, n)
    print("Valor de la integral:", resultado)

if __name__ == '__main__':
    main()