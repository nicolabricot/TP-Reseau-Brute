package common;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class Reader {
	
	protected DataInputStream is;
	protected String text;
	protected int type;
	
	protected int readInt(){
		try{
			return is.readInt();
		}
		catch(IOException e){
			return 0;
		}
	}
	
	protected String readUTF(){
		try{
			return is.readUTF();
		}
		catch(IOException e){
			return "";			
		}
	}
}
