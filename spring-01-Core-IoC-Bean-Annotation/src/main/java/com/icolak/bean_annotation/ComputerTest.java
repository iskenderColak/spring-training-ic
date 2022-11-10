package com.icolak.bean_annotation;

import com.icolak.bean_annotation.casefactory.Case;
import com.icolak.bean_annotation.config.ComputerConfig;
import com.icolak.bean_annotation.config.RandomConfig;
import com.icolak.bean_annotation.monitorfactory.Monitor;
import com.icolak.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {

        // Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        // Creating container by using Bean Factory
        BeanFactory context = new AnnotationConfigApplicationContext();

        Monitor theMonitor = container.getBean(Monitor.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);
        Case theCase = container.getBean(Case.class);

        PC myPc = new PC(theCase, theMonitor, theMotherboard);

        myPc.powerUp();

    }
}
