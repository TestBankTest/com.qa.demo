package com.qa.testutil;


import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestRetryAnalyzerListener implements IAnnotationTransformer {

    /*
    First, we need to create TestRetryAnalyzerListener class which is implementing the IAnnotationTransformer interface.
    We will use the public void transform(ITestAnnotation annotation, Class testClass,Constructor testConstructor, Method testMethod) method.
    This method will be invoked by TestNG to give you a chance to modify a TestNG annotation read from your test classes.
    Then the Listener is for calling the TestRetryAnalyzer.class (Same Class We created above) to reRun the Failed Test.

    TestNg needs this Listener to be known very early, So We will use this directly in TestNG.
    xml not in our test Class because Listeners can be used in TestClass.
     */




    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(TestRetryAnalyzer.class);
    }
}
