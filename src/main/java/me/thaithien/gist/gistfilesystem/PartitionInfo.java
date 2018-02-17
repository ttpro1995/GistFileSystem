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

import com.fasterxml.jackson.core.JsonFactory;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.parser.JSONParser;

/**
 *
 * @author thaithien
 */
public class PartitionInfo implements Comparable<PartitionInfo> {

    /**
     * read json from file
     *
     * @param filepath
     * @return
     */
    public static List<PartitionInfo> readFromFile(String filepath) {
        Path path = Paths.get(filepath);
        File jsonFile = new File(path.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory f = mapper.getFactory();
        List<PartitionInfo> partitionList = new ArrayList<PartitionInfo>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFile));
            JsonParser parser = f.createParser(bufferedReader);
            if (parser.nextToken() != JsonToken.START_OBJECT) {
                throw new IOException("Json Start Object not found");
            }
            while (parser.nextToken() != JsonToken.END_OBJECT){
                int part_id = Integer.parseInt(parser.getCurrentName());
                parser.nextToken();
                String content = parser.getText();
                PartitionInfo info = new PartitionInfo(part_id, content);
                partitionList.add(info);
            }
            parser.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return partitionList;
    }

    /**
     * Save partition to file as json
     *
     * @param filepath path to output json
     * @param partitionList list of partitionInfo to write
     * @return true if success
     */
    public static boolean saveToFile(String filepath, List<PartitionInfo> partitionList) {
        Path path = Paths.get(filepath);
        File jsonFile = new File(path.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory f = mapper.getFactory();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()));
            JsonGenerator generator = f.createGenerator(writer);
            // generator.writeStringField("meow", "meowpurrpurrmeow"); // recognize it as valid json file
            generator.writeStartObject();
            for (PartitionInfo partition : partitionList) {
                generator.writeStringField(String.valueOf(partition.part), partition.content);
            }
            generator.writeEndObject();
            generator.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PartitionInfo(int part, String content) {
        this.part = part;
        this.content = content;
    }

    /**
     * the order of partition in file
     */
    public final int part;

    /**
     * ID of gist contain this partition or base64 string
     */
    public final String content;

    /**
     * Compare partition by info for sorting
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(PartitionInfo o) {
        return this.part - o.part;
    }

    /**
     * Return length of content Useful to measure base64 string length
     *
     * @return (int) length of content
     */
    public int length() {
        return this.content.length();
    }
}
