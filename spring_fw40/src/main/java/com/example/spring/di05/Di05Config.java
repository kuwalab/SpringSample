package com.example.spring.di05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Di05Config {
	@Bean
	public SampleBean sampleBean() {
		SampleBean sampleBean = new SampleBean();
		List<String> list = new ArrayList<>();
		list.add("list 1");
		list.add("list 2");
		sampleBean.setList(list);

		Map<String, String> map = new HashMap<>();
		map.put("mapKey1", "map 1");
		map.put("mapKey2", "map 2");
		sampleBean.setMap(map);

		Set<String> set = new HashSet<>();
		set.add("set 1");
		set.add("set 2");
		sampleBean.setSet(set);

		Properties properties = new Properties();
		properties.put("propKey1", "prop1");
		properties.put("propKey2", "prop2");
		sampleBean.setProperties(properties);

		return sampleBean;
	}
}
