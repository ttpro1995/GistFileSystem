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
package me.thaithien.gist.gistfilesystem.object;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thaithien
 */
public class PartitionInfo {
    public String name;
    public String status;
    public List<Partition> contents;

    public static final String STATUS_URL = "STATUS_URL";
    public static final String STATUS_ENCODED = "STATUS_ENCODED";

    public PartitionInfo(String name, List<Partition> contents) {
        this.name = name;
        this.contents = contents;
    }

    public PartitionInfo(String name, List<Partition> contents, String status) {
        this.name = name;
        this.status = status;
        this.contents = contents;
    }

    public PartitionInfo(String name) {
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Partition> getContents() {
        return contents;
    }

    public void setContents(List<Partition> contents) {
        this.contents = contents;
    }

    public void addPartition(Partition partition){
        this.contents.add(partition);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
