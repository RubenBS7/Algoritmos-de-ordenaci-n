package practica1DyR;
public abstract class Principal {
	
	public static void main(String[] args) {
			
		//Inicializo el nº de iteraciones.
		int iteraciones = 500;
		
		try {
			iteraciones = Integer.parseInt(args[0]);
		} catch (Exception e) {
		}
		
		//Creo un objeto de la clase Complejidad e invoco los metodos 
		Complejidad c = new Complejidad(iteraciones);
		c.ejecutarAlgoritmos();
		c.imprimeTimepos();
		c.guardarDatos("tiemposV.csv");	
	}
}
