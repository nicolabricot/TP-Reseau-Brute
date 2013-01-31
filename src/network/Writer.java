/**
 * @author Nicolas
 */

package network;

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
	
	public void writeInt(int i) throws IOException {
		out.writeInt(i);
	}

	public void send() throws IOException {
		byte[] message = bos.toByteArray();
		os.write(message);
		os.flush();
	}

}
