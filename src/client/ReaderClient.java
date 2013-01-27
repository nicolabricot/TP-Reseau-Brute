package client;

import java.io.DataInputStream;
import java.io.InputStream;
import network.Reader;

public class ReaderClient extends Reader {
	
	public ReaderClient (InputStream is) {
		super.is = new DataInputStream(is);
	}

}
