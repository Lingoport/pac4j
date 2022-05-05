package org.pac4j.oauth.client;


import org.pac4j.core.redirect.RedirectAction;
import org.pac4j.oauth.profile.bitbucket2.Bitbucket2Profile;
import org.pac4j.oauth.profile.bitbucket2.Bitbucket2ProfileDefinition;
import org.pac4j.scribe.builder.api.BitBucket2Api;

/**
 * This class is the OAuth client to authenticate users in Bitbucket.
 *
 * It returns a {@link org.pac4j.oauth.profile.bitbucket.BitbucketProfile}.
 *
 * @author Sebastian Sdorra
 * @since 1.5.1
 */
public class Bitbucket2Client extends OAuth20Client<Bitbucket2Profile> {

    public final static String DEFAULT_SCOPE = "repository";

    protected String scope = DEFAULT_SCOPE;
    
    public Bitbucket2Client() {
    	setScope(DEFAULT_SCOPE);
    }

    public Bitbucket2Client(final String key, final String secret) {
        setKey(key);
        setSecret(secret);
        setScope(DEFAULT_SCOPE);
    }

    @Override
    protected void clientInit() {
        configuration.setApi(BitBucket2Api.instance());
        configuration.setProfileDefinition(new Bitbucket2ProfileDefinition());
        configuration.setScope(this.scope);
        //configuration.setTokenAsHeader(true);
        //configuration.setHasGrantType(true);
        defaultLogoutActionBuilder((ctx, profile, targetUrl) -> RedirectAction.redirect("https://bitbucket.org/account/signout/"));

        super.clientInit();
    }
    
    public String getScope() {
        return getConfiguration().getScope();
    }

    public void setScope(final String scope) {
        getConfiguration().setScope(scope);
    }
}
