package org.pac4j.oauth.profile.gitlab;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;
//import org.pac4j.core.context.Pac4jConstants;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.converter.Converters;
import org.pac4j.oauth.config.OAuth20Configuration;
import org.pac4j.oauth.profile.JsonHelper;
import org.pac4j.oauth.profile.definition.OAuth20ProfileDefinition;

import java.util.Arrays;

/**
 * This class is the GitLab profile definition.
 * 
 * @author Mary Heilner
 */
public class GitLabProfileDefinition extends OAuth20ProfileDefinition<GitLabProfile> {

	public static final String USERNAME = "username";
	public static final String NAME = "name";

    public GitLabProfileDefinition() {
        super(x -> new GitLabProfile());
        Arrays.asList(new String[] {
                USERNAME, NAME
            }).forEach(a -> primary(a, Converters.STRING));
    }

    @Override
    public String getProfileUrl(final OAuth2AccessToken accessToken, final OAuth20Configuration configuration) {
    	logger.info("In GitLab getProfileUrl()");
        return "https://gitlab.com/api/v4/user/";
    }

    @Override
    public GitLabProfile extractUserProfile(final String body) throws HttpAction {
        final GitLabProfile profile = newProfile();
        logger.info("In GitLab extractUserProfile()");
        JsonNode json = JsonHelper.getFirstNode(body);
        if (json != null) {
            profile.setId(JsonHelper.getElement(json, "id"));
            for (final String attribute : getPrimaryAttributes()) {
                convertAndAdd(profile, attribute, JsonHelper.getElement(json, attribute));
            }
        }
        return profile;
    }
}
