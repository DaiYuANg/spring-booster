package org.kop.framework.spring.boot.starter.dict.controllers;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.boot.starter.dict.entities.Dict;
import org.kop.framework.spring.boot.starter.dict.repos.DictRepository;
import org.kop.standard.restful.resp.Response;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController("/dict")
@Slf4j
public class DictController {

    @Resource
    private DictRepository dictRepository;

    @RequestMapping(value = "/add", method = {RequestMethod.PUT, RequestMethod.POST})
    public Response add(@RequestBody Dict dict) {
        dictRepository.save(dict);
        return Response.ok();
    }

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void test() {
        log.info("terst");
    }
}
