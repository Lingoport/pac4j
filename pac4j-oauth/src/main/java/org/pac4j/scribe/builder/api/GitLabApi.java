package org.pac4j.scribe.builder.api;

import com.github.scribejava.core.builder.api.DefaultApi20;
//import com.github.scribejava.core.extractors.OAuth2AccessTokenExtractor;
import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.Verb;
//import java.util.Map;
//import com.github.scribejava.core.model.OAuthConfig;
//import com.github.scribejava.core.utils.OAuthEncoder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * This class represents the OAuth API implementation for GitLab.
 * 
 * @author Mary Heilner
 */
public class GitLabApi extends DefaultApi20 {
	
	//private static final Logger logger = LoggerFactory.getLogger(GitLabApi.class);
  
	protected GitLabApi() {
    }

    private static class InstanceHolder {
        private static final GitLabApi INSTANCE = new GitLabApi();
    }

    public static GitLabApi instance() {
        return InstanceHolder.INSTANCE;
    }
    
    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://gitlab.com/oauth/token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://gitlab.com/oauth/authorize";
    }

    /*
    @Override
    public String getAuthorizationUrl(OAuthConfig oAuthConfig, Map<String, String> additionalParams) {
        // #show_login skips showing the registration form, which is only
        // cluttersome.
    	
    	logger.info("in getAuthorizationUrl");
    	
        return String.format(getAuthorizationBaseUrl() + "?client_id=%s&scope=%s&response_type=%s",
            oAuthConfig.getApiKey(), (oAuthConfig.getScope()!=null)?OAuthEncoder.encode(oAuthConfig.getScope()):"",
            "code");
    }
    */
    
    
    @Override
    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        //return OAuth2AccessTokenExtractor.instance();
        return OAuth2AccessTokenJsonExtractor.instance();
    }
    
}
