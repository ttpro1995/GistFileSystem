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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.service.GistService;

/**
 * helper for simple upload and download gist
 * @author thaithien
 */
public class GistHelper {

    public static GistService service;
    private static final GistHelper INSTANCE = new GistHelper();
    
    /**
     * Constructor
     */
    private GistHelper() {
        service = new GistService();
    }
    
    public static GistHelper getInstance(){
        return INSTANCE;
    }
    
    /**
     * Authenticate with personal access token
     * Get access token here https://github.com/settings/tokens
     * @param accessToken your accessToken
     */
    public void authenticate(String accessToken){
        this.service.getClient().setOAuth2Token(accessToken);
    }

    /**
     * Authenticate with username and password
     * Least secure
     * @param username a username/email you login github
     * @param password a password you login github
     */    
    public void authenticate(String username, String password){
        this.service.getClient().setCredentials(username, password);
    }
    
    
    /**
     * Upload a text file on gist. Only one file per gist.
     * @param name  the only file name
     * @param des   gist description
     * @param content   file content
     * @return Gist ID which is used to retrieve gist  
     * @throws IOException 
     */
    public String upload(String name, String des, String content) throws IOException{
        GistFile file = new GistFile();
        file.setContent(content);
        
        Gist gist = new Gist();
        gist.setDescription(des);
        gist.setFiles(Collections.singletonMap(name, file));
    
        gist = service.createGist(gist);
        return gist.getId();
    }
    
    /**
     * Download gist
     * Can only download text gist with ONE file
     * @param id gist id
     * @return a GistFile object
     * @throws IOException 
     */
    public GistFile download(String id) throws IOException{
        Gist gist = service.getGist(id);
        Map<String, GistFile> files = gist.getFiles();
        int n_file = 0;
        GistFile ret_file = null;
        for (String key : files.keySet()) { 
            // IT SHOULD BE ONLY ONE FILE
            GistFile file = files.get(key);
            ret_file = file;
            n_file += 1;
            if (n_file > 1){
                throw new IOException("More than one file per gist "+id);
            }
        }        
        
        return ret_file;
    }
}
