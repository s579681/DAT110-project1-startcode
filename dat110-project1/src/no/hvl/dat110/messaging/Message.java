package no.hvl.dat110.messaging;

import java.util.Arrays;
import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = null;
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		//type casting: byte –> short –> int –> long –> float –> double
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		int sizeOfMsg = payload.length;
		encoded[0] =(byte) sizeOfMsg;
		
		for (int i = 0; i < payload.length; i++) {
			encoded[i + 1] = payload[i];		}
		return encoded;
		/*
		if (true)
		   throw new UnsupportedOperationException(TODO.method());
		*/
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		int sizeOfMsg = received[0];
		
		byte[] tempArray = new byte[sizeOfMsg];
		for (int i = 0; i < sizeOfMsg; i++) {
			tempArray[i] = received[i + 1];
		}
		this.payload = tempArray;
		/*
		throw new UnsupportedOperationException(TODO.method());
		*/
	}
}
