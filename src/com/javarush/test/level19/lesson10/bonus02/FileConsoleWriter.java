package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter {
    private FileWriter fileWriter;


    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
        this.fileWriter = new FileWriter(fd);
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c);
        System.out.print((char) c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(cbuf, off, len);
        String s="";
        for (int i = off; i < len+off; i++) s+=cbuf[i];
            System.out.print(s);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        super.write(cbuf,0,cbuf.length);
        System.out.print(cbuf);
    }

    @Override
    public void write(String str) throws IOException {
        super.write(str,0,str.length());
        System.out.print(str);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
        String s="";
        s=str.substring(off, off+len);
            System.out.print(s);
    }


 /*   public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileConsoleWriter("f:/data.txt"));
        char[] c = new char[20];
        for (int i = 0; i < 20; i++) c[i] = (char) (i + 52);
        String s = "Hello world";
        writer.write(c);
        writer.close();
    }*/

    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("f:/result.txt");
        fileConsoleWriter.write("123456789".toCharArray(), 2, 5);
        fileConsoleWriter.write("123456789");
        fileConsoleWriter.write(9999);
        fileConsoleWriter.write("qwertyu", 2, 5);
        fileConsoleWriter.write("dfghj".toCharArray());

        fileConsoleWriter.flush();
        fileConsoleWriter.close();
        System.out.println();
        BufferedReader reader = new BufferedReader(new FileReader("f:/result.txt"));
        System.out.println(reader.readLine());
        reader.close();
    }
}
