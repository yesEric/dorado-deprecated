package cn.dorado.cms.domain.model.common;

/**
 * Created by Eric on 14-4-29.
 * 此类临时位于此处，之后需要重构到身份验证上下文
 */
public class Author implements User{

    String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
