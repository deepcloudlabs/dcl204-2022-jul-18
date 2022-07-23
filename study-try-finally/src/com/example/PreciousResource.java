package com.example;

public class PreciousResource implements AutoCloseable {
	private int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws Exception {
		System.err.println("Closing the precious resource " + id);
		throw new RuntimeException("Ooops!");
	}

}
