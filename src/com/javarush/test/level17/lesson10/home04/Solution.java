package com.javarush.test.level17.lesson10.home04;

/* Синхронизированные методы
Установить модификатор synchronized только тем методам, которым необходимо.
Объект класса Solution будет использоваться нитями.
*/

public class Solution {
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    private void method0() {
        double i = method3();
    } //нічого насправді не робить

    protected synchronized void method1(String param1) { //створює об'єкт класу солюшн, необхідно синхронізувати, щоб ніхто не вліз на етапі створення
        Solution solution = new Solution();
        solution.method0();
    }

    public void method2(int param1) { //більшує параметр, який йому передається, але нікуди його не передає, посуті нічого не робить
        param1++;
    }

    synchronized double method3() {  //використовує змінну класу солюшн, треба її заблокувати, щоб не змінилась і змогла її передати далі.
        double random = Math.random();
        param += 40.7;
        return random + param;
    }

    private synchronized void method4() {  //стрінг білдер немає внутрішньої синхронізації, необхідно синхронізувати
        sb.append(1).append(1).append(1).append(1);
    }

    protected void method5(String param2) {
        new StringBuffer().append(param2).append(param2).append(param2);
    } //стрінгбуфер має внутрішню синхронізацію синхронізувати непотрібно

    public synchronized String method6(int param2) { //визиває несинхронізований метод, який може помінятись невчасно
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    String method7(double param2) {
        return "" + param2;
    } //не створює нових об'єктів крім себе

}
