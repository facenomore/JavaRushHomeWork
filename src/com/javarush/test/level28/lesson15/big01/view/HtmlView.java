package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Kiev");
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();
            Element original = document.getElementsByClass("template").first();
            Element template = original.clone();

            template.removeClass("template");
            template.removeAttr("style");
            document.getElementsByAttributeValue("class", "vacancy").remove();

            for (Vacancy vacancy : vacancies) {
                Element vac = template.clone();
                vac.getElementsByAttributeValue("class", "city").get(0).text(vacancy.getCity());
                vac.getElementsByAttributeValue("class", "companyName").get(0).text(vacancy.getCompanyName());
                vac.getElementsByAttributeValue("class", "salary").get(0).text(vacancy.getSalary());
                vac.getElementsByAttribute("href").get(0).attr("href", vacancy.getUrl()).text(vacancy.getTitle());
                original.before(vac.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document.html();
    }

    private void updateFile(String string) {
        try {
            BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            fileOutputStream.write(string.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
