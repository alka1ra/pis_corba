package corbaclient;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import CorbaApp.ValuesGetter;
import CorbaApp.ValuesGetterHelper;

public class CorbaClient {
	private static final String NAME_SERVICE = "NameService";
	private static final String STRINGIFIED_NAME = "ABC";
	
	public static ValuesGetter getObject(String[] args) {
		try{
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references(NAME_SERVICE);
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			return  (ValuesGetter) ValuesGetterHelper.narrow(ncRef.resolve_str(STRINGIFIED_NAME));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}