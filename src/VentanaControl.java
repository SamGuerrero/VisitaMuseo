import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaControl{
	private JFrame ventana = new JFrame();
	
	JLabel contMuseo = new JLabel("Gente en el museo: ");
	JLabel salasMuseo = new JLabel("Salas del museo: ");
	JLabel maxSala = new JLabel("Aforo máximo por sala: ");
	JLabel contSala = new JLabel("Gente en el museo: ");
	
	JLabel JTcontMuseo = new JLabel();
	JLabel JTsalasMuseo = new JLabel();
	JLabel JTmaxSala = new JLabel();
	
	JLabel[] aforoSalas;
	
	public VentanaControl(int aforoSala, int salas){
		ventana.setTitle("Ventana de Control del museo");
		ventana.setLayout(null);
		

		JTmaxSala.setText(Integer.toString(aforoSala));

		JTsalasMuseo.setText(Integer.toString(salas));
		
		contMuseo.setBounds(20, 20, 150, 20);
		salasMuseo.setBounds(20, 40, 150, 20);
		maxSala.setBounds(20, 60, 150, 20);
		contSala.setBounds(20, 80, 150, 20);
		
		JTcontMuseo.setBounds(135, 20, 100, 20);
		JTsalasMuseo.setBounds(125, 40, 100, 20);
		JTmaxSala.setBounds(160, 60, 100, 20);
		
		int cont = 100;
		aforoSalas = new JLabel[salas];
		for (int i = 0; i < salas; i++) {
			aforoSalas[i] = new JLabel("Sala " + (i+1) + ": 0");
			aforoSalas[i].setBounds(140, cont, 100, 20);
			cont += 20;
			ventana.add(aforoSalas[i]);
		}
		
		
		ventana.add(contMuseo);
		ventana.add(salasMuseo);
		ventana.add(maxSala);
		ventana.add(contSala);
		
		ventana.add(JTcontMuseo);
		ventana.add(JTsalasMuseo);
		ventana.add(JTmaxSala);
		
		ventana.setSize(400, 100+cont);
		ventana.setVisible(true);
		ventana.setLocation(1000, 0);
	}
	
	public void actualizaDatos(int genteEnMuseo, int[] genteEnSala){
		
		JTcontMuseo.setText(Integer.toString(genteEnMuseo));
		for (int i = 0; i <genteEnSala.length; i++)
			aforoSalas[i].setText("Sala " + (i+1) + ": " + genteEnSala[i]);
		
	}
}
