package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    private static final String RECEIPTS_FOLDER = "receipts";

    public static void writeReceipt(Order order) {
        File folder = new File(RECEIPTS_FOLDER);
    }
}
