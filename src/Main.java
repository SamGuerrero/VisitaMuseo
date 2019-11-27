import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		final int limiteMuseo = 50;
		final int M = 15;
		final int N = 3;
		
		Museo museo = new Museo(limiteMuseo, M, N);
		
		Semaphore aforoMuseo = new Semaphore(1); //Van comprobando la entrada de 1 en 1
		Semaphore[] aforoSalas = new Semaphore[N];
		for (int i = 0; i < N; i++)
			aforoSalas[i] = new Semaphore(M); //N Salas. M personas por sala
		
		Semaphore[] controlSalas = new Semaphore[N];
		for (int i = 0; i < N; i++)
			controlSalas[i] = new Semaphore(1); //Controla que actualizan la sala de uno en uno
		
		
		
		Grupo[] grupo = new Grupo[5]; //Salen 5 grupos de 15 personas
		for(int i = 0; i < grupo.length; i++) {
			grupo[i] = new Grupo(i+1, 15, aforoMuseo, aforoSalas, controlSalas, museo);
			grupo[i].start();
		}
		
		for(int i = 0; i < grupo.length; i++) {
			try {
				grupo[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n\nNúmero de visitantes total: " + museo.visitantesTotal);
		System.out.println("Número de visitantes que han entrado al museo: " + museo.visitantesEntran);
		System.out.print("Número de visitantes que no han podido entrar al museo: " + (museo.visitantesTotal - museo.visitantesEntran));
	}

}
