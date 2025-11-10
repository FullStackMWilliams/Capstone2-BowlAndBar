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
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String timestamp = getTimestamp();
        String fileName = RECEIPTS_FOLDER + "/" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(order.toString());
            System.out.println("\nReceipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }

    private static String getTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return now.format(formatter);
    }
}
