package sky.demo.oautn2auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ConsumerTokenServices consumerTokenServices;

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

    @GetMapping("/rm")
    public String removeToken(@RequestParam String token) {
        consumerTokenServices.revokeToken(token);
        return "rm";
    }
}
