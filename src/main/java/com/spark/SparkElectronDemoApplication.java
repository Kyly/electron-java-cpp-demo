package com.spark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparkElectronDemoApplication {

    public static void main(String[] args) {
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.debug_load.jna", "true");
        System.setProperty("jna.library.path",
                "/Users/kvass/workspace/spark-electron-demo/src/main/resources/cpp/cmake-build-default/");
		SpringApplication.run(SparkElectronDemoApplication.class, args);
	}
}
