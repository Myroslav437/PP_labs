package com.company.Common;

import java.io.IOException;

public class ConsoleUtilities {
    public static void clear() {
        try {
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        }
        catch (final Exception e) {
            System.out.println("Failed clear the window");
        }
    }
}
