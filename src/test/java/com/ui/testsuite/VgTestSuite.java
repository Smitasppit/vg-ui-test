package com.ui.testsuite;

import com.ui.tests.VgCompareFundsTest;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
public class VgTestSuite {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {
                VgCompareFundsTest.class
        });
        testng.addListener(tla);
        testng.run();
    }
}
