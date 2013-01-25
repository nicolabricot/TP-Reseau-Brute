package common;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class Reader {
	
	protected DataInputStream is;
	
	public byte readDiscriminant() throws IOException {
		return is.readByte();
	}
	
	public String readString() throws IOException {
		return is.readUTF();
	}
	
}
