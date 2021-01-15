
package com.codedifferently;
import java.util.ArrayList;
import java.util.Arrays;


public class DataReader {
        // take in raw data
        // replace unwanted special characters (keep #./:;) with ;
        // split string into array at ## for end of line

        public static String[] rawDataReader(String data){
            String cleanedData = null;
            String[] dataArray;


            String dataNoSpecialChars=data.replaceAll("[^0-9a-zA-Z#./:;]+",";");
            dataNoSpecialChars = dataNoSpecialChars.toLowerCase();
            dataArray = dataNoSpecialChars.split("##");

            System.out.println("In rawDataReader Number of list items in dataArray = " + dataArray.length);
            for (int i=0; i<dataArray.length; i++) {
                System.out.println("In rawDataReader List item = " + i + " in dataArray" + dataArray[i]);
            }

            // Never used ---- cleanedData = Arrays.toString(dataArray);

            return dataArray;
        }
    }

