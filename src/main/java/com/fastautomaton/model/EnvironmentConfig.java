package com.fastautomaton.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnvironmentConfig {

    private String baseUrl;
    private String browser;
    private Credentials credentials;

    @Getter
    @Setter
    public static class Credentials{
        private String username;
        private String password;
    }
}
