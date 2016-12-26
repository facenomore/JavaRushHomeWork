package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        PersonScannerAdapter(Scanner scanner) throws FileNotFoundException {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws Exception {
            Person person = null;
            if (scanner.hasNext()) {
                String lastName = scanner.next();
                String name = scanner.next();
                String middleName = scanner.next();
                int day = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();
                String date = day + "-" + month + "-" + year;
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                Date birth = format.parse(date);
                person = new Person(name, middleName, lastName, birth);
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}