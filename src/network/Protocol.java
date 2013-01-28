package network;

public abstract class Protocol {

	static final public int PORT = 12345;

	/* COMMON */
	static final public byte KO = 0x0; // 0
	static final public byte OK = 0x1; // 1
	// Test
	static final public byte QUERY_TEST = 0x2; // 2

	/* CLIENT -> SERVER */
	static final public byte LOGIN = 0xA; // 10
	// brutes
	static final public byte GET_BRUTE_INFO = 0x14; // 20
	static final public byte GET_BRUTE_BONUS = 0x15; // 21
	static final public byte GET_BRUTE_IMG = 0x16; // 22
	// combat
	static final public byte VICTORY = 0x28; // 40
	static final public byte DEFEAT = 0x29; // 41
	static final public byte COMBAT = 0x2A; // 42
	
	/* SERVER -> CLIENT */
	// brutes
	static final public byte REPLY_BRUTE_INFO = 0x1E; // 30
	static final public byte REPLY_BRUTE_BONUS = 0x1F; // 31
	static final public byte REPLY_BRUTE_IMG = 0x20; // 32
	
	
}
