package network;

public abstract class Protocol {

	static final public int PORT = 12345;

	/* SERVER */
	static final public byte KO = 0x0; // 0
	static final public byte OK = 0x1; // 1
	
	/* Client */
	static final public byte QUERY_TEST = 0x2; // 2

	/* CLIENT -> SERVER */
	static final public byte GET_LOGIN = 0xA; // 10
	static final public byte LOGOUT = 0xB; // 11
	// brutes
	static final public byte GET_BRUTE_INFO = 0x14; // 20
	static final public byte GET_BRUTE_BONUS = 0x15; // 21
	static final public byte GET_BRUTE_IMG = 0x16; // 22
	static final public byte GET_ADVERSAIRE = 0x17; // 23
	// combat
	static final public byte GET_VICTORY = 0x28; // 40
	static final public byte GET_DEFEAT = 0x29; // 41
	static final public byte GET_COMBAT = 0x2A; // 42
	
	/* SERVER -> CLIENT */
	static final public byte REPLY_LOGIN = 0xF; // 15
	// brutes
	static final public byte REPLY_BRUTE_INFO = 0x1E; // 30
	static final public byte REPLY_BRUTE_BONUS = 0x1F; // 31
	static final public byte REPLY_BRUTE_IMG = 0x20; // 32
	static final public byte REPLY_ADVERSAIRE = 0x21; // 33
	// combat
	static final public byte REPLY_COMBAT = 0x2D; // 45
	
	
}
