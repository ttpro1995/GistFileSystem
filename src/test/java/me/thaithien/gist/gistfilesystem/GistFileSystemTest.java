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

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
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
public class GistFileSystemTest {
    
    public GistFileSystemTest() {
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
     * Test of storeFile method, of class GistFileSystem.
     */
    @Test
    public void testStoreFile() throws Exception {
        System.out.println("storeFile");
        String filepath = "testdata/source/Lieat_viet.pdf";
        GistFileSystem instance = GistFileSystem.getInstance();
        String expResult = "";
        String result = instance.storeFile(filepath);
        System.out.println(result);
    }

    /**
     * Test of getFile method, of class GistFileSystem.
     */
    @Test
    public void testGetFile() throws Exception {
        System.out.println("getFile");
        String gistID = "dcc73b53a14316ec035f3d4999a963c1";
        String filedir = "testdata/download";
        GistFileSystem instance = GistFileSystem.getInstance();
        instance.getFile(gistID, filedir);
        
        // calculate hash md5
        FileInputStream source = new FileInputStream(new File("testdata/source/Lieat_viet.pdf"));
        String md5Source = org.apache.commons.codec.digest.DigestUtils.md5Hex(source);
        source.close();
        
        FileInputStream download = new FileInputStream(new File("testdata/download/Lieat_viet.pdf"));
        String md5Download = org.apache.commons.codec.digest.DigestUtils.md5Hex(download);
        download.close();
        
        assertEquals(md5Source, md5Download);
    }

    /**
     * Test of getInstance method, of class GistFileSystem.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        GistFileSystem result = GistFileSystem.getInstance();
    }

    /**
     * Test of storeBigFile method, of class GistFileSystem.
     */
    @Test
    public void testStoreBigFile() throws Exception {
        System.out.println("storeBigFile");
        String filepath = "testdata/others/silver-tabby-cat-lying-on-brown-wooden-surface.jpeg";
        GistFileSystem instance = GistFileSystem.getInstance();
        String expResult = "";
        String result = instance.storeBigFile(filepath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of partitionEncodeString method, of class GistFileSystem.
     */
    @Test
    public void testPartitionEncodeString() throws Exception {
        System.out.println("partitionEncodeString");
        String file_path = "testdata/others/silver-tabby-cat-lying-on-brown-wooden-surface.jpeg";
        Path path = Paths.get(file_path);
        byte[] bytes = Files.readAllBytes(path);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        String encoded_str = new String(encoded);
        List<PartitionInfo> result = GistFileSystem.partitionEncodeString(encoded_str);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i).length());
        }
    }
    
}
