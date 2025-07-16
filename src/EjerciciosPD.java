public class EjerciciosPD {

    public long getFinobanci(int n) {
        if (n <= 1) {
            return n;
        }
        return getFinobanci(n - 1) + getFinobanci(n - 2);
    }


    public long getFinobanciPD(int n) {
        long[] cache = new long[n + 1]; 
        return fibonacciMemoria(n, cache);
    }

    // Método auxiliar recursivo con memorización
    private long fibonacciMemoria(int n, long[] cache) {
        if (n <= 1) {
            return n;
        }

        if (cache[n] != 0) {
            return cache[n]; // Ya lo habíamos calculado
        }

        // Calculamos y guardamos el resultado
        cache[n] = fibonacciMemoria(n - 1, cache) + fibonacciMemoria(n - 2, cache);
        return cache[n];
    }
}