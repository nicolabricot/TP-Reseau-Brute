package common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class Writer {
	
	protected OutputStream os;
	protected ByteArrayOutputStream bos = new ByteArrayOutputStream();
	protected DataOutputStream out = new DataOutputStream(bos);
	
	public void writeDiscriminant(byte b) throws IOException {
		out.writeByte(b);
	}
	
	public void writeString(String s) throws IOException {
		out.writeUTF(s);
	}
	
	
	public void send() {
		byte [] message = bos.toByteArray();
		try {
			os.write(message);
			os.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
