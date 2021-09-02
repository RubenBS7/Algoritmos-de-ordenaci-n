package practica1DyR;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class MatrizDeTiempos {

	private int NumFilas;
	private int NumCol;
	private long matriz[][];
	private String titulos[];

	public MatrizDeTiempos(int numFilas, int numCol, String titulos[]) {
		
		//Inicializamos la matriz con el nº de filas y columnas.
		this.matriz = new long[numFilas][numCol];
		
		this.NumFilas = numFilas;
		this.NumCol = numCol;
		this.titulos = titulos;
	}

	public void asignaValor(int numFilas, int numCol, long dato) {
		
		this.matriz[numFilas][numCol] = dato;
	}

	public void imprimeTiempos() {
		
		System.out.println("MATRIZ DE TIEMPOS (ns):");
		for(int i = 0; i<NumFilas; i++){
            System.out.print("Iteración nº "+(i+1)+" | ");
            for(int j = 0; j < NumCol; j++){
                System.out.print(" " +matriz[i][j]+ " ");
            }
        System.out.println(" |");
        }
	}

	public void guardaTiempos(String OutputFilePath) {
		
		try (BufferedWriter w = new BufferedWriter(new FileWriter(OutputFilePath))) {
			String cabecera = "";
			for (int i = 0; i < this.getTitulos().length; i++) {
				cabecera += this.getTitulos()[i] + ";";
			}
			cabecera += "\n";
			w.write(cabecera);
			String integerFormat = "%8d;";
			for (int i = 0; i < this.getNumFilas(); i++) {
				String fila = "";
				for (int j = 0; j < this.getNumCol(); j++) {
					fila += String.format(integerFormat, this.matriz[i][j]);
				}
				fila += "\n";
				w.write(fila);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getNumFilas() {
		return NumFilas;
	}

	public int getNumCol() {
		return NumCol;
	}

	public String[] getTitulos() {
		return titulos;
	}
}
