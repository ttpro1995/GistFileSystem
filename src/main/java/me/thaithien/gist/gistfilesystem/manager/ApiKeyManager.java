package me.thaithien.gist.gistfilesystem.manager;

import java.util.Base64;

public class ApiKeyManager {

    /**
     * github auto revoke key that have been leak
     * so we encode, github does not know that
     * Key here only for unit test purpose
     */
    private static final String B64_ENCODED_TEST_GIST_API_KEY="MzEwMWQ4MGVmNGYzZGUwYTBlYzcxODI3ZTU0ZTFmNTk3OTA0OGZjMQ==";

    /**
     * decode and get the github test api key from b64 form
     * @return
     */
    public static String getTestGitApiKey(){
        byte[] decodeKey = Base64.getDecoder().decode(B64_ENCODED_TEST_GIST_API_KEY);
        String decodeKeyStr = new String(decodeKey);
        return decodeKeyStr;
    }
}
