package com.icolak.bean_annotation.config;

import com.icolak.bean_annotation.casefactory.Case;
import com.icolak.bean_annotation.casefactory.DellCase;
import com.icolak.bean_annotation.monitorfactory.Monitor;
import com.icolak.bean_annotation.monitorfactory.SonyMonitor;
import com.icolak.bean_annotation.motherboardfactory.AsusMotherboard;
import com.icolak.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {

    @Bean
    public Monitor monitorSony() {
        return new SonyMonitor("25 inch Beast", "Sony", 25);
    }
    @Bean
    public Motherboard motherboardAsus() {
        return new AsusMotherboard("BJ-200", "Asus", 4, 6, "v2");
    }
    @Bean
    public Case caseDell() {
        return new DellCase("2208", "Dell", "240");
    }
}
