/*
 * The MIT License
 *
 * Copyright 2017 thaithien.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


package me.thaithien.gist.gistfilesystem;

import org.eclipse.egit.github.core.GistFile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thaithien
 */
public class GistHelperTest {
    private static String UNIT_TEST_API_KEY = "8c2c3158f8348df6ca5289692a0ffa213e40ee25";
    public GistHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of upload method, of class GistHelper.
     */
    @Test
    public void testUpload() throws Exception {
        System.out.println("upload");
        String name = "testUpload.txt";
        String des = "test upload with JUnit";
        String content = "testUpload now";
        GistHelper instance = GistHelper.getInstance();
        instance.authenticate(UNIT_TEST_API_KEY);
        String result = instance.upload(name, des, content);

        System.out.println(result);
    }

    /**
     * Test of download method, of class GistHelper.
     */
    @Test
    public void testDownload() throws Exception {
        System.out.println("download");
        String id = "6081cc947734e312f5393dfb274a076e";
        GistHelper instance = GistHelper.getInstance();
        String expResult = "wQm&AZ99TQMS3LEf8P00IBD*qC@$TM3wVWr5@*^qt3*i7rJG48bqDYhKRpBAL6e1mg&^wB*43Kmm7Lr^0eg*e76Ijsp#r58cP@@9Xs5xgJyt8A8JR33uxI&fUWK8Kun0MfieHD6p*MtbB9a4!UDbyc6wbUHhZKDvx6RvB3B0@dmKx83Lr9Ttu34a9I!H8uPpsSWGkcV3";
        GistFile result = instance.download(id);
        assertEquals(expResult, result.getContent());

    }
    
}
