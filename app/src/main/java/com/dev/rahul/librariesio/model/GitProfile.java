package com.dev.rahul.librariesio.model;

/**
 * Created by rahul on 19/11/17.
 */

public class GitProfile {

	private String name = "";
	private String login = "";
	private String avatarUrl = "";
	private String htmlUrl = "";
	private String company = "";
	private String location = "";
	private String bio = "";
	private String publicRepos = "";
	private String publicGists = "";
	private String followers = "";
	private String followings = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPublicRepos() {
		return publicRepos;
	}

	public void setPublicRepos(String publicRepos) {
		this.publicRepos = publicRepos;
	}

	public String getPublicGists() {
		return publicGists;
	}

	public void setPublicGists(String publicGists) {
		this.publicGists = publicGists;
	}

	public String getFollowers() {
		return followers;
	}

	public void setFollowers(String followers) {
		this.followers = followers;
	}

	public String getFollowings() {
		return followings;
	}

	public void setFollowings(String followings) {
		this.followings = followings;
	}
}
