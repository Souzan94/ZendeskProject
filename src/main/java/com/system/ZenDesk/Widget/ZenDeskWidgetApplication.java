package com.system.ZenDesk.Widget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {"com.system.ZenDesk.Widget.service","com.system.ZenDesk.Widget.repo","com.system.ZenDesk.Widget.controller", "com.system.ZenDesk.Widget.Utils"," com.system.ZenDesk.Widget.Configurations","com.system.ZenDesk.Widget.model"})

public class ZenDeskWidgetApplication {



    public static void main(String[] args) {
        SpringApplication.run(ZenDeskWidgetApplication.class, args);
    }



}
