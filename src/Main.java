import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		final int limiteMuseo = 25;
		final int M = 5;
		final int N = 5;
		
		Museo museo = new Museo(limiteMuseo, M, N);
		
		Semaphore aforoMuseo = new Semaphore(1); //Van comprobando la entrada al museo de 1 en 1
		Semaphore[] aforoSalas = new Semaphore[N]; //N Salas. M personas por sala
		for (int i = 0; i < N; i++)
			aforoSalas[i] = new Semaphore(M);
		
		Semaphore[] controlSalas = new Semaphore[N]; //Controla que actualizan las salas de uno en uno
		for (int i = 0; i < N; i++)
			controlSalas[i] = new Semaphore(1);
		
		Grupo[] grupo = new Grupo[50]; //Salen 5 grupos de 15 personas
		for(int i = 0; i < grupo.length; i++) {
			grupo[i] = new Grupo(i+1, 1, aforoMuseo, aforoSalas, controlSalas, museo);
			grupo[i].start();
		}
		
		for(int i = 0; i < grupo.length; i++) {
			try {
				grupo[i].join();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n\nNúmero de visitantes total: " + museo.visitantesTotal);
		System.out.println("Número de visitantes que han entrado al museo: " + museo.visitantesEntran);
		System.out.print("Número de visitantes que no han podido entrar al museo: " + (museo.visitantesTotal - museo.visitantesEntran));
	}
}
