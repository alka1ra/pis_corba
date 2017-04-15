import corbaserver.CorbaServer;

import org.omg.CORBA.*;

public class StartServer {
	private static final String SERVER_START_MSG = "Server is working.";
	
	public static void main(String args[]) {
		try{
			ORB orb = CorbaServer.getOrb(args);
			System.out.println(SERVER_START_MSG);

			for (;;) { orb.run(); }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}