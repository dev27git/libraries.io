package com.dev.rahul.librariesio.utility.credentials;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by rahul on 22/10/17.
 */

public class API {
	public static final String MAIN_URL = "https://libraries.io/api/";
	public static final String API_KEY = "api_key";

	/**
	 * ==Pagination==
	 * All requests that return multiple results can be paginated using the `page` and `per_page` query parameters.
	 * page (default is `1`)
	 * per_page (default is `30`, max is `100`)
	 */

	/**
	 * ==Platforms==
	 * Get list of supported package managers
	 */
	public static String platforms() {
		return MAIN_URL + "platforms" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * ==Project==
	 * Get information about a project and it's versions.
	 */
	public static String projectInfo(String platform, String name) {
		return MAIN_URL + platform + "/" + name + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Project Dependencies
	 * Get a list of dependencies for a version of a project, pass latest to get dependency info for the latest available version
	 */
	public static String dependencies(String platform, String name, String version) {
		return MAIN_URL + platform + "/" + name + "/" + version + "/" + "dependencies" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Project Dependents
	 * Get projects that have at least one version that depends on a given project.
	 */
	public static String dependents(String platform, String name) {
		return MAIN_URL + platform + "/" + name + "/" + "dependents" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Project Dependent Repositories
	 * Get repositories that depend on a given project.
	 */
	public static String dependentRepositories(String platform, String name) {
		return MAIN_URL + platform + "/" + name + "/" + "dependent_repositories" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Project Search
	 * Search for projects
	 */
	public static String search(HashMap<String,String> params) {
		return MAIN_URL + "search" + "?" + API_KEY + "=" + Libraries.API_KEY + getQueryParameters(params);
	}

	/**
	 * Repository
	 * Get a info for a repository. Currently only works for open source repositories.
	 */
	public static String repository(String owner, String name) {
		return MAIN_URL + "github" + "/" + owner + "/" + name + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Repository Dependencies
	 * Get a list of dependencies for a repositories. Currently only works for open source repositories.
	 */
	public static String repositoryDependencies(String owner, String name) {
		return MAIN_URL + "github" + "/" + owner + "/" + name + "/" + "dependencies" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Repository Projects
	 * Get a list of projects referencing the given repository.
	 */
	public static String repositoryProjects(String owner, String name) {
		return MAIN_URL + "github" + "/" + owner + "/" + name + "/" + "projects" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * User
	 * Get information for a given User or Organization
	 */
	public static String user(String login) {
		return MAIN_URL + "github" + "/" + login + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * User Repositories
	 * Get repositories owned by a User
	 */
	public static String userRepositories(String login) {
		return MAIN_URL + "github" + "/" + login + "/" + "repositories" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * User Projects
	 * Get a list of projects referencing the given users repositories.
	 */
	public static String userProjects(String login) {
		return MAIN_URL + "github" + "/" + login + "/" + "projects" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * User Subscriptions
	 * List projects that a user is subscribed to recieved notifications about new releases
	 */
	public static String userSubscriptions() {
		return MAIN_URL + "subscriptions" + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Subscribe to a project
	 * Subscribe to recieved notifications about new releases of a project
	 * Parameters: include_prerelease
	 * Method Type : POST
	 */
	public static String userSubscriptionsToProjects(String platform, String name) {
		return MAIN_URL + "subscriptions" + "/" + platform + "/" + name + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Check if subscribed to a project
	 * Check if a users is subscribed to recieved notifications about new releases of a project
	 */
	public static String checkUserSubscriptionsToProjects(String platform, String name) {
		return MAIN_URL + "subscriptions" + "/" + platform + "/" + name + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Update a subscription
	 * Update the options for a subscription
	 * Parameters: include_prerelease
	 * Method Type : PUT
	 */
	public static String updateSubscriptions(String platform, String name) {
		return MAIN_URL + "subscriptions" + "/" + platform + "/" + name + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	/**
	 * Unsubscribe from a project
	 * Stop recieving release notifications from a project
	 * Method Type : DELETE
	 */
	public static String unsubscribeFromProject(String platform, String name) {
		return MAIN_URL + "subscriptions" + "/" + platform + "/" + name + "?" + API_KEY + "=" + Libraries.API_KEY;
	}

	public static String getQueryParameters(HashMap<String,String> params) {

		Set<Map.Entry<String, String>> entrySet = params.entrySet();

		StringBuilder queryStrings = new StringBuilder();
		for (Map.Entry entry : entrySet) {
			queryStrings.append("&" + entry.getKey() + "=" + entry.getValue());
		}
		return queryStrings.toString();
	}
}
