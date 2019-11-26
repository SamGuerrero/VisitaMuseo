/*Tiene los contadores.
 * 	De cada sala
 * 	del museo en total
 */
public class Museo {
	public VentanaControl ventanaControl;
	public int contMuseo; //Cuento el aforo total del museo
	public int[] contSala; //Cuento el aforo de cada sala
	public int aforoSala; //Este es el másximo de personas que caben en una sala
	
	//Constructor
	public Museo(int salas, int aforoSala, VentanaControl ventanaControl) {
		this.ventanaControl = ventanaControl;
		this.contMuseo = 0;
		this.aforoSala = aforoSala;
		contSala = new int[salas];
		for (int i = 0; i < salas; i++)
			contSala[i] = 0;
		
		ventanaControl.actualizaDatos(this.contMuseo, this.contSala, this.aforoSala);
	}
	
	
}
