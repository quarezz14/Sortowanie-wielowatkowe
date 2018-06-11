
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ramka extends JFrame implements ActionListener {
	
    BlockingQueue<String> listaplikow = new ArrayBlockingQueue<String>(4);
	int IloscPlikow,ZakresLiczb,IloscLiczb, Postep;
	JTextField tIloscPlikow,tZakresLiczb,tIloscLiczb;
	ArrayList<String> lista = new ArrayList<String>();
	JButton stworz, wczytaj, sortuj;
    JProgressBar jProgressBar = new JProgressBar(0,10);
    JProgressBar jProgressBar1 = new JProgressBar(0,10);
    JProgressBar jProgressBar2 = new JProgressBar(0,10);
    JProgressBar jProgressBar3 = new JProgressBar(0,10);
    JTextArea konsola;
    JScrollPane skrol;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ramka() 
	{
		setSize(500,700);
		setTitle("Tworzenie plików");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		stworz = new JButton("Stworz");
		stworz.setBounds(200,120,80,30);
		add(stworz);
		stworz.addActionListener(this);
		
		wczytaj = new JButton("Wczytaj");
		wczytaj.setBounds(150,180,80,30);
		add(wczytaj);
		wczytaj.addActionListener(this);
		
		sortuj = new JButton("Sortuj!");
		sortuj.setBounds(250,180,80,30);
		sortuj.setEnabled(false);
		add(sortuj);
		sortuj.addActionListener(this);
		
		JLabel IloscPlikow = new JLabel("Ilosc Plikow:");
		IloscPlikow.setBounds(5, 15, 80, 10);
		add(IloscPlikow);
		
		tIloscPlikow = new JTextField("");
		tIloscPlikow.setBounds(100, 15, 100, 20);
		add(tIloscPlikow);
		
		JLabel ZakresLiczb = new JLabel("ZakresLiczb:");
		ZakresLiczb.setBounds(5, 50, 80, 10);
		add(ZakresLiczb);
		
		tZakresLiczb = new JTextField("");
		tZakresLiczb.setBounds(100, 50, 100, 20);
		add(tZakresLiczb);
		
		JLabel IloscLiczb = new JLabel("IloscLiczb:");
		IloscLiczb.setBounds(5, 80, 80, 10);
		add(IloscLiczb);
		
		
		tIloscLiczb = new JTextField("");
		tIloscLiczb.setBounds(100, 80, 100, 20);
		add(tIloscLiczb);
		
		JLabel w1 = new JLabel("Watek 1");
		w1.setBounds(80, 230, 80, 10);
		add(w1);
		
		jProgressBar.setBounds(5, 250, 200, 15);
		jProgressBar.setStringPainted(true);
		add(jProgressBar);
		
		JLabel w2 = new JLabel("Watek 2");
		w2.setBounds(320, 230, 80, 10);
		add(w2);
		
		jProgressBar1.setBounds(250, 250, 200, 15);
		jProgressBar1.setStringPainted(true);
		add(jProgressBar1);
		
		JLabel w3 = new JLabel("Watek 3");
		w3.setBounds(80, 330, 80, 10);
		add(w3);
		
		jProgressBar2.setBounds(5, 350, 200, 15);
		jProgressBar2.setStringPainted(true);
		add(jProgressBar2);
		
		JLabel w4 = new JLabel("Watek 4");
		w4.setBounds(325, 330, 80, 10);
		add(w4);
		
		jProgressBar3.setBounds(250, 350, 200, 15);
		jProgressBar3.setStringPainted(true);
		add(jProgressBar3);
		
		
		konsola = new JTextArea();
		skrol = new JScrollPane(konsola, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		skrol.setBounds(50,400,400,200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Stworz")) {
			IloscPlikow = Integer.parseInt(tIloscPlikow.getText());
			ZakresLiczb = Integer.parseInt(tZakresLiczb.getText());
			IloscLiczb = Integer.parseInt(tIloscLiczb.getText());
		
			TworzeniePlikow piki = new TworzeniePlikow();
			try {
				piki.StworzPliki(IloscPlikow, ZakresLiczb, IloscLiczb, konsola);
			} catch (IOException e1) {
				e1.printStackTrace();
			}}
		if	(e.getActionCommand().equals("Wczytaj")) {
			Wczytanie w = new Wczytanie(listaplikow,"C:\\Users\\Respect\\eclipse-workspace\\progressbar.zip_expanded\\progressbar",konsola);
			new Thread(w).start();
			sortuj.setEnabled(true);
		}
		if (e.getActionCommand().equals("Sortuj!")) {
			Watki th1 = new Watki(listaplikow,jProgressBar,konsola);
			Watki th2 = new Watki(listaplikow,jProgressBar1,konsola);
			Watki th3 = new Watki(listaplikow,jProgressBar2,konsola);
			Watki th4 = new Watki(listaplikow,jProgressBar3,konsola);
			new Thread(th1).start();
			new Thread(th2).start();
			new Thread(th3).start();
			new Thread(th4).start();
			add(skrol);
			
			
		}
	}
}
