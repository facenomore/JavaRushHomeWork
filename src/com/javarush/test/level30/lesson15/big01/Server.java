package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.test.level30.lesson15.big01.MessageType.*;

/*
6.4.	В класс Server добавь метод main, он должен:
6.4.1.	 Запрашивать порт сервера, используя ConsoleHelper
6.4.2.	 Создавать серверный сокет java.net.ServerSocket, используя порт из п.6.4.1
6.4.3.	 Выводить сообщение, что сервер запущен
6.4.4.	 В бесконечном цикле слушать и принимать входящие сокетные соединения
серверного сокета из п.6.4.2
6.4.5.	 Создавать и запускать новый поток Handler, передавая в конструктор сокет из
п.6.4.4
6.4.6.	 После создания потока обработчика Handler переходить на новый шаг цикла
6.4.7.	 Предусмотреть закрытие серверного сокета в случае возникновения исключения.
Если исключение Exception все же произошло, поймать его и вывести сообщение
об ошибке.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            try {
                serverSocket.close();
            } catch (IOException e1) {
                ConsoleHelper.writeMessage("Произошла ошибка.");
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (String clientName : connectionMap.keySet()) {
            try {
                connectionMap.get(clientName).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не могу отправить сообщение клиенту с именем: " + clientName);
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
                ConsoleHelper.writeMessage("Cоединение с удаленным адресом закрыто.");
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом \n" + e.toString() + "\nпользователь " + userName + " отсоединен.");
                if (userName != null) connectionMap.remove(userName);
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом \n" + e.toString() + "\nпользователь " + userName + " отсоединен.");
                if (userName != null) connectionMap.remove(userName);
            }
        }

        /*
            Пришло время написать главный метод класса Handler, который будет вызывать все
        вспомогательные методы, написанные ранее. Добавим метод void run() в класс Handler.
        Он должен:
        11.1.	Выводить сообщение, что установлено новое соединение с удаленным
        адресом, который можно получить с помощью метода getRemoteSocketAddress
        11.2.	Создавать Connection, используя поле Socket
        11.3.	Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового
        клиента
        11.4.	Рассылать всем участникам чата информацию об имени присоединившегося
        участника (сообщение с типом USER_ADDED). Подумай, какой метод подойдет для
        этого лучше всего.
        11.5.	Сообщать новому участнику о существующих участниках
        11.6.	Запускать главный цикл обработки сообщений сервером
        11.7.	Обеспечить закрытие соединения при возникновении исключения
        11.8.	Отловить все исключения типа IOException и ClassNotFoundException, вывести в
        консоль информацию, что произошла ошибка при обмене данными с удаленным
        адресом
        11.9.	После того как все исключения обработаны, если п.11.3 отработал и возвратил
        нам имя, мы должны удалить запись для этого имени из connectionMap и разослать
        всем остальным участникам сообщение с типом USER_REMOVED и сохраненным
        именем.
        11.10.	Последнее, что нужно сделать в методе run() – вывести сообщение,
        информирующее что соединение с удаленным адресом закрыто.
        Наш сервер полностью готов. Попробуй его запустить.

         */
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(NAME_REQUEST));
                Message message = connection.receive();
                if ((message.getType() == USER_NAME) && (!message.getData().isEmpty()) && (!connectionMap.containsKey(message.getData()))) {
                    connectionMap.put(message.getData(), connection);
                    connection.send(new Message(NAME_ACCEPTED));
                    return message.getData();
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String clientName : connectionMap.keySet())
                if (!userName.equals(clientName)) connection.send(new Message(USER_ADDED, clientName));
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == TEXT)
                    sendBroadcastMessage(new Message(TEXT, userName + ": " + message.getData()));
                else ConsoleHelper.writeMessage("Ошибка типа сообщения.");
            }
        }
    }
}
/*
    Этап третий – главный цикл обработки сообщений сервером.
Добавь приватный метод void serverMainLoop(Connection connection, String userName) throws
IOException, ClassNotFoundException, где значение параметров такое же, как и у метода
sendListOfUsers. Он должен:
10.1.	 Принимать сообщение клиента
10.2.	 Если принятое сообщение – это текст (тип TEXT), то формировать новое
текстовое сообщение путем конкатенации: имени клиента, двоеточия, пробела и
текста сообщения. Например, если мы получили сообщение с текстом "привет чат" от
пользователя "Боб", то нужно сформировать сообщение "Боб: привет чат".
10.3.	 Отправлять сформированное сообщение всем клиентам с помощью метода
sendBroadcastMessage.
10.4.	 Если принятое сообщение не является текстом, вывести сообщение об ошибке
10.5.	 Организовать бесконечный цикл, внутрь которого перенести функционал
пунктов 10.1-10.4.
 */

