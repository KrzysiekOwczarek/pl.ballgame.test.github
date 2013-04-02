package net.obviam.starassault.addons;

import java.io.IOException;

public class Reader {

	private String[] aryLines;
	
	public Reader() {
		String fileName = "./level0.txt";
		   
		try{
			ReadFile file = new ReadFile(fileName);
			aryLines = file.OpenFile();
			
			//for(int i = 0; i < aryLines.length; i++){
			//	System.out.println(aryLines[i]);
			//}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public String[] getLines(){
		return this.aryLines;
	}
}
