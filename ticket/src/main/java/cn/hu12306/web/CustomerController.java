package cn.hu12306.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hcc
 */
@RestController
@RequestMapping(path = "/v1/customer")
public class CustomerController {

    @GetMapping("/query")
    public String query(@RequestParam("from") String from,
                        @RequestParam("to") String to) {
        return "ok";
    }

}
