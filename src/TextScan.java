import java.util.*;
import java.io.*;

public class TextScan{

	ArrayList<String> memList;
	
	public ArrayList<String> txtScan(String t) throws IOException{

		memList = new ArrayList<String>();
	
	Scanner fIn = new Scanner(new File("word_rus.txt"));
	while (fIn.hasNextLine()){
	String w = fIn.nextLine();
	String m = w;

	if (t.equals(trans(m))){memList.add(w);}
	}
	fIn.close();
	return memList;

	}
	public ArrayList<String> txtScanPlusOne(String t) throws IOException{

		memList = new ArrayList<String>();
	ArrayList<String> tPlusOne = new ArrayList<String>();
	for (int i=0; i<10; i++){
		tPlusOne.add(t+i);
	}
	Scanner fIn = new Scanner(new File("word_rus.txt"));
	while (fIn.hasNextLine()){
	String w = fIn.nextLine();
	String m = w;

	if (tPlusOne.contains(trans(m))){memList.add(w);}
	}
	fIn.close();
	
	return memList;

	}
	
	public String trans(String m){
		//long l = 0;
				m=m.replaceAll("[�Ũ�����������������������-]", "");
				m=m.replaceAll("[����]", "1");
				m=m.replaceAll("[����]", "2");
				m=m.replaceAll("[����]", "3");
				m=m.replaceAll("[����]", "4");
				m=m.replaceAll("[����]", "5");
				m=m.replaceAll("[����]", "6");
				m=m.replaceAll("[����]", "7");
				m=m.replaceAll("[����]", "8");
				m=m.replaceAll("[����]", "9");
				m=m.replaceAll("[����]", "0");
				//if (!(m.equals("")))
				//{l = Long.parseLong(m);}
				//int n = (int) l; 
				return m;
	
}
}