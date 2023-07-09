package org.kop.framework.spring.boot.starter.groundwork.dict.controllers;

import jakarta.annotation.Resource;
import org.kop.framework.spring.boot.starter.groundwork.dict.entities.Dict;
import org.kop.framework.spring.boot.starter.groundwork.dict.repos.DictRepository;
import org.kop.standard.restful.resp.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/dict")
public class DictController {

    @Resource
    private DictRepository dictRepository;

    @RequestMapping(value = "/add", method = {RequestMethod.PUT, RequestMethod.POST})
    public Response add(@RequestBody Dict dict) {
        dictRepository.save(dict);
        return Response.ok();
    }
}
