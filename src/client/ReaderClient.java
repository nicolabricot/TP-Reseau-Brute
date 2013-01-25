package client;

import java.io.DataInputStream;

import common.Reader;

public class ReaderClient extends Reader {
	
	public ReaderClient (DataInputStream is) {
		super.is = is;
	}
	

}
