package xyz.sadli.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/28 22:41.
 * Editored:
 */
public class JtPlayer implements Serializable {

    private static final long serialVersionUID = -127965949861807867L;

    private String uid;

    private String jtmaxNumber;

    private String phoneNumber;

    private String password;

    private String salt;

    private String nickname;

    private String avatar;

    private String realName;

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

    private Date createTime;

    private Date updateTime;

    public JtPlayer() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getJtmaxNumber() {
        return jtmaxNumber;
    }

    public void setJtmaxNumber(String jtmaxNumber) {
        this.jtmaxNumber = jtmaxNumber == null ? null : jtmaxNumber.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getSportId() {
        return sportId;
    }

    public void setSportId(String sportId) {
        this.sportId = sportId == null ? null : sportId.trim();
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
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
        this.titleId = titleId == null ? null : titleId.trim();
    }

    public String getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(String chatGroup) {
        this.chatGroup = chatGroup == null ? null : chatGroup.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "JtPlayer{" +
                "uid='" + uid + '\'' +
                ", jtmaxNumber='" + jtmaxNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", realName='" + realName + '\'' +
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
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
