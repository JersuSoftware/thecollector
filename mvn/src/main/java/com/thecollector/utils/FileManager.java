package com.thecollector.utils;


import java.io.*;
import java.util.Scanner;

/**
 * Created by erick on 30/06/16.
 */
public class FileManager {

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void createFile(){
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("empty");
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public String readFile(){
		String file = "";
		try {
			FileReader fileReader = new FileReader(fileName);
			Scanner scanner = new Scanner(fileReader);
			while(scanner.hasNext())
				file = scanner.nextLine();
		} catch (FileNotFoundException e){
			this.createFile();
		} catch (Exception e){
			e.printStackTrace();
		}
		return file;
	}

	public void writeToFile(String json){
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(json);
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
