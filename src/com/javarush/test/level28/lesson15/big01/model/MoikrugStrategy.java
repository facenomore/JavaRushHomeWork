package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        try {
            int page = 0;
            while (true) {
                Document document = getDocument(searchString, page);
                if (document == null) break;

                Elements elements = document.getElementsByAttributeValue("class", "job ");
                if (elements.size() == 0) break;

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "count").text());
                    vacancy.setCity(element.getElementsByAttributeValue("class", "location").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancy.setUrl(vacancy.getSiteName() + element.getElementsByAttributeValue("class", "title").first().getElementsByTag("a").first().attr("href"));
                    vacancies.add(vacancy);
                }
                page++;
            }
        } catch (IOException e) {
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:49.0) Gecko/20100101 Firefox/49.0")
                .referrer("google.com.ua")
                .get();
        return document;
    }
}

 /*   private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    public List<Vacancy> getVacancies(String searchString){

        List<Vacancy> result = new ArrayList<>();
        int page = 1;
        try {
            for (Document html = getDocument(searchString, page); html != null; html = getDocument(searchString, ++page)) {
                //Document html = getDocumentFromFile(searchString, page);
                Elements elements = html.select("[id^=job_]");
                if (elements.size() == 0) break;

                for (Element element : elements) {

                    Vacancy vacancy = new Vacancy();

                    vacancy.setSiteName("https://moikrug.ru/");

                    Elements el;

                    el = element.getElementsByClass("title").first().getElementsByTag("a");
                    vacancy.setTitle(el.first().text());
                    vacancy.setUrl(vacancy.getSiteName() + el.attr("href").substring(1));

                    el = element.getElementsByClass("salary");
                    vacancy.setSalary(el.size() != 0 ? el.first().getElementsByTag("div").first().text() : "");

                    el = element.getElementsByClass("location");
                    vacancy.setCity(el.size() != 0 ? el.first().getElementsByTag("a").first().text() : "");

                    el = element.getElementsByClass("company_name").first().getElementsByTag("a");
                    vacancy.setCompanyName(el.first().text());

                    result.add(vacancy);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;*/