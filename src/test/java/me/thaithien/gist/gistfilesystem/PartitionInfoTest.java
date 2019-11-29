/*
 * The MIT License
 *
 * Copyright 2018 thaithien.
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

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import me.thaithien.gist.gistfilesystem.object.PartitionInfo;
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
public class PartitionInfoTest {

    public PartitionInfoTest() {
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
     * Test of readFromFile method, of class PartitionInfo.
     */
//    @Test
//    public void testReadFromFile() {
//        System.out.println("readFromFile");
//        String filepath = "testdata/others/testPartitionInfo.json";
//
//        List<PartitionInfo> result = PartitionInfo.readFromFile(filepath);
//        List<PartitionInfo> expectedPartition = new ArrayList<>();
//        expectedPartition.add(new PartitionInfo(0, "https://gist.github.com/ttpro1995/7ae04526fb53b34e72f382b18db36065"));
//        expectedPartition.add(new PartitionInfo(1, "https://gist.github.com/unitycoder/62e2fca5bd00a3b907cfe0a95d04f62d"));
//
//        for (PartitionInfo info : result){
//            System.out.println(String.valueOf(info.part) +" " + info.content);
//        }
//
//        for (int i = 0; i < result.size(); i ++) {
//            int compareResult = result.get(i).compareTo(expectedPartition.get(i));
//            assertEquals(0, compareResult);
//        }
//    }

    /**
     * Test of saveToFile method, of class PartitionInfo.
     */
//    @Test
//    public void testSaveToFile() throws IOException {
//
//        System.out.println("partitionEncodeString");
//        String file_path = "testdata/others/testPartitionInfo.json";
//        Path path = Paths.get(file_path);
//
//        List<PartitionInfo> inPartition = new ArrayList<>();
//        inPartition.add(new PartitionInfo(0, "https://gist.github.com/ttpro1995/7ae04526fb53b34e72f382b18db36065"));
//        inPartition.add(new PartitionInfo(1, "https://gist.github.com/unitycoder/62e2fca5bd00a3b907cfe0a95d04f62d"));
//
//        System.out.println("saveToFile");
//        boolean expResult = true;
//        boolean result = PartitionInfo.saveToFile(file_path, inPartition);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of compareTo method, of class PartitionInfo.
     */
//    @Test
//    public void testCompareTo() {
//        System.out.println("compareTo");
//        PartitionInfo o = null;
//        PartitionInfo instance = null;
//        PartitionInfo part0 = new PartitionInfo(0, "https://gist.github.com/ttpro1995/7ae04526fb53b34e72f382b18db36065");
//        PartitionInfo part1 = new PartitionInfo(1, "https://gist.github.com/unitycoder/62e2fca5bd00a3b907cfe0a95d04f62d");
//
//        int result = part0.compareTo(part1);
//        assertEquals(result, -1);
//        //assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of length method, of class PartitionInfo.
     */
    @Test
    public void testLength() {
//        System.out.println("length");
//        PartitionInfo instance = null;
//        int expResult = 0;
//        int result = instance.length();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
