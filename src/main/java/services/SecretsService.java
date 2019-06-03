package services;

import java.util.HashMap;

public class SecretsService {

    private static HashMap<String, String> secrets = new HashMap<String, String>();

    public SecretsService() {
        secrets.put("postman", "postmansecret");
        secrets.put("tournament", "tournamentsecret");
    }

    public boolean isValidKey(String sourceOrigin, String sourceSecret) {
        String mysecret = secrets.get(sourceOrigin);

        return mysecret.length() > 0 ? mysecret.equals(sourceSecret) : false;
    }
}