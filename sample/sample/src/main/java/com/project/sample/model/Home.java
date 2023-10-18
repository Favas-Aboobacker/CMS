package com.project.sample.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
public class Home {

    @GetMapping
    public String home(){
        return "Applicatiobn is works!!! "+new Date();

    }
}
