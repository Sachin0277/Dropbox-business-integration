package com.example.dropbox.controller;

import com.example.dropbox.service.DropboxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DropboxController {

    private final DropboxService dropboxService;

    public DropboxController(DropboxService dropboxService) {
        this.dropboxService = dropboxService;
    }

    /**
     * Endpoint to get all team members.
     * Example: GET http://localhost:8080/team/members
     */
    @GetMapping("/team/members")
    public String getTeamMembers() {
        return dropboxService.fetchTeamMembers();
    }
}

