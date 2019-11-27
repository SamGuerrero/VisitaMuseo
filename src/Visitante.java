import java.util.concurrent.Semaphore;

public class Visitante extends Thread {
	String nombre;
	String grupo;
	Museo museo;
	Semaphore aforoMuseo;
	Semaphore[] aforoSalas;
	
	public Visitante(int nombre, int grupo, Semaphore aforoMuseo, Semaphore[] aforoSalas, Museo museo) {
		this.nombre = "Visitante " + nombre;
		this.grupo = "Grupo " + grupo;
		this.aforoMuseo = aforoMuseo;
		this.aforoSalas = aforoSalas;
		this.museo = museo;
	}

	public void run() {
		
		try {
			System.out.println("El " + this.nombre + " del " + grupo + " quiere entrar al museo");
			aforoMuseo.acquire(); //Compruebo el aforo del museo
			boolean entrada = museo.entradaDisponible();
			aforoMuseo.release();
			
			if (entrada){
				for (int i = 0; i <aforoSalas.length; i++) {
					aforoSalas[i].acquire(); //Comprueba el aforo de la sala para entrar
					museo.actualizaSala(i, true);
					
					System.out.println("El " + this.nombre + " del " + grupo + " entra en la sala" + (i+1));
					sleep((long) (Math.random() * 2000));
					
					museo.actualizaSala(i, false);
					aforoSalas[i].release(); //Libera la sala
					System.out.println("El " + this.nombre + " del " + grupo + " sale de la sala" + (i+1));
				}
				
				
				System.out.println("El " + this.nombre + " del " + grupo + " sale del museo");
				
			}else
				System.out.println("El " + this.nombre + " del " + grupo + " se qued� sin entrar al museo");
			
		}catch(InterruptedException ex) {
			System.err.println("Thread visitante interrumpido");
			System.exit(-1);
		}
	}
}
