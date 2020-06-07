package com.bookit.units;

import com.bookit.utilities.APIUtilities;
import org.junit.Assert;
import org.junit.Test;

import java.net.PortUnreachableException;

public class APIUtilititiesUnitTest {

    @Test
    public void getTokenTest(){

        String token = APIUtilities.getToken();
        String tokenforStudent =APIUtilities.getToken("student");
        String tokenforTeacher =APIUtilities.getToken("teacher");

        Assert.assertNotNull(token);
        Assert.assertNotNull(tokenforStudent);
        Assert.assertNotNull(tokenforTeacher);
    }

    @Test
    public void testUserExists(){
        int actual =APIUtilities.getUserID("ssdsssssssdds@gmail.com","451233");
        Assert.assertEquals(-1,actual);
    }

}
