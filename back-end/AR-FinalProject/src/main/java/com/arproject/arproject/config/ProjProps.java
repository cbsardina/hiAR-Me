package com.arproject.arproject.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ProjProps {

    public static void main(String[] args)
        throws Exception {

        FileInputStream propFile = new FileInputStream("projectProperties.txt");

        Properties p = new Properties(System.getProperties());

        p.load(propFile);

        System.setProperties(p);

        System.getProperties().list(System.out);

    }


}
