package ru.anovikova.lesson20;

import ru.anovikova.lesson20.dto.ConsolidatedWeather;
import ru.anovikova.lesson20.dto.Location;
import ru.anovikova.lesson20.dto.ResponseFields;

import java.io.IOException;
import java.util.Scanner;

public class WeatherApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите название населенного пункта на латинице :");
        Scanner scanner = new Scanner(System.in);
        String locality = scanner.nextLine();

        WeatherService weatherService = new WeatherService();
        Location[] response = weatherService.search(locality);
        if (response.length == 0) {
            System.out.println("Населенный пункт " + locality + " не найден");
        } else {
            System.out.println("Найдено "  + response.length + "населенных пунктов");
            for (Location location : response) {
                System.out.println("Прогноз погоды в " + location.getLocation_type() + " " + location.getTitle() + ":") ;
                ResponseFields responseFields = weatherService.location(location.getWoeid());
                for (ConsolidatedWeather consolidatedWeather : responseFields.getConsolidated_weather()) {
                    System.out.printf("%s %s от %.0f до %.0f градусов цельсия\n", consolidatedWeather.getApplicable_date(), consolidatedWeather.getWeather_state_name(),
                            consolidatedWeather.getMin_temp(), consolidatedWeather.getMax_temp());
                }
            }
        }
    }
}
