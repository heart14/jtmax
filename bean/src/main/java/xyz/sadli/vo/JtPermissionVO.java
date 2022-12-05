package xyz.sadli.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/4 21:10.
 * Editored:
 */
public class JtPermissionVO implements Serializable {

    private static final long serialVersionUID = -4660310296402688830L;

    private String path;

    private String component;

    private String redirect;

    private boolean alwaysShow;

    private String name;

    private Meta meta;

    private List<JtPermissionVO> children;

    private static class Meta {
        private String title;

        private String icon;

        private String[] roles;

        public Meta() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "title='" + title + '\'' +
                    ", icon='" + icon + '\'' +
                    ", roles=" + Arrays.toString(roles) +
                    '}';
        }
    }

    public JtPermissionVO() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public boolean isAlwaysShow() {
        return alwaysShow;
    }

    public void setAlwaysShow(boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<JtPermissionVO> getChildren() {
        return children;
    }

    public void setChildren(List<JtPermissionVO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "JtPermissionVO{" +
                "path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", redirect='" + redirect + '\'' +
                ", alwaysShow=" + alwaysShow +
                ", name='" + name + '\'' +
                ", meta=" + meta +
                ", children=" + children +
                '}';
    }
}
