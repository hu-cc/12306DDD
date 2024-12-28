package cn.hu12306.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hcc
 */
@RestController
@RequestMapping(path = "/v1/customer")
public class StationController {

    @PostMapping("/add")
    public String add() {
        return "ok";
    }

}
