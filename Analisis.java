package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que tiene como objetivo obtener, modificar y realizar diferentes procesos con datos de archivos
 * @author Sebastian Coss Soto / Juan Castillo Carrillo
 *
 */
public class Analisis {
	/**
 	* Lee y guarda todas las palabras de un archivo
	* @param route La ruta donde se encuentra el archivo
	* @return list ArrayList con todo el texto del archivo
 	*
 	*/
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
	/**
 	* Recorre un ArrayList leído de un archivo y elimina toda la basura que este contenga
	* @param list Es un ArrayList que contiene todo el texto de un archivo leído
	* @return cleanList ArrayList limpio de caracteres especiales
 	*
 	*/
	public ArrayList<String> removeSpecialChars(ArrayList<String> list){
		
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
	/**
 	* Dado un archivo de texto que contenga n numero de palabras esta funcion lee
	* todas las palabras de ese archivo y las guarda en un ArrayList
	* @param txtRoute Ruta donde se encuentra el archivo de texto
	* @return wordList Arraylist que contiene todas las palabras del txt
 	*
 	*/
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
	/**
 	* Compara las palabras del txt con las palabras extraídas del archivo inicial y cuenta las coincidencias
	* @param cleanList,wordList ArrayList con palabras específicas y ArrayList con todo el texto de un archivo ya limpio
	* @return countList ArrayList que tiene un contador en cada una de sus posiciones
 	*
 	*/
	public ArrayList<Integer> countCoincidences(ArrayList <String> cleanList, ArrayList <String> wordList) {
		
		String str, str2;
		int aux = 0;
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
