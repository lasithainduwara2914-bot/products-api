package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        return "Products API v1.0 - Active session: " + LocalDateTime.now();
    }
}