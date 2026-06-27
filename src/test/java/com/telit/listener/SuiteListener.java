package com.telit.listener;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
  private static final String BASE_OUTPUT_DIR = "target/exec-outputs";

  static {
    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
    String execFolder = BASE_OUTPUT_DIR + "/exec_" + timestamp;

    System.setProperty("execOutputDir", execFolder);

    new File(execFolder).mkdirs();
  }

  @Override
  public void onStart(ISuite suite) {
  }
}
