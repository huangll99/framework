package com.jagregory.shiro.freemarker;

import org.apache.shiro.subject.Subject;

/**
 * <p>Equivalent to {@link org.apache.shiro.web.tags.HasRoleTag}</p>
 */
public class HasRoleTag extends RoleTag {
    protected boolean showTagBody(String roleName) {
        Subject subject = getSubject();
        return getSubject() != null && getSubject().hasRole(roleName);
    }
}
