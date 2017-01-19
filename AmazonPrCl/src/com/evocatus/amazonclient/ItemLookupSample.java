/**********************************************************************************************
 * Copyright 2009 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file 
 * except in compliance with the License. A copy of the License is located at
 *
 *       http://aws.amazon.com/apache2.0/
 *
 * or in the "LICENSE.txt" file accompanying this file. This file is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the License. 
 *
 * ********************************************************************************************
 *
 *  Amazon Product Advertising API
 *  Signed Requests Sample Code
 *
 *  API Version: 2009-03-31
 *
 */

package com.evocatus.amazonclient;

import static com.evocatus.amazonclient.AmazonClient.documentToString;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/*
 * This class shows how to make a simple authenticated ItemLookup call to the
 * Amazon Product Advertising API.
 * 
 * See the README.html that came with this sample for instructions on
 * configuring and running the sample.
 */
public class ItemLookupSample {
    /*
     * Your AWS Access Key ID, as taken from the AWS Your Account page.
     */
    private static final String AWS_ACCESS_KEY_ID = "AWS_ACCESS_KEY_ID";

    /*
     * Your AWS Secret Key corresponding to the above ID, as taken from the AWS
     * Your Account page.
     */
    private static final String AWS_SECRET_KEY = "AWS_SECRET_KEY";
    
    /**
     * Your AWS associate tag
     */
    private static final String AWS_ASSOCIATE_TAG = "AWS_ASSOCIATE_TAG";



    /*
     * The Item ID to lookup. The value below was selected for the US locale.
     * You can choose a different value if this value does not work in the
     * locale of your choice.
     */
    //private static final String ITEM_ID = "0545010225";

    public static String getPrice(String accessKeyId, String secretKey, String associateTag,String asin ) throws ParserConfigurationException, SAXException, IOException {

       
      
        /* The helper can sign requests in two forms - map form and string form */
        AmazonClient client = new AmazonClient(accessKeyId, secretKey, associateTag);
 
        /*
         * Here is an example in map form, where the request parameters are stored in a map.
         */
       // File inputFile = new File("input.txt");
        
       
        	
        	
	        final Map<String, String> params = new HashMap<String, String>(3);
	        params.put(AmazonClient.Op.PARAM_OPERATION, AmazonClient.OPERATION_ITEM_LOOKUP);
	        params.put("ItemId", asin);
	        params.put("ResponseGroup", "Medium");
	        
	       // System.out.println(documentToString(client.getXml(params)));
	        //System.out.println("------------------");
	       
	        String regexString = Pattern.quote("<LowestNewPrice>") + "(.*?)" + Pattern.quote("</LowestNewPrice>");
	        Pattern pattern = Pattern.compile(regexString);
	        Matcher matcher = pattern.matcher(documentToString(client.getXml(params)));
	        String price = "";
	        while (matcher.find()) {
	        	  String c = matcher.group(1); // Since (.*?) is capturing group 1
	        	  // You can insert match into a List/Collection here
	        	  price = c;
	        	  break;
	        	}
	        if("".equals(price))
	        {
	        	regexString = Pattern.quote("<LowestNewPrice>") + "(.*?)" + Pattern.quote("</LowestNewPrice>");
	        	 pattern = Pattern.compile(regexString);
	        	 matcher = pattern.matcher(documentToString(client.getXml(params)));
	        	  while (matcher.find()) {
		        	  String c = matcher.group(1); // Since (.*?) is capturing group 1
		        	  // You can insert match into a List/Collection here
		        	  price = c;
		        	  break;
		        	}
	        }
	      return price;
	    
    }
    


}
