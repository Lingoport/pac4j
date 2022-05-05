package org.pac4j.oauth.profile.gitlab;

import org.pac4j.oauth.profile.OAuth20Profile;
//import org.pac4j.oauth.profile.gitlab.GitLabProfileDefinition;


/**
 * <p>This class is the user profile for GitLab with appropriate getters.</p>
 * <p>It is returned by the {@link org.pac4j.oauth.client.GitLabClient}.</p>
 *
 * @author Mary Heilner
 */
public class GitLabProfile extends OAuth20Profile {
    
    private static final long serialVersionUID = -8943779913358140436L;

    @Override
    public String getUsername() {
        return (String) getAttribute(GitLabProfileDefinition.USERNAME);
    }
    
   
    public String getName() {
        return (String) getAttribute(GitLabProfileDefinition.NAME);
    }
    
}
