package common;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class Reader {
	
	protected DataInputStream is;
	
	public byte readDiscriminant() {
		try {
			return is.readByte();
		}
		catch (IOException e) {
			return (Byte) null;
		}
	}
	
}
