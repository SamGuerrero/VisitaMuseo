import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class VentanaControl extends JFrame{
	JLabel contMuseo = new JLabel("Gente en el museo: ");
	JLabel salasMuseo = new JLabel("Salas del museo: ");
	JLabel maxSala = new JLabel("Aforo máximo por sala: ");
	JLabel contSala = new JLabel("Gente en el museo: ");
	
	JLabel JTcontMuseo = new JLabel();
	JLabel JTsalasMuseo = new JLabel();
	JLabel JTmaxSala = new JLabel();
	JLabel[] JTcontSala;
	
	public VentanaControl(int numSalas){
		super("Ventana de Control del museo");
		this.setLayout(null);
		
		JTcontSala = new JLabel[numSalas];
		
		contMuseo.setBounds(20, 20, 150, 20);
		salasMuseo.setBounds(20, 40, 150, 20);
		maxSala.setBounds(20, 60, 150, 20);
		contSala.setBounds(20, 80, 150, 20);
		
		JTcontMuseo.setBounds(135, 20, 100, 20);
		JTsalasMuseo.setBounds(125, 40, 100, 20);
		JTmaxSala.setBounds(160, 60, 100, 20);
		
		int cont = 0;
		for (int i = 0; i < numSalas; i++) {
			JTcontSala[i].setBounds(50, 100 + cont, 100, 20);
			cont += 20;
			this.add(JTcontSala[i]);
		}
		
		this.add(contMuseo);
		this.add(salasMuseo);
		this.add(maxSala);
		this.add(contSala);
		
		this.add(JTcontMuseo);
		this.add(JTsalasMuseo);
		this.add(JTmaxSala);
		
		this.setSize(400, 200);
		this.setVisible(true);
		this.setLocation(1000, 0);
	}
	
	public void actualizaDatos(int contMuseoNuevo, int[] contSalaNuevo, int aforoSala){
		
		this.JTcontMuseo.setText(String.valueOf(contMuseoNuevo));
		this.JTsalasMuseo.setText(String.valueOf(contSalaNuevo.length));
		this.JTmaxSala.setText(String.valueOf(aforoSala));
		
		for (int i = 0; i < contSalaNuevo.length; i++) {
			this.JTcontSala[i].setText("Sala " + (i+1) + ": " + contSalaNuevo[i]);
		}
			
	}
}
