package cn.dorado.cms.domain.model.common;

/**
 * Created by Eric on 14-4-29.
 */
public class CommentScope {
    /*允许所有人评论*/
    public static final int ALL=1;
    /*只允许注册用户评论*/
    public static final int REGISTER=2;
    /*不运行评论*/
    public static final int CLOSED=3;
}
