package com.example.spring.sample05;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SampleBean {
	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;
	private Properties properties;

	@Override
	public String toString() {
		return "SampleBean [list=" + list + ", map=" + map + ", set=" + set
				+ ", properties=" + properties + "]";
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
