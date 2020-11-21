package com.oops.salestax.utils;

import com.oops.salestax.entities.commons.InputDetails;
import com.oops.salestax.entities.items.Item;
import com.oops.salestax.entities.items.NonTaxableItems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public static List<InputDetails> parseInput(String filePath){
        List<InputDetails> inputDetailsList = new ArrayList<InputDetails>();
        File file = new File(filePath);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String input;
            while ((input = br.readLine()) != null) {
                String[] split = input.split(" ");
                Item item = new Item(split[1],Double.parseDouble(split[split.length-1]));
                if (input.contains("imported")){
                    item.setImported(true);
                }
                item.setTaxable(true);
                for(NonTaxableItems nonTaxableItems : NonTaxableItems.values()){
                    if (nonTaxableItems.getCategory().equalsIgnoreCase(item.getName())){
                        item.setTaxable(false);
                    }
                }
                InputDetails inputDetails = new InputDetails(Integer.parseInt(split[0]), item);
                inputDetailsList.add(inputDetails);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found at: "+filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to parse line in file "+filePath);
            e.printStackTrace();
        }
        return inputDetailsList;
    }
}
