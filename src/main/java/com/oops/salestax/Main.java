package com.oops.salestax;

import com.oops.salestax.entities.items.Item;
import com.oops.salestax.execute.SalesTaxExecutor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath;
        if (args.length == 0) {
            System.exit(0);
        } else {
            filePath = args[0];
            new SalesTaxExecutor().execute(filePath);
        }

    }
}
