package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sebastian Coss Soto / Juan Castillo Carrillo
 *
 */
public class Analisis {
	
	public ArrayList<String> readFile(String route) {
		
		ArrayList <String> list = new ArrayList <String>();
		
		try {
			Scanner cvsData = new Scanner(new File(route));
				while(cvsData.hasNext()){
					list.add(cvsData.nextLine());
				}
			}
			catch(FileNotFoundException ex){
				System.out.println(ex.toString());
			}
		
	return list;
	}
	
	public ArrayList<String> removeSpecialChars(ArrayList <String> list){
		
		ArrayList <String> cleanList = new ArrayList <String>();
		String str;
		
		for(int i = 0 ; i < list.size() ; i ++) {
			str = list.get(i);
			str = str.replaceAll("\\d", "");
			str = str.replaceAll("[^a-zA-Z0-9\\s]", "");
			cleanList.add(str);
		}
		
	return cleanList;
	}
	
	public ArrayList<String> readWordFile(String txtRoute) {
		
		ArrayList <String> wordList = new ArrayList <String>();
		
		try {
			Scanner cvsData = new Scanner(new File(txtRoute));
				while(cvsData.hasNext()){
					wordList.add(cvsData.nextLine());
				}
			}
			catch(FileNotFoundException ex){
				System.out.println(ex.toString());
			}
		
	return wordList;
	}
	
	public ArrayList<Integer> countCoincidences(ArrayList <String> cleanList, ArrayList <String> wordList) {
		
		String str, str2;
		int aux = 0, count = 0;
		ArrayList <Integer> countList = new ArrayList <Integer>();
		for(int i = 0;i<wordList.size();i++)
		{
			countList.add(0);
		}
		
		for(int i = 0 ; i < cleanList.size() ; i ++) {
			str = cleanList.get(i);
			for(int j = 0 ; j < wordList.size(); j ++) {
				str2 = wordList.get(j);
					if(str.contains(str2)) {
						aux = countList.get(j);
						countList.set(j, aux+1);
					}
				
			}
		}
	return countList;
	}
	
}
