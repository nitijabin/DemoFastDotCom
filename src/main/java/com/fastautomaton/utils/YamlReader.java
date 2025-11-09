package com.fastautomaton.utils;

import com.fastautomaton.model.EnvironmentConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class YamlReader {
    public static EnvironmentConfig loadEnvironment(String envName) {
        Yaml yaml = new Yaml();
        String filePath = "config/" + envName + ".yml";
        InputStream inputStream = YamlReader.class
                .getClassLoader()
                .getResourceAsStream(filePath);
        return yaml.loadAs(inputStream, EnvironmentConfig.class);
    }
}
