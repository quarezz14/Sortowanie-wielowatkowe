import java.io.File;
import java.util.concurrent.BlockingQueue;

import javax.swing.JTextArea;

public class Wczytanie implements Runnable {

	   private final BlockingQueue<String> queue;
	   String sciezka;
	   JTextArea konsola;
	   Wczytanie(BlockingQueue<String> listaplikow, String sciezka, JTextArea konsola) { 
		   queue = listaplikow;
		   this.sciezka = sciezka;
		   this.konsola = konsola;
	   }
	@Override
	public void run() {
        File folder = new File(sciezka);

        File[] fList = folder.listFiles();

        for (File file : fList){


            if (file.isFile() && file.getName().endsWith(".txt")){
            	
            	try {
					queue.put(file.getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



            }

        }
        konsola.append("Wczytano wszystkie Pliki \n \r");

		
	}
}
