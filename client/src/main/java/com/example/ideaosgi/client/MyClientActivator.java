package com.example.ideaosgi.client;

import com.example.ideaosgi.api.MyApiClass;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class MyClientActivator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        // IDEA complains about the following line:
        // The package 'com.example.ideaosgi.api' is not exported by the bundle dependencies
        new MyApiClass();
    }

    public void stop(BundleContext context) throws Exception {

    }

}
