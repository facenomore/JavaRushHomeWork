package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;

import java.io.IOException;
import java.net.Socket;

import static com.javarush.test.level30.lesson15.big01.MessageType.*;

/*
12.1.	Создай пакет client. В дальнейшем все классы, отвечающие за реализацию
клиентов, создавай в этом пакете.
12.2.	Создай класс Client.
12.3.	Создай внутренний класс SocketThread унаследованный от Thread в классе
Client. Он будет отвечать за поток, устанавливающий сокетное соединение и
читающий сообщения сервера. Класс должен иметь публичный модификатор доступа.
12.4.	Создай поле Connection connection в классе Client. Используй модификатор
доступа, который позволит обращаться к этому полю из класса потомков, но запретит
обращение из других классов вне пакета.
12.5.	Добавь поле-флаг boolean clientConnected в класс Client. Проинициализируй его
значением false. В дальнейшем оно будет устанавливаться в true, если клиент
подсоединен к серверу или в false в противном случае. При объявлении этого поля
используй ключевое слово, которое позволит гарантировать что каждый поток,
использующий поле clientConnected, работает с актуальным, а не кэшированным его
значением.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    /*
    14.2.	Добавь метод main(). Он должен создавать новый объект класса Client и
    вызывать у него метод run().

     */
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Input IP ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Input port ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Input User Name ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        Message message = new Message(TEXT, text);
        try {
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("IOException appeared.");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
//??
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Error " + e);
            return;
        }
//??
        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while (clientConnected) {
            String s = ConsoleHelper.readString();
            if ("exit".equalsIgnoreCase(s)) break;
            if (shouldSentTextFromConsole()) sendTextMessage(s);
        }
    }

    /*
        Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь
    его. Его реализация с учетом уже созданных методов выглядит очень просто. Давай
    напишем ее:
    17.1.	Запроси адрес и порт сервера с помощью методов getServerAddress() и
    getServerPort().
    17.2.	Создай новый объект класса java.net.Socket, используя данные, полученные в
    п.17.1.
    17.3.	Создай объект класса Connection, используя сокет из п.17.2.
    17.4.	Вызови метод, реализующий "рукопожатие" клиента с сервером
    (clientHandshake()).
    17.5.	Вызови метод, реализующий основной цикл обработки сообщений сервера.
    17.6.	При возникновении исключений IOException или ClassNotFoundException
    сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false
    в качестве параметра.
    Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.
     */
    public class SocketThread extends Thread {
        @Override
        public void run() {
            try {
                String serverAddress = getServerAddress();
                int serverPort = getServerPort();
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (NAME_REQUEST == message.getType()) {
                    String userName = getUserName();
                    connection.send(new Message(USER_NAME, userName));
                } else if (NAME_ACCEPTED == message.getType()) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        /*   Теперь все готово, чтобы дописать необходимые методы класса SocketThread.
        16.1.	Добавь защищенный метод clientHandshake() throws IOException,
        ClassNotFoundException. Этот метод будет представлять клиента серверу. Он должен:
        16.1.1.	В цикле получать сообщения, используя соединение connection
        16.1.2.	Если тип полученного сообщения NAME_REQUEST (сервер запросил имя),
        запросить ввод имени пользователя с помощью метода getUserName(), создать
        новое сообщение с типом USER_NAME и введенным именем, отправить
        сообщение серверу.
        16.1.3.	Если тип полученного сообщения NAME_ACCEPTED (сервер принял имя), значит
        сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого
        очень ждет. Сделай это с помощью метода notifyConnectionStatusChanged(),
        передав в него true. После этого выйди из метода.
        16.1.4.	Если пришло сообщение с каким-либо другим типом, кинь исключение
        IOException("Unexpected MessageType").
         */
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (TEXT == message.getType())
                    processIncomingMessage(message.getData());
                else if (USER_ADDED == message.getType())
                    informAboutAddingNewUser(message.getData());
                else if (USER_REMOVED == message.getType())
                    informAboutDeletingNewUser(message.getData());
                else throw new IOException("Unexpected MessageType");
            }
        }
    }
}
/*
16.2.	Добавь защищенный метод void clientMainLoop() throws IOException,
ClassNotFoundException. Этот метод будет реализовывать главный цикл обработки
сообщений сервера. Внутри метода:
16.2.1.	Получи сообщение от сервера, используя соединение connection.
16.2.2.	Если это текстовое сообщение (тип TEXT), обработай его с помощью метода
processIncomingMessage().
16.2.3.	Если это сообщение с типом USER_ADDED, обработай его с помощью метода
informAboutAddingNewUser().
16.2.4.	Если это сообщение с типом USER_REMOVED, обработай его с помощью метода
informAboutDeletingNewUser().
16.2.5.	Если клиент получил сообщение какого-либо другого типа, кинь исключение
IOException("Unexpected MessageType").
16.2.6.	Размести код из пунктов 16.2.1 – 16.2.5 внутри бесконечного цикла. Цикл будет
завершен автоматически если произойдет ошибка (будет кинуто исключение) или
поток, в котором работает цикл, будет прерван.
 */
