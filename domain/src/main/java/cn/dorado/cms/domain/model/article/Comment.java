package cn.dorado.cms.domain.model.article;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.common.Commentator;

/**
 * Created by Eric on 14-4-29.
 */
public class Comment {
    String commentId;
    String title;
    String comment;
    Commentator commentator;
    DomainId articleId;
    int approvalState;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Commentator getCommentator() {
        return commentator;
    }

    public void setCommentator(Commentator commentator) {
        this.commentator = commentator;
    }

    public DomainId getArticleId() {
        return articleId;
    }

    public void setArticleId(DomainId articleId) {
        this.articleId = articleId;
    }

    public int getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(int approvalState) {
        this.approvalState = approvalState;
    }
}
