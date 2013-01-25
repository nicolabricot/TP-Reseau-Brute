package common;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class Reader {
	
	protected InputStream is;
	protected DataInputStream dis;
	
	public byte readDiscriminant() {
		try {
			return dis.readByte();
		} catch (IOException e) {
			return (Byte) null;
		}
	}
	
}
