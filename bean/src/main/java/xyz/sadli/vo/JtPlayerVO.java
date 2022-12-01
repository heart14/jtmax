package xyz.sadli.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/1 23:47.
 * Editored:
 */
public class JtPlayerVO implements Serializable {

    private static final long serialVersionUID = -1443806490276118931L;

    private String uid;

    private String jtmaxNumber;

    private String phoneNumber;

    private String nickname;

    private String avatar;

    private String gender;

    private String sportId;

    private String levelId;

    private Date playTime;

    private Date joinTime;

    private Date regTime;

    private String titleId;

    private String chatGroup;

    private String introduction;

    private Integer status;

    private String[] roles;

    private String[] perms;

    public JtPlayerVO() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getJtmaxNumber() {
        return jtmaxNumber;
    }

    public void setJtmaxNumber(String jtmaxNumber) {
        this.jtmaxNumber = jtmaxNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSportId() {
        return sportId;
    }

    public void setSportId(String sportId) {
        this.sportId = sportId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(String chatGroup) {
        this.chatGroup = chatGroup;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String[] getPerms() {
        return perms;
    }

    public void setPerms(String[] perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "JtPlayerVO{" +
                "uid='" + uid + '\'' +
                ", jtmaxNumber='" + jtmaxNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gender='" + gender + '\'' +
                ", sportId='" + sportId + '\'' +
                ", levelId='" + levelId + '\'' +
                ", playTime=" + playTime +
                ", joinTime=" + joinTime +
                ", regTime=" + regTime +
                ", titleId='" + titleId + '\'' +
                ", chatGroup='" + chatGroup + '\'' +
                ", introduction='" + introduction + '\'' +
                ", status=" + status +
                ", roles=" + Arrays.toString(roles) +
                ", perms=" + Arrays.toString(perms) +
                '}';
    }
}
