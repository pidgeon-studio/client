package com.pidgeon.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

@RestController
public class SMSController {
  @Value("${pidgeon.path}")
  private String path;

  @RequestMapping(value = "/send", method = RequestMethod.POST)
  public SMSModel send(@RequestBody SMSModel smsModel) {
    try {
      String fullPath = path + "file" +smsModel.getId();
      String csn      = "UTF-8";

      PrintWriter writer = new PrintWriter(fullPath, csn);
      writer.println("To: " + smsModel.getRecipient());
      writer.println("");
      writer.println(smsModel.getMessage());
      writer.close();
      
      final File file = new File(fullPath);
      file.setReadable(true, false);
      file.setExecutable(true, false);
      file.setWritable(true, false);

    } catch (IOException e) {}

    return smsModel;
  }
}
