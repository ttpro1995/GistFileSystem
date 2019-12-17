package me.thaithien.gist.gistfilesystem.manager;

import com.google.gson.Gson;
import me.thaithien.gist.gistfilesystem.GistHelper;
import me.thaithien.gist.gistfilesystem.object.PartitionInfo;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import static org.junit.Assert.*;

public class PartitionManagerTest {
    private static String UNIT_TEST_API_KEY = ApiKeyManager.getTestGitApiKey();

    @Test
    public void uploadPartitionInfo() throws IOException {
        int SIZE_LIMIT = 100000;
        String filepath = "testdata/others/silver-tabby-cat-lying-on-brown-wooden-surface.jpeg";
        Path path = Paths.get(filepath);
        GistHelper instance = GistHelper.getInstance();
        instance.authenticate(UNIT_TEST_API_KEY);

        byte[] bytes = Files.readAllBytes(path);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        String encoded_str = new String(encoded);
        if (encoded_str.length() > SIZE_LIMIT) {
            PartitionInfo partitionInfo = PartitionManager.partitionEncodeString(path.getFileName().toString(), encoded_str, SIZE_LIMIT);
            System.out.println(partitionInfo.getContents().size());
            PartitionInfo urlPartitionInfo = PartitionManager.uploadPartitionInfo(partitionInfo);
            Gson gson = new Gson();
            String json = gson.toJson(urlPartitionInfo);
            System.out.println(json);
        } else {
            fail("file must bigger than SIZE LIMIT");
        }
    }
}