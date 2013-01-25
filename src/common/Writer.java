package common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class Writer {
	
	protected OutputStream os;
	protected ByteArrayOutputStream bos = new ByteArrayOutputStream();
	protected DataOutputStream out = new DataOutputStream(bos);
	
	protected void writeInt( int i){
		try{
			out.writeInt(i);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeUTF( String s){
		try{
			out.writeUTF(s);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void send(){
		byte [] message = bos.toByteArray();
		try{
			os.write(message);
			os.flush();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	

}
