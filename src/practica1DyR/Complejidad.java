package practica1DyR;
import java.util.Scanner;

public class Complejidad {
	
	private int iteraciones;
	private MatrizDeTiempos matriz;
	private VectorOrdenable vector;
	int maximo;
	
	public Complejidad(int n) {
		this.iteraciones =  n;
		
		String titulos [] = {"Burbuja Mejor","Burbuja Peor","Burbuja Intermedio","Seleccion Mejor","Seleccion Peor","Seleccion Intermedio","Mezcla Mejor","Mezcla Peor","Mezcla Intermedio"};
		this.matriz = new MatrizDeTiempos(n, titulos.length, titulos);
		
		//Pedimos el maximo de valores
		Scanner in = new Scanner (System.in);
		
		vector = new VectorOrdenable();
		
		
		do {
			System.out.print("Introduce el nº máximo de valores: ");
			maximo = Integer.parseInt(in.nextLine());
			
		}while(maximo <= 0);
		
		in.close();
	}
	
	public void ejecutarAlgoritmos() {
		
		for(int i = 0; i < iteraciones; i++) {
			
			//Burbuja Orden:
			vector.rellenaVectorEnOrden(i);
			matriz.asignaValor(i, 0, vector.ordenaPorBurbuja());
			//Burbuja Inverso:
			vector.rellenarVectorEnOrdenInverso(i);
			matriz.asignaValor(i, 1, vector.ordenaPorBurbuja());
			//Burbuja Aleatorio:
			vector.rellenarVectorAleatoriamente(i, maximo);
			matriz.asignaValor(i, 2, vector.ordenaPorBurbuja());
			
			//Seleccion Orden:
			vector.rellenaVectorEnOrden(i);
			matriz.asignaValor(i, 3, vector.ordenaPorSeleccionDirecta());
			//Seleccion Inverso:
			vector.rellenarVectorEnOrdenInverso(i);
			matriz.asignaValor(i, 4, vector.ordenaPorSeleccionDirecta());
			//Seleccion Aleatorio:
			vector.rellenarVectorAleatoriamente(i, maximo);
			matriz.asignaValor(i, 5, vector.ordenaPorSeleccionDirecta());
			
			//Mezcla Orden:
			vector.rellenaVectorEnOrden(i);
			matriz.asignaValor(i, 6, vector.ordenaPorMezcla());
			//Mezcla Inverso:
			vector.rellenarVectorEnOrdenInverso(i);
			matriz.asignaValor(i, 7, vector.ordenaPorMezcla());
			//Mezcla Aleatorio
			vector.rellenarVectorAleatoriamente(i, maximo);
			matriz.asignaValor(i, 8, vector.ordenaPorMezcla());
		}
	}
	
	public void imprimeTimepos() {
		this.matriz.imprimeTiempos();
	}
	
	public void guardarDatos(String filepath){
        this.matriz.guardaTiempos(filepath);
    }
}
