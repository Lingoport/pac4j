package org.pac4j.oauth.profile.bitbucket2;

import org.pac4j.oauth.profile.OAuth20Profile;


/**
 * <p>This class is the user profile for Bitbucket with appropriate getters.</p>
 * <p>It is returned by the {@link org.pac4j.oauth.client.BitbucketClient}.</p>
 *
 * @author Sebastian Sdorra
 * @since 1.5.1
 */
public class Bitbucket2Profile extends OAuth20Profile {
    
    private static final long serialVersionUID = -8943779913358140436L;

    @Override
    public String getUsername() {
        return (String) getAttribute(Bitbucket2ProfileDefinition.USERNAME);
    }
    
    @Override
    public String getDisplayName() {
        return (String) getAttribute(Bitbucket2ProfileDefinition.DISPLAY_NAME);
    }
    
    public String getNickname() {
        return (String) getAttribute(Bitbucket2ProfileDefinition.NICKNAME);
    }
    
    public String getType() {
        return (String) getAttribute(Bitbucket2ProfileDefinition.TYPE);
    }
    
    public String getAccountId() {
        return (String) getAttribute(Bitbucket2ProfileDefinition.ACCOUNT_ID);
    }
    
    public String getUUID() {
        return (String) getAttribute(Bitbucket2ProfileDefinition.UUID);
    }
    
}
