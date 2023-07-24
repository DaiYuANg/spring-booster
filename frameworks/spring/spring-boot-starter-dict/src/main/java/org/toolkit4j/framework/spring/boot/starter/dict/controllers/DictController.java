package org.toolkit4j.framework.spring.boot.starter.dict.controllers;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.toolkit4j.framework.spring.boot.starter.dict.entities.Dict;
import org.toolkit4j.framework.spring.boot.starter.dict.repos.DictRepository;
import org.toolkit4j.standard.restful.resp.Response;

@RestController("/dict")
@Slf4j
public class DictController {

	@Resource
	private DictRepository dictRepository;

	@RequestMapping(
			value = "/add",
			method = {RequestMethod.PUT, RequestMethod.POST})
	public Response<Object> add(@RequestBody Dict dict) {
		dictRepository.save(dict);
		return Response.success(1);
	}

	@GetMapping("list")
	public Response<Page<Dict>> queryList(
			@RequestParam Dict dict, @RequestParam Integer pageNo, @RequestParam Integer pageSize) {
		return Response.success(dictRepository.findAll(Example.of(dict), PageRequest.of(pageNo, pageSize)));
	}
}
