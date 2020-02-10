package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		// TODO
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice
		
		DisplayImpl display = new DisplayImpl();

		RPCServer displayServer = new RPCServer(Common.DISPLAYPORT);

		displayServer.register(1, display);

		displayServer.run();

		displayServer.stop();
		/*
		if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}
		*/
		System.out.println("Display server stopping ...");
		
	}
}
