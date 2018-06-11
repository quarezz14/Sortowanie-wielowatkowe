import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import javax.swing.JTextArea;

public class TworzeniePlikow {
	JTextArea konsola;
	public void StworzPliki(int IloscPlikow, int ZawarteLiczby, int IloscLiczb, JTextArea konsola) throws IOException 
	
	{
		FileWriter fileWriter = null;
		Random generator = new Random();
		for (int x=1; x<=IloscPlikow; x++)
			{
				String pliczek = x+".txt";
				Files.createFile(Paths.get(pliczek));
				fileWriter = new FileWriter(pliczek);
				int z=generator.nextInt(IloscLiczb);
			for (int i=0; i<z; i++) 
				{
				int generowana = generator.nextInt(ZawarteLiczby);
				fileWriter.write(Integer.toString(generowana)+"\r\n");
				
				}
			fileWriter.close();
		}
			konsola.append("Zakonczono tworzenie plikow \n \r");	}
}
