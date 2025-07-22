package com.guljo.guljo.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;

@Component
public class ReverseGeocodingUtil {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getLocationFromCoordinates(Double latitude, Double longitude) {
        try {
            String url = UriComponentsBuilder
                    .fromUriString("https://nominatim.openstreetmap.org/reverse")
                    .queryParam("format", "json")
                    .queryParam("lat", latitude)
                    .queryParam("lon", longitude)
                    .queryParam("zoom", 10)
                    .queryParam("addressdetails", 1)
                    .toUriString();

            String response = restTemplate.getForObject(url, String.class);

            JSONObject json = new JSONObject(response);
            JSONObject address = json.getJSONObject("address");

            // Try to extract city, town, or state
            if (address.has("city")) return address.getString("city");
            if (address.has("town")) return address.getString("town");
            if (address.has("village")) return address.getString("village");
            if (address.has("state")) return address.getString("state");

        } catch (Exception e) {
            System.err.println("Reverse geocoding failed: " + e.getMessage());
        }

        return "Unknown";
    }
}