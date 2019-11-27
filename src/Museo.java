/*Tiene los contadores.
 * 	De cada sala
 * 	del museo en total
 */
public class Museo {
	public int limiteMuseo; //Cuento el l�mite del museo
	public int visitantesTotal; //Cu�nta gente ha visitado el museo
	public int visitantesEntran;
	public int visitantesActual;
	public VentanaControl ventana;
	public int[] genteEnSalas = new int[3];
	
	//Constructor
	public Museo(int limiteMuseo, int aforoSalas) {
		this.limiteMuseo = limiteMuseo;
		this.visitantesTotal = 0;
		this.visitantesEntran = 0;
		this.visitantesActual = 0;
		this.ventana = new VentanaControl(aforoSalas, 3);
		
		for (int i = 0; i < 3; i++)
			genteEnSalas[i] = 0;
		
		ventana.actualizaDatos(visitantesActual, genteEnSalas);
	}
	
	public boolean entradaDisponible() {
		visitantesTotal++;
		if (limiteMuseo > 0) {
			visitantesEntran++;
			limiteMuseo--;
			return true;
		}else {
			return false;
		}
	}
	
	public void actualizaSala(int i, boolean entra) {
		if (entra) {
			if (i == 0)
				visitantesActual++;
			genteEnSalas[i]++;
		}else {
			if (i == 2)
				visitantesActual--;
			genteEnSalas[i]--;
		}
		
		ventana.actualizaDatos(visitantesActual, genteEnSalas);
	}
	
	
}
