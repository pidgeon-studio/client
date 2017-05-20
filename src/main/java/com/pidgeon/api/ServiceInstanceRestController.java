package com.pidgeon.api;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ServiceInstanceRestController {

  private WhoAmI whoAmI;

  @Autowired
  public ServiceInstanceRestController(WhoAmI whoAmI) {
    this.whoAmI = whoAmI;
  }

  @RequestMapping("/")
  public String index() {
    return
        "<ul>" +
            "<li><a href=\"/whoami\">whoami</a>" +
            "</ul>";
  }

  @RequestMapping("/whoami")
  public WhoAmI whoami() {
    return whoAmI;
  }
}