package com.example.dropbox.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DropboxService {

    @Value("${dropbox.access.token}")
    private String accessToken;

    private final RestTemplate restTemplate = new RestTemplate();

    public String fetchTeamMembers() {
        String url = "https://api.dropboxapi.com/2/team/members/list_v2";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>("{}", headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("API call failed: " + response.getStatusCode() + " " + response.getBody());
        }
    }
}

