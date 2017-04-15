package corbaserver;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CorbaApp.ValuesGetter;
import CorbaApp.ValuesGetterHelper;

public class CorbaServer {
	private static final String OBJECT_NAME = "RootPOA";
	private static final String NAME_SERVICE = "NameService";
	private static final String STRINGIFIED_NAME = "ABC";

	public static ORB getOrb(String[] args) throws Exception {
		ORB orb = ORB.init(args, null);
		POA rootpoa = POAHelper.narrow(orb.resolve_initial_references(OBJECT_NAME));
		rootpoa.the_POAManager().activate();

		ValuesGetterObj addobj = new ValuesGetterObj();
		addobj.setORB(orb);

		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(addobj);
		ValuesGetter href = ValuesGetterHelper.narrow(ref);

		org.omg.CORBA.Object objRef = orb.resolve_initial_references(NAME_SERVICE);
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		NameComponent path[] = ncRef.to_name(STRINGIFIED_NAME);
		ncRef.rebind(path, href);

		return orb;
	}
}