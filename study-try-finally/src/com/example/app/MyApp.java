package com.example.app;

import java.io.FileInputStream;

import com.example.PreciousResource;

@SuppressWarnings("unused")
public class MyApp {

	public static void main(String[] args) {
		FileInputStream fis;
		try( // try with resources
				PreciousResource res1 = new PreciousResource(1);
				PreciousResource res2 = new PreciousResource(2);
				PreciousResource res3 = new PreciousResource(3);				
				) {
		} catch (Exception e) {
			System.err.println("Error while closing the resource: " + e.getMessage());
		} 
	}

}
