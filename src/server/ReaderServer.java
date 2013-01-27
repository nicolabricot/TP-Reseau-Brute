package server;

import java.io.DataInputStream;
import java.io.InputStream;
import network.Reader;

public class ReaderServer extends Reader {
	
	public ReaderServer (InputStream is) {
		super.is = new DataInputStream(is);
	}

}
