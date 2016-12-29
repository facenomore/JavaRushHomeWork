package com.javarush.test.level27.lesson15.big01.ad;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        if (storage.list().isEmpty()) throw new NoVideoAvailableException();

    }
}
/*
2. Разберем подробно метод void processVideos() в AdvertisementManager.
2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду. (Следующее задание)
2.3. Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException,
которое перехватить в оптимальном месте (подумать, где это место) и с уровнем Level.INFO логировать фразу
"No video is available for the order " + order
2.4. Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа одного рекламного ролика
в копейках. Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки
Используйте метод Collections.sort
(Будет тестироваться вместе со следующим заданием)
Пример для заказа [Water]:
First Video is displaying... 50, 277
где First Video - название рекламного ролика
где 50 - стоимость показа одного рекламного ролика в копейках
где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
Используйте методы из класса Advertisement.
2.6. Для каждого показанного рекламного ролика пересчитать его данные вызвав метод revalidate() у объекта класса Advertisement.

Напомню, рекурсия пишется по следующему принципу:
а) условие выхода/окончания рекурсии
б) условие продолжения - вызов самой себя с набором параметров предыдущего шага.
В любое время ты можешь почитать в инете подробную информацию по написанию рекурсии.

Текущее задание - реализовать п.2.2. предыдущего задания с помошью рекурсии.
(подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду)
Рекурсивный метод должен выбрать набор рекламных роликов, которые будут показаны посетителю.

Этот набор должен удовлетворять следующим требованиям:
1) сумма денег, полученная от показов, максимальная из всех возможных вариантов
2) общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа
3) для одного заказа любой видео-ролик показывается не более одного раза
4) если существуют несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов, то:
4.1) выбрать тот вариант, у которого суммарное время максимальное
4.2) если суммарное время у этих вариантов одинаковое, то выбрать вариант с минимальным количеством роликов
5) количество показов у любого рекламного ролика из набора - положительное число

При локальном тестировании учитывайте, что необходимо отобразить все рекламные ролики, отобранные для показа,
в порядке уменьшения стоимости показа одного рекламного ролика в копейках.
*/