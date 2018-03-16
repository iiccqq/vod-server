package com.kexin.vod.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kexin.vod.dao.CarouselDao;
import com.kexin.vod.dao.ContentDao;
import com.kexin.vod.model.Content;

@RestController
public class IndexController {

	@Resource
	ContentDao contentDao;
	@Resource
	CarouselDao carouselDao;

	@RequestMapping("/index.do")
	Map<String,List<Content>>  getIndex() {
		Map<String,List<Content>> result = new HashMap<String,List<Content>> ();
		List<Content> carouselContentList = carouselDao.getContent();
		List<Content> indexContentList = contentDao.getContentsByCatalogId(1);
		result.put("carousel", carouselContentList);
		result.put("indexContent", indexContentList);
		return result;
	}
}
