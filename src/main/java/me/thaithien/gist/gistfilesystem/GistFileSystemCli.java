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
import java.util.Collection;
import java.util.Collections;
import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.service.GistService;

/**
 *
 * @author thaithien
 */
public class GistFileSystemCli {
    public static void main(String[] args) throws IOException{
        String gist_token = "c46db6258939551cb4655a61bd8f29fd6afad4a1";
        GistFile file = new GistFile();
        file.setContent("I am Pusheen the cat");
        
        Gist gist = new Gist();
        gist.setDescription("meow");
        gist.setFiles(Collections.singletonMap("meow.txt", file));
    
        GistService service = new GistService();
        service.getClient().setOAuth2Token(gist_token);
        
        gist = service.createGist(gist);
        System.out.print(gist.getUrl());
    }
}
