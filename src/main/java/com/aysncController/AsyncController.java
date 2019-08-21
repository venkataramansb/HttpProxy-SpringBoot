package com.aysncController;

import Core.ProcessorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    Demo demo;

    @GetMapping(path = "/get")
    public ProcessorData getData() {
        ProcessorData processorData = demo.atlasCall(new ProcessorData("1212ASD", "E", "M1231"));
        return processorData;
    }

    @GetMapping(path = "/getSim")
    public String getSimDetails() {
        System.out.println("------------------- inside");
       demo.callVodafone();
        return "Success";
    }
}
