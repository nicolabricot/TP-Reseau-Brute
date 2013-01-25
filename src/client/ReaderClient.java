package client;

import java.io.DataInputStream;
import java.io.InputStream;

import common.Reader;

public class ReaderClient extends Reader {
	
	public ReaderClient (DataInputStream dis) {
		super.dis = dis;
	}
	public ReaderClient (InputStream is) {
		super.is = is;
	}

}
