
public class Museo {
	public int limiteMuseo; //Cuento el límite del museo
	public int visitantesTotal; //Cuánta gente ha intentado visitar el museo
	public int visitantesEntran; //Gente que entra
	public int visitantesActual; //gente en el museo en directo
	public VentanaControl ventana;
	public int[] genteEnSalas; //Gente por sala en directo
	
	//Constructor
	public Museo(int limiteMuseo, int aforoSalas, int salas) {
		this.limiteMuseo = limiteMuseo;
		this.visitantesTotal = 0;
		this.visitantesEntran = 0;
		this.visitantesActual = 0;
		this.ventana = new VentanaControl(aforoSalas, salas);
		
		this.genteEnSalas = new int[salas];
		for (int i = 0; i < salas; i++)
			genteEnSalas[i] = 0;
		
		ventana.actualizaDatos(visitantesActual, genteEnSalas);
	}
	
	public boolean entradaDisponible() {
		visitantesTotal++;
		if (visitantesEntran < limiteMuseo) {
			visitantesEntran++;
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
			if (i == genteEnSalas.length -1)
				visitantesActual--;
			genteEnSalas[i]--;
		}
		
		ventana.actualizaDatos(visitantesActual, genteEnSalas);
	}
	
	
}
