import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.evocatus.amazonclient.ItemLookupSample;

public class Mymain {

	public static void main(String[] args) {
		ItemLookupSample sampel = new ItemLookupSample();
		try {
			System.out.println(sampel.getPrice("AKIAIFWKPIPO5WHWWWAA", "obNfhGF28XQzRBQhiD3WdUXpSo4NLjnOD+jDtUUW", "aapcompare0f-21", "B01FM7HV7K"));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
