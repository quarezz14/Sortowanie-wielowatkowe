import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;


public class Watki implements Runnable {
	String nazwa,plik;
	JProgressBar jProgressBar;
	JTextArea konsola;
	   private final BlockingQueue<String> queue;
	   Watki(BlockingQueue<String> listaplikow, JProgressBar jProgessBar, JTextArea konsola) { 
		 queue = listaplikow;
	   jProgressBar= jProgessBar;
	   this.konsola = konsola;}

	@Override
	public void run() {
		try {
			while (true) {Sortowanie(queue.take());}
	            }
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	void Sortowanie(String plik) throws NumberFormatException, IOException {
		konsola.append(Thread.currentThread()+"bierze: \n \r"+plik+"\n \r");
		List<Integer> sortowanie = new ArrayList<Integer>();
		 BufferedReader br = new BufferedReader(new FileReader(plik));
		 BufferedReader br1 = new BufferedReader(new FileReader(plik));
            String linia = null;
            int set =0;
   		 while ((linia = br.readLine()) != null) {
 			set = set+1;
 		 }
   		 int point = set/10;
   		 int point1=point;
   		 int save=0;
           while ((linia = br1.readLine()) != null) {
               int liczba = Integer.parseInt(linia.trim());
               sortowanie.add(liczba);
           File posortowany = new File("Sorted"+plik);
           FileWriter writer = new FileWriter(posortowany);
           
//pêtla specjalnie spowalnia sortowanie aby pokazaæ dzia³anie progress barów
			
           int tmp = 0;
			for(int i=0; i<sortowanie.size();i++) {
			
				for(int j=1; j<(sortowanie.size()-i);j++) {
					
					if(sortowanie.get(j-1)>sortowanie.get(j))
					{
						
				tmp=sortowanie.get(j-1);
				sortowanie.set(j - 1, sortowanie.get(j));
				sortowanie.set(j, tmp);
					}

				}
				writer.write(sortowanie.get(i)+"\r\n");
				if (i == point1) 
				{
					jProgressBar.setValue(save+1);
					save++;
					point1 = point1+point;
				}
				try {
					Thread.sleep(1);
				}
				catch(InterruptedException e)
				{
					Thread.currentThread().interrupt();
				}
			}
			writer.close();
		
						}
			jProgressBar.setValue(0);
			konsola.append("Zakonczono sortowanie pliku: \n \r"+plik+"\n \r");
			br.close();
			br1.close();
		
	}

}
