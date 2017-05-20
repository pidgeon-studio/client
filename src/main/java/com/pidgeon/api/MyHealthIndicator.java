package com.pidgeon.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class MyHealthIndicator implements HealthIndicator {
  @Value("${pidgeon.path}")
  private String path;

  @Override
  public Health health() {
    String status = check();

    if (status.equals("UP")) {
      return Health.up().build();
    } else {
      return Health.down().build();
    }
  }

  public String check() {
    int size = new File(path).list().length;

    return size < 5 ? "UP" : "DOWN";
  }

}