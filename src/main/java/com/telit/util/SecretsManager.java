package com.telit.util;

import com.telit.constant.EnvType;
import com.telit.model.SecretsRoot;

public class SecretsManager {
  private static SecretsRoot secrets;

  private SecretsManager() {
  }

  private static synchronized SecretsRoot getSecrets() {
    if (secrets == null) {
      secrets = DataReader.fromJson("local-secrets.json", SecretsRoot.class);
    }
    return secrets;
  }

  public static SecretsRoot.EnvCredentials getCredentials() {
    String ciEmail = System.getenv("TEST_EMAIL");
    String ciPassword = System.getenv("TEST_PASSWORD");

    if (ciEmail != null && ciPassword != null) {
      SecretsRoot.EnvCredentials credentials = new SecretsRoot.EnvCredentials();
      credentials.setEmail(ciEmail);
      credentials.setPassword(ciPassword);
      return credentials;
    }

    EnvType currentEnv = ConfigManager.validateAndGetEnv();
    SecretsRoot.EnvCredentials credentials = getSecrets().getEnvCredentials().get(currentEnv.toString().toLowerCase());

    if (credentials == null) {
      throw new RuntimeException("❌ CRITICAL: Credentials for environment [" + currentEnv + "] missing in local-secrets.json");
    }
    return credentials;
  }
}
