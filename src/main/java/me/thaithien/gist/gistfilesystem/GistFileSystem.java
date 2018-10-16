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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import me.thaithien.gist.gistfilesystem.manager.PartitionManager;
import me.thaithien.gist.gistfilesystem.object.Partition;
import me.thaithien.gist.gistfilesystem.object.PartitionInfo;
import org.apache.commons.io.FileUtils;
import org.eclipse.egit.github.core.GistFile;

/**
 * 
 *  A singleton class handle all file operation, including:
 *  + Store file
 *  + Retrieve file 
 *  + Browsing file
 * @author thaithien
 */
public class GistFileSystem {
    private static GistFileSystem INSTANCE = new GistFileSystem();
    private GistHelper gistHelper = null;
    
    /**
     * Limit size of encoded string
     */
    private static int SIZE_LIMIT = 1000000;

    /**
     * Initialize and get instance of GistHelper
     */
    private GistFileSystem() {
        this.gistHelper = GistHelper.getInstance();
    }
    
    /**
     * 
     * @return      GistFileSystem instance
     */
    public static GistFileSystem getInstance(){
        return INSTANCE;
    }
    
    /**
     * Store file into GistFileSystem.
     * It would convert any binary file into encode base64 string
     * @return Gist ID which is use to get gist 
     */
    public String storeFile(String filepath) throws IOException{
        Path path = Paths.get(filepath);
        
        byte[] bytes = Files.readAllBytes(path);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        String encoded_str = new String(encoded);
        return gistHelper.upload(path.getFileName()+".txt", "", encoded_str);
    }
    
    /**
     * Download gistID and decode into binary file
     * @param gistID 
     * @param filedir directory (folder) to store download file
     * @throws IOException 
     */
    public void getFile(String gistID, String filedir) throws IOException{
        GistFile gistFile = gistHelper.download(gistID);
        String encoded_str = gistFile.getContent();
        String filename = gistFile.getFilename();
        filename = filename.substring(0, filename.length() - 4);  // remove .txt
        byte[] decoded = Base64.getDecoder().decode(encoded_str);
        FileUtils.writeByteArrayToFile(new File(filedir, filename), decoded);
    }
    
    /**
     * Use to store big file. 
     * Encode base64 file
     * Split base64 string into many small string of size SIZE_LIMIT
     * up each part as a gist
     * Write gistID of all part into another gist
     * Return gistID of final gist
     * @param filepath
     * @throws IOException 
     */
    public String storeBigFile(String filepath) throws IOException {
        String dummy = "meow";
        
        Path path = Paths.get(filepath);
        
        byte[] bytes = Files.readAllBytes(path);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        String encoded_str = new String(encoded);
        if (encoded_str.length() > SIZE_LIMIT){
            PartitionInfo encodedPartitionInfo = PartitionManager.partitionEncodeString(path.getFileName().toString(), encoded_str, SIZE_LIMIT);

            //TODO: continue here
            // write partition info into text file
            
        }else{
            //small file, no trouble
            return gistHelper.upload(path.getFileName()+".txt", "", encoded_str);
        }
        return dummy;        
    }
    


    
}
