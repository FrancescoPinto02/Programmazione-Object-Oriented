package prova;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.swing.*;


public class MainClass{
	
	public void setUp() {
		Properties prop = new Properties();
		InputStream input = null;
		input = MainClass.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			System.out.println("Erroreeee");
			e.printStackTrace();
		}
		finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(prop.getProperty("db"));
	}
	
	public static void main(String[] args) throws IOException {	
			MainClass m = new MainClass();
			m.setUp();
		  }
	}
