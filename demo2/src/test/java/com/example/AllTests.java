/**
 * 
 */
package com.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.user.controller.UserTest;

/**
 * @author 정명성
 * create date : 2016. 2. 4.
 * com.example.AllTests.java
 */
@RunWith(Suite.class)
@SuiteClasses({ UserTest.class })
public class AllTests {

}
