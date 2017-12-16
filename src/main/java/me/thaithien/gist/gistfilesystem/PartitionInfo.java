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

/**
 *
 * @author thaithien
 */
public class PartitionInfo implements Comparable<PartitionInfo>{

    public PartitionInfo(int part, String content) {
        this.part = part;
        this.content = content;
    }
    
    /**
     * the order of partition in file
     */
    public final int part;
    
    /**
     * ID of gist contain this partition
     * or 
     * base64 string
     */
    public final String content;
    
    /**
     * Compare partition by info for sorting
     * @param o
     * @return 
     */
    @Override
    public int compareTo(PartitionInfo o) {
        return this.part - o.part;
    }
    
    /**
     * Return length of content
     * Useful to measure base64 string length
     * @return (int) length of content
     */
    public int length(){
        return this.content.length();
    }
}
