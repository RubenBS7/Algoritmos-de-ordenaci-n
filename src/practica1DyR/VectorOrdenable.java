package practica1DyR;
public class VectorOrdenable {
	
	private int numeroDeElementos;
	private volatile int[] vector;

	public void rellenaVectorEnOrden(int n) {
		
		this.numeroDeElementos = n;
		// Inicializamos el vector con N elementos.
		this.vector = new int[n];

		for (int i = 0; i < n; i++) {

			this.vector[i] = i + 1;
		}
	}

	public void rellenarVectorEnOrdenInverso(int n) {
		
		this.numeroDeElementos = n;
		// Inicializamos el vector con N elementos.
		this.vector = new int[n];

		int numero = n;
		for (int i = numero; i > 0; i--) {
			this.vector[numero - i] = i;
		}
	}

	public void rellenarVectorAleatoriamente(int n, int maximo) {
		
		this.numeroDeElementos = n;
		this.vector = new int[n];
		int valor;

		for (int i = 0; i < n; i++) {

			// Generamos un valor entre 1 y M (maximo)
			valor = (int) (Math.random() * maximo + 1);
			this.vector[i] = valor;
		}
	}

	public void imprimirVector() {
		System.out.print("[");
		for (int i = 0; i < this.numeroDeElementos; i++) {

			System.out.print(this.vector[i]);

			if (i != this.vector.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]\n");
	}

	public long ordenaPorBurbuja() {

		long comienzo = System.nanoTime();
		
		int n = this.vector.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (this.vector[j] > this.vector[j+1]) 
                { 
                    int temporal = this.vector[j]; 
                    this.vector[j] = this.vector[j+1]; 
                    this.vector[j+1] = temporal; 
                } 
		
		// Calculamos el timepo que tarda en realizar la ordenación
		long tiempoEjecución = (System.nanoTime() - comienzo);
		return tiempoEjecución;
	}

	public long ordenaPorSeleccionDirecta() {

		long comienzo = System.nanoTime();

		int n = this.vector.length;

		for (int i = 0; i < n - 1; i++) {
			int minimo_elemento = i;
			for (int j = i + 1; j < n; j++) {
				if (vector[j] < vector[minimo_elemento]) {
					minimo_elemento = j;
				}
			}
			int temporal = vector[minimo_elemento];
			vector[minimo_elemento] = vector[i];
			vector[i] = temporal;
		}

		long tiempoEjecución = (System.nanoTime() - comienzo);
		return tiempoEjecución;
	}

	public void merge(int arr[], int l, int m, int r) {

		// Busca el tamaño de 2 subArrays para ser fusuinados
		int n1 = m - l + 1;
		int n2 = r - m;

		// Arrays temporales
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copia los datos a los arrays temporales
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// Fusionamos los arrays temparales

		// Inicializamos los indices del primer y segundo subArray
		int i = 0, j = 0;

		// Inicializamos el indice del subarray mezclado
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		// Copiamos los elementos restantes de L[] si se cumple la condicion
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copiamos los elementos restantes de R[] si se cumple la condicion
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	
	public void sort(int arr[], int l, int r) {
		
		if (l < r) {	
            int m =l+ (r-l)/2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
	}
	
	public long ordenaPorMezcla() {
		long comienzo = System.nanoTime();
		
		sort(this.vector, 0,this.vector.length-1);

		long tiempoEjecución = (System.nanoTime() - comienzo);
		return tiempoEjecución;
	}

	public int[] getVector() {
		return vector;
	}
}
