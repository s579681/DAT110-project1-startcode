package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import no.hvl.dat110.messaging.MessageConfig;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = rpcid;
		byte[] tempStrArray = str.getBytes();
		
		for (int i = 0; i < tempStrArray.length; i++) {
			encoded[i+1] = tempStrArray[i];
		}
		/*
		if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}
		*/

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded
		byte[] tempDataArray = new byte[MessageConfig.SEGMENTSIZE];
		for (int i = 0; i < data.length - 1; i++) {
			tempDataArray[i] = data[i+1];
		}
		decoded = new String(tempDataArray).trim();
		
		/*
		if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}
		*/
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;
		// TODO: marshall RPC identifier in case of void type
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = rpcid;
		/*
		if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}
		*/
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;
		// TODO: marshall RPC identifier and string into byte array
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = rpcid;
		ByteBuffer byteBuff = ByteBuffer.allocate(4);
		byteBuff.putInt(x);
		byte[] tempByteArray = byteBuff.array();
		
		for (int i = 0; i < tempByteArray.length; i++) {
			encoded[i+1] = tempByteArray[i]; 
		}
		/*
		if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}
		*/
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data
		byte[] tempByteArray = new byte[data.length - 1];
		for (int i = 0; i < tempByteArray.length; i++) {
			tempByteArray[i] = data[i+1];
		}
		decoded = ByteBuffer.wrap(tempByteArray).getInt();
		/*
		if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}
		*/
		return decoded;

	}
}
