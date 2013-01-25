package common;

public abstract class Protocol {
	
	static final public int PORT = 12345;
	
	// Responses
	static final public byte REP_KO = 0x0;
	static final public byte REP_OK = 0x1;
	
	
	// Discriminant from client to server
	static final public byte GET_LOGIN = 0x14;
	static final public byte GET_BRUTE_INFO = 0x15;
	static final public byte GET_BRUTE_IMG = 0x16;
	static final public byte GET_BRUTE_ADVERSAIRE = 0x17;
	static final public byte GET_BRUTE_VICTORY = 0x1E;
	static final public byte GET_BRUTE_DEFEAT = 0x1F;
	
	// Test
	static final public byte QUERY_TEST = 0x64;
	
}