/*
    Напишем реализацию класса SocketThread. Начнем с простых вспомогательных методов.
Добавь методы, которые будут доступны классам потомкам и не доступны остальным
классам вне пакета:
15.1.	void processIncomingMessage(String message) – должен выводить текст message в
консоль
15.2.	void informAboutAddingNewUser(String userName) – должен выводить в консоль
информацию о том, что участник с именем userName присоединился к чату
15.3.	void informAboutDeletingNewUser(String userName) – должен выводить в
консоль, что участник с именем userName покинул чат
15.4.	void notifyConnectionStatusChanged(boolean clientConnected) – этот метод
должен:
15.4.1.	Устанавливать значение поля clientConnected класса Client в соответствии с
переданным параметром.
15.4.2.	Оповещать (пробуждать ожидающий) основной поток класса Client. Подсказка:
используй синхронизацию на уровне объекта внешнего класса и метод notify. Для
класса SocketThread внешним классом является класс Client.
 */

/*	 Приступим к написанию главного функционала класса Client.
14.1.1.	Создавать новый сокетный поток с помощью метода getSocketThread.
14.1.2.	Помечать созданный поток как daemon, это нужно для того, чтобы при выходе
из программы вспомогательный поток прервался автоматически.
14.1.3.	Запустить вспомогательный поток.
14.1.4.	Заставить текущий поток ожидать, пока он не получит нотификацию из другого
потока. Подсказка: используй wait и синхронизацию на уровне объекта. Если во
время ожидания возникнет исключение, сообщи об этом пользователю и выйди
из программы.
14.1.5.	После того, как поток дождался нотификации, проверь значение
clientConnected. Если оно true – выведи "Соединение установлено. Для выхода
наберите команду 'exit'.". Если оно false – выведи "Произошла ошибка во время
работы клиента.".
14.1.6.	Считывай сообщения с консоли пока клиент подключен. Если будет введена
команда 'exit', то выйди из цикла.
14.1.7.	После каждого считывания, если метод shouldSentTextFromConsole()
возвращает true, отправь считанный текст с помощью метода  sendTextMessage().
 */
/*
    Продолжаем реализацию вспомогательных методов класса Client. Добавь в класс методы,
которые будут доступны классам потомкам, но не доступны из других классов вне пакета:
13.1.	String getServerAddress() – должен запросить ввод адреса сервера у
пользователя и вернуть введенное значение. Адрес может быть строкой, содержащей
ip, если клиент и сервер запущен на разных машинах или ‘localhost’, если клиент и
сервер работают на одной машине.
13.2.	int getServerPort() – должен запрашивать ввод порта сервера и возвращать его.
13.3.	String getUserName() – должен запрашивать и возвращать имя пользователя.
13.4.	boolean shouldSentTextFromConsole() – в данной реализации клиента всегда
должен возвращать true (мы всегда отправляем текст введенный в консоль). Этот
метод может быть переопределен, если мы будем писать какой-нибудь другой
клиент, унаследованный от нашего, который не должен отправлять введенный в
консоль текст.
13.5.	SocketThread getSocketThread() – должен создавать и возвращать новый объект
класса SocketThread.
13.6.	void sendTextMessage(String text) – создает новое текстовое сообщение,
используя переданный текст и отправляет его серверу через соединение connection.
Если во время отправки произошло исключение IOException, то необходимо вывести
информацию об этом пользователю и присвоить false полю clientConnected.

 */