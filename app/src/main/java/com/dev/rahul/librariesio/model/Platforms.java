package com.dev.rahul.librariesio.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by rahul on 11/11/17.
 */

public class Platforms {
	private String name = "";
	private String projectsCount = "";
	private String homePage = "";
	private String color = "";
	private String defaultLanguage = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectsCount() {
		return getConvertedProjectedCount(Long.parseLong(projectsCount));
	}

	public void setProjectsCount(String projectsCount) {
		this.projectsCount = projectsCount;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	private String getConvertedProjectedCount(long count) {

		if (count >=1000) {
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			decimalFormat.setRoundingMode(RoundingMode.CEILING);
			return String.valueOf(decimalFormat.format(count/1000)) + "K";
		} else {
			return String.valueOf(count);
		}
	}
}
