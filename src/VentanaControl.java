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
	
	JLabel sala1 = new JLabel("Sala 1: ");
	JLabel sala2 = new JLabel("Sala 2: ");
	JLabel sala3 = new JLabel("Sala 3: ");
	
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
		
		sala1.setBounds(140, 100, 100, 20);
		sala2.setBounds(140, 120, 100, 20);
		sala3.setBounds(140, 140, 100, 20);
		
		ventana.add(contMuseo);
		ventana.add(salasMuseo);
		ventana.add(maxSala);
		ventana.add(contSala);
		
		ventana.add(JTcontMuseo);
		ventana.add(JTsalasMuseo);
		ventana.add(JTmaxSala);
		
		ventana.add(sala1);
		ventana.add(sala2);
		ventana.add(sala3);
		
		ventana.setSize(400, 200);
		ventana.setVisible(true);
		ventana.setLocation(1000, 0);
	}
	
	public void actualizaDatos(int genteEnMuseo, int[] genteEnSala){
		
		JTcontMuseo.setText(Integer.toString(genteEnMuseo));
		
		sala1.setText("Sala 1: " + genteEnSala[0]);
		sala2.setText("Sala 2: " + genteEnSala[1]);
		sala3.setText("Sala 3: " + genteEnSala[2]);
			
	}
}
