package xyz.sadli.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/4 21:10.
 * Editored:
 */
public class JtPermissionVO implements Serializable {

    private static final long serialVersionUID = -4660310296402688830L;

    private String permId;

    private String path;

//    private String component;

    private String redirect;

    private boolean alwaysShow;

    private String name;

    private boolean hidden;

    private Map<String,String> meta;

    private List<JtPermissionVO> children;

    public JtPermissionVO() {
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public List<JtPermissionVO> getChildren() {
        return children;
    }

    public void setChildren(List<JtPermissionVO> children) {
        this.children = children;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "JtPermissionVO{" +
                "permId='" + permId + '\'' +
                ", path='" + path + '\'' +
                ", redirect='" + redirect + '\'' +
                ", alwaysShow=" + alwaysShow +
                ", name='" + name + '\'' +
                ", hidden=" + hidden +
                ", meta=" + meta +
                ", children=" + children +
                '}';
    }
}
