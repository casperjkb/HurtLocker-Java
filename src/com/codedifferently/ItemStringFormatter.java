package com.codedifferently;

public class ItemStringFormatter {

    public static final Integer NUMBER_OF_INITIAL_SPACES = 4;
    public static String createColumnString(String nameOfColumn, Integer numberOfOccurances){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name:");
        for(int i =0; i < numberOfOccurances; i ++){
            stringBuilder.append(" ");
        }
        stringBuilder.append(nameOfColumn);
        for(int i =0; i < numberOfOccurances; i ++){
            stringBuilder.append("    ");
        }
        stringBuilder.append("seen: ");
        stringBuilder.append(numberOfOccurances);
        stringBuilder.append(" times");
        stringBuilder.append("\n");
        stringBuilder.append("=============");
        return stringBuilder.toString();
    }
}