/*
    Этап второй, но не менее важный – отправка клиенту (новому участнику) информации об
остальных клиентах (участниках) чата. Для этого:
9.1.	Добавь приватный метод void sendListOfUsers(Connection connection, String userName) throws
IOException, где connection – соединение с участником, которому будем слать
информацию, а userName – его имя. Метод должен:
9.2.	 Пройтись по connectionMap
9.3.	 У каждого элемента из п.9.2 получить имя клиента, сформировать команду с типом
USER_ADDED и полученным именем
9.4.	 Отправить сформированную команду через connection
9.5.	 Команду с типом USER_ADDED и именем равным userName отправлять не нужно,
пользователь и так имеет информацию о себе
 */

/*
    Класс Handler должен реализовывать протокол общения с клиентом, описанный в Задании
3. Выделим из протокола отдельные этапы и реализуем их с помощью отдельных методов:
Этап первый – это этап рукопожатия (знакомства сервера с клиентом). Реализуем его с
помощью приватного метода String serverHandshake(Connection connection) throws IOException,
ClassNotFoundException. Метод в качестве параметра принимает соединение connection, а
возвращает имя нового клиента.
Реализация метода должна:
8.1.	Сформировать и отправить команду запроса имени пользователя
8.2.	Получить ответ клиента
8.3.	Проверить, что получена команда с именем пользователя
8.4.	Достать из ответа имя, проверить, что оно не пустое и пользователь с таким именем
еще не подключен (используй connectionMap)
8.5.	Добавить нового пользователя и соединение с ним в connectionMap
8.6.	Отправить клиенту команду информирующую, что его имя принято
8.7.	Если какая-то проверка не прошла, заново запросить имя клиента
8.8.	Вернуть принятое имя в качестве возвращаемого значения
 */

/*
    Т.к. сервер может одновременно работать с несколькими клиентами, нам понадобится
метод для отправки сообщения сразу всем.
Добавь в класс Server:
7.1.	Статическое поле Map<String, Connection> connectionMap, где ключом будет имя
клиента, а значением - соединение с ним.
7.2.	Инициализацию поля из п.7.1 с помощью подходящего Map из библиотеки
java.util.concurrent, т.к. работа с этим полем будет происходить из разных потоков и
нужно обеспечить потокобезопасность.
7.3.	Статический метод void sendBroadcastMessage(Message message), который должен
отправлять сообщение  message по всем соединениям из connectionMap. Если при
отправке сообщение произойдет исключение IOException, нужно отловить его и
сообщить пользователю, что не смогли отправить сообщение.
 */
/*
    Приступим к самому важному – написанию сервера Server. Сервер должен поддерживать
множество соединений с разными клиентами одновременно. Это можно реализовать с
помощью следующего алгоритма:
- Сервер создает серверное сокетное соединение
- В цикле ожидает, когда какой-то клиент подключится к сокету
- Создает новый поток обработчик Handler, в котором будет происходить обмен
сообщениями с клиентом.
- Ожидает следующее соединение.
Добавь:
6.1.	В класс Server приватный статический вложенный класс Handler, унаследованный от
Thread.
6.2.	В класс Handler поле типа Socket.
6.3.	В класс Handler конструктор, принимающий в качестве параметра Socket и
инициализирующий им соответствующее поле класса.
 */