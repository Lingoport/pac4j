package org.pac4j.oauth.profile.bitbucket2;

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
 * This class is the Bitbucket profile definition.
 * 
 * @author Sebastian Sdorra
 * @since 1.5.1
 */
public class Bitbucket2ProfileDefinition extends OAuth20ProfileDefinition<Bitbucket2Profile> {

	public static final String USERNAME = "username";
	public static final String DISPLAY_NAME = "display_name";
    public static final String NICKNAME = "nickname";
    public static final String TYPE = "type";
    public static final String ACCOUNT_ID = "account_id";
    public static final String UUID = "uuid";

    public Bitbucket2ProfileDefinition() {
        super(x -> new Bitbucket2Profile());
        Arrays.asList(new String[] {
                USERNAME, DISPLAY_NAME, NICKNAME, TYPE, ACCOUNT_ID, UUID
            }).forEach(a -> primary(a, Converters.STRING));
    }

    @Override
    public String getProfileUrl(final OAuth2AccessToken accessToken, final OAuth20Configuration configuration) {
    	logger.info("In BitBucket getProfileUrl()");
        return "https://api.bitbucket.org/2.0/user/";
    }

    @Override
    public Bitbucket2Profile extractUserProfile(final String body) throws HttpAction {
        final Bitbucket2Profile profile = newProfile();
        logger.info("In BitBucket extractUserProfile()");
        JsonNode json = JsonHelper.getFirstNode(body);
        if (json != null) {
            profile.setId(JsonHelper.getElement(json, "uuid"));
            for (final String attribute : getPrimaryAttributes()) {
                convertAndAdd(profile, attribute, JsonHelper.getElement(json, attribute));
            }
        }
        return profile;
    }
}
