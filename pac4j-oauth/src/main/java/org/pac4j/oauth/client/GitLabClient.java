package org.pac4j.oauth.client;


//import org.pac4j.core.redirect.RedirectAction;
import org.pac4j.oauth.profile.gitlab.GitLabProfile;
import org.pac4j.oauth.profile.gitlab.GitLabProfileDefinition;
import org.pac4j.scribe.builder.api.GitLabApi;

/**
 * This class is the OAuth client to authenticate users in Bitbucket.
 *
 * It returns a {@link org.pac4j.oauth.profile.gitlab.GitLabProfile}.
 *
 * @author Mary Heilner
 */
public class GitLabClient extends OAuth20Client<GitLabProfile> {

    public final static String DEFAULT_SCOPE = "read_api";

    protected String scope = DEFAULT_SCOPE;
    
    public GitLabClient() {
    	setScope(DEFAULT_SCOPE);
    }

    public GitLabClient(final String key, final String secret) {
        setKey(key);
        setSecret(secret);
        setScope(DEFAULT_SCOPE);
    }

    @Override
    protected void clientInit() {
        configuration.setApi(GitLabApi.instance());
        configuration.setProfileDefinition(new GitLabProfileDefinition());
        configuration.setScope(this.scope);
        //configuration.setTokenAsHeader(true);
        //configuration.setHasGrantType(true);
        ///defaultLogoutActionBuilder((ctx, profile, targetUrl) -> RedirectAction.redirect("https://bitbucket.org/account/signout/"));

        super.clientInit();
    }
    
    public String getScope() {
        return getConfiguration().getScope();
    }

    public void setScope(final String scope) {
        getConfiguration().setScope(scope);
    }
}
