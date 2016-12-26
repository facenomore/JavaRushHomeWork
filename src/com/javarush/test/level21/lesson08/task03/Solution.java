package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {


    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1, 1);
        A cloneA = null;
        B b = new B(2, 2, "");
        B cloneB = null;
        C c = new C(3, 3, "");
        C cloneC = null;
        cloneA = a.clone();
        //cloneB = b.clone();
        cloneC = c.clone();
        System.out.println(a);
        System.out.println(cloneA);

        System.out.println(c);
        System.out.println(cloneC);

    }

    public static class A implements Cloneable {
        private int i;
        private int j;

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return new C(this.getI(), this.getJ(), this.getName());
        }
    }
}
