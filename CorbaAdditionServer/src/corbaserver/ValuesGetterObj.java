package corbaserver;
import CorbaApp.ValuesGetterPOA;

import org.omg.CORBA.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

class ValuesGetterObj extends ValuesGetterPOA {
	private ORB orb;

	public void setORB(ORB orb_val) {
		orb = orb_val;
	}
	
	@Override
	public String getValues(int length) {
		Map<Integer, Integer> map = new HashMap<>();
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < length; i++){
			map.put(i, random.nextInt());
		}	
		StringBuffer sb = new StringBuffer();
		for(Entry<Integer, Integer> entry: map.entrySet()){
			sb.append(entry.getValue() + " ");
		}
		sb.append("\n");
		return sb.toString();
	}

	public void shutdown() {
		orb.shutdown(false);
	}
}