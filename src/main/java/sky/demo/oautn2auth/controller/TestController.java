package sky.demo.oautn2auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/a1")
    public String aa1() {
        return "a1";
    }

    @GetMapping("/a2")
    public String aa2() {
        return "a2";
    }
}
