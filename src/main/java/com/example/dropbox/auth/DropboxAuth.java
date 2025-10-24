package com.example.dropbox.auth;

import com.dropbox.core.*;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class DropboxAuth {

    private static final String APP_KEY = "ec5j4kcdqf9t7w9"; // replace with your key
    private static final String APP_SECRET = "q72idwwno1eznnt"; // replace with your secret

    /**
     * Use this to generate short-lived access token and refresh token manually once.
     */
    public static void generateTokens() throws IOException, URISyntaxException, DbxException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox-oauth-example").build();
        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
        DbxWebAuth webAuth = new DbxWebAuth(config, appInfo);

        DbxWebAuth.Request request = DbxWebAuth.newRequestBuilder()
                .withNoRedirect()
                .withTokenAccessType(TokenAccessType.OFFLINE) // Important for refresh token
                .build();

        String authorizeUrl = webAuth.authorize(request);
        System.out.println("1. Go to: " + authorizeUrl);
        System.out.println("2. Click 'Allow' and copy the authorization code.");

        System.out.print("Enter authorization code here: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String code = reader.readLine().trim();

        DbxAuthFinish authFinish = webAuth.finishFromCode(code);
        System.out.println("Access Token: " + authFinish.getAccessToken());
        System.out.println("Refresh Token: " + authFinish.getRefreshToken());
    }

    public static void main(String[] args) throws Exception {
        generateTokens();
    }
}
