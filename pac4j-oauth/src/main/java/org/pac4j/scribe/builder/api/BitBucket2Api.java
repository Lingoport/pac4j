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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents the OAuth API implementation for Bitbucket.
 * 
 * @author Sebastian Sdorra
 * @since 1.5.1
 */
public class BitBucket2Api extends DefaultApi20 {
	
	private static final Logger logger = LoggerFactory.getLogger(BitBucket2Api.class);
  
	protected BitBucket2Api() {
    }

    private static class InstanceHolder {
        private static final BitBucket2Api INSTANCE = new BitBucket2Api();
    }

    public static BitBucket2Api instance() {
        return InstanceHolder.INSTANCE;
    }
    
    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override
    public String getAccessTokenEndpoint() {
    	logger.info("in getAccessTokenEndpoint");
        return "https://bitbucket.org/site/oauth2/access_token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
    	logger.info("in getAuthorizationBaseUrl");
        return "https://bitbucket.org/site/oauth2/authorize";
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
    	logger.info("in getAccessTokenExtractor");
        //return OAuth2AccessTokenExtractor.instance();
        return OAuth2AccessTokenJsonExtractor.instance();
    }
    
}
