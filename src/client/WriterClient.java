package client;

import java.io.OutputStream;

import common.Writer;

public class WriterClient extends Writer {

	public WriterClient(OutputStream os){
		super.os = os;
	}
	
	
}
