package server;

import java.io.OutputStream;

import common.Writer;

public class WriterServer extends Writer {
	
	public WriterServer (OutputStream os) {
		super.os = os;
	}

}