package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket(Path path) {
        try {
            this.path = Files.createTempFile(null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getFileSize() {
        return 0;
    }

    public void putEntry(Entry entry) {

    }

    public Entry getEntry() {
        return null;
    }

    public void remove() {

    }
}
/*
9.2.	Добавь в класс поле Path path. Это будет путь к файлу.
9.3.	Добавь в класс конструктор, он должен:
9.3.1.	Инициализировать path временным файлом. Файл должен быть размещен
в директории для временных файлов и иметь случайное имя. Подсказка:
Files.createTempFile.
9.3.2.	Создавать новый файл, используя path. Если такой файл уже есть, то
заменять его.
9.3.3.	Обеспечивать удаление файла при выходе из программы. Подсказка:
deleteOnExit().
9.4.	Добавь в класс методы:
9.4.1.	long getFileSize(), он должен возвращать размер файла на который
указывает path.
9.4.2.	void putEntry(Entry entry) - должен сериализовывать переданный entry в
файл. Учти, каждый entry может содержать еще один entry.
9.4.3.	Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой
размер, вернуть null.
9.4.4.	void remove() – удалять файл на который указывает path.
Конструктор и методы не должны кидать исключения.
 */