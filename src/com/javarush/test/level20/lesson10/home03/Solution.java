package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutput = new FileOutputStream("d:/cat.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution.B b = new Solution().new B("B");
        System.out.println(b.name);
        outputStream.writeObject(b);
        fileOutput.flush();
        fileOutput.close();
        outputStream.close();

        FileInputStream fiStream = new FileInputStream("d:/cat.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        B b1 = (B) objectStream.readObject();
        System.out.println(b1.name);

        fiStream.close();
        objectStream.close();
    }

    public static class A {
        protected String name = "A";

        public A() {

        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B() {

        }

        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
        }
    }
}
