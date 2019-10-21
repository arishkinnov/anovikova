package ru.anovikova.lesson20;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.anovikova.lesson20.dto.Location;
import ru.anovikova.lesson20.dto.ResponseFields;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherService {
    public Location[] search(String locality) throws IOException {
        URL url = new URL("https://www.metaweather.com/api/location/search/?query=" + locality);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Location[] location = objectMapper.readValue(url, Location[].class);

        return location;
    }

    public ResponseFields location (int woeid) throws IOException {

        URL url = new URL("https://www.metaweather.com/api/location/" + woeid + "/");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ResponseFields responseFields = objectMapper.readValue(url, ResponseFields.class);

        return responseFields;
    }
}
