package com.Emp.entity;

import org.springframework.stereotype.Component;

@Component
public class Search {
private String search;

public Search(String search) {
	super();
	this.search = search;
}

public Search() {
	super();
	// TODO Auto-generated constructor stub
}

public String getSearch() {
	return search;
}

public void setSearch(String search) {
	this.search = search;
}

}
