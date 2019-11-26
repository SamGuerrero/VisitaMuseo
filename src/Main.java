
public class Main {

	public static void main(String[] args) {
		VentanaControl ventanaControl = new VentanaControl(15);
		Museo museo = new Museo(3, 15, ventanaControl); //3 Salas. 15 personas por sala
		
		//String nombreVisitante;
		
		/*
		int n_personas = 20;
		for(int i = 0; i < n_personas; i++) {
			nombreVisitante = "Visitante - " + (i+1);
			new Visitante(nombreVisitante, entrada).start();
		}
		*/
	}

}
