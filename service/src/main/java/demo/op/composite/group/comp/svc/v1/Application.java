package demo.op.composite.group.comp.svc.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = {"com.macys.mst.order.foundation", "demo.op.composite.group.comp.svc.v1"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}