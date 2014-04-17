package br.com.jpiva.controller.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GravaLog {
	
	public static void setGravaLog(String classe, String metodo, String mensagem){
		
		StringBuilder conteudoLog = new StringBuilder();
		Path caminho = Paths.get("WebContent/log/log.txt");
		Charset charset = Charset.forName("ISO-8859-1");
		
		BufferedReader buffR;
		BufferedWriter bw;
		
		try {
			
			buffR = Files.newBufferedReader(caminho, charset);
			
			String texto;  
        	while ((texto = buffR.readLine ()) != null ) {
        		conteudoLog.append(texto + "\n");
			}
        
	        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
	        conteudoLog.append(out.format(new Date()) + ";" +  classe + ";" + metodo + ";" + mensagem + "\n");	
	        
	        bw = Files.newBufferedWriter(caminho, charset);
	        bw.write(conteudoLog.toString());
			bw.flush();
			bw.close();
        
        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
