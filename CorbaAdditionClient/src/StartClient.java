import CorbaApp.*;
import corbaclient.CorbaClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartClient {
	private static final String ENTER_LENGTH_MSG = "Enter the size of map: ";
	private static final String CLIENT_START_MSG = "Client is working.";
	private static final String EMPTY_VALUES_MSG = "No values received.";
	private static final String RECEIVED_VALUES_MSG = "Generated values are:";
	private static final String TAB = "\t";

	public static void main(String[] args) {
		try {
			ValuesGetter valuesGetterObj = CorbaClient.getObject(args);

			if (valuesGetterObj != null) {
				System.out.println(CLIENT_START_MSG);
				int length = getLength();
				
				String values = valuesGetterObj.getValues(length);

				printValues(values);
				
				valuesGetterObj.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printValues(String values){
		if (values == null || values.isEmpty()) {
			System.out.println(EMPTY_VALUES_MSG);
		} else {
			System.out.println(RECEIVED_VALUES_MSG);
			System.out.print(values + TAB);
		}
	} 
	
	private static int getLength() throws NumberFormatException, IOException {
		int length;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(ENTER_LENGTH_MSG);
		length = Integer.parseInt(bf.readLine());

		if (length <= 0)
			throw new NumberFormatException();

		return length;
	}
}
