import java.util.concurrent.Semaphore;

public class Grupo extends Thread {
	Visitante[] visitante;
	Semaphore aforoMuseo;
	Semaphore[] aforoSalas;
	Museo museo;
	int grupo;
	
	Grupo(int grupo, int personas, Semaphore aforoMuseo, Semaphore[] aforoSalas, Museo museo) {
		visitante = new Visitante[personas];
		this.aforoMuseo = aforoMuseo;
		this.aforoSalas = aforoSalas;
		this.museo = museo;
		this.grupo = grupo;
	}
	
	public void run() {
		try {
			sleep(5000);
			for(int i = 0; i < visitante.length; i++) {
				visitante[i] = new Visitante(i+1, grupo, aforoMuseo, aforoSalas, museo);
				visitante[i].start();
			}
			
			for(int i = 0; i < visitante.length; i++) {
				try {
					visitante[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
