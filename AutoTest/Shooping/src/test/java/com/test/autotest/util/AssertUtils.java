package com.test.autotest.util;

import com.test.autotest.cases.TestRegister;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class AssertUtils {
    public boolean getAssertResult(String actualResult,boolean expected,String condition){
        if(actualResult.contains(condition)){
            Assert.assertTrue(expected);
            return true;
        }else {
            return false;
        }
    }
}
