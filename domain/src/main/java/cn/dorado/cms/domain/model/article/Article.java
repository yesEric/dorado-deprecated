package cn.dorado.cms.domain.model.article;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import cn.dorado.cms.domain.AbstractEntity;
import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.common.Author;
import cn.dorado.cms.domain.model.page.Page;

/**
 * Created by Eric on 14-4-29.
 */
@Entity
public class Article extends AbstractEntity{
    @Id
    @GeneratedValue(generator = "articleIdGenerator")     
    @GenericGenerator(name = "articleIdGenerator", strategy = "assigned")  
    DomainId articleId;
    @Column
    String title;
    @Column
    String content;
    @Column
    String createDate;

    @Embedded
    Author author;
    @Column
    int publishState;
    @Column
    int approvalState;
    @Column
    int privateState;
    @Column
    int commentScope;
//    @OneToMany(mappedBy = "page",targetEntity = Page.class,cascade = {CascadeType.ALL})
//    @Fetch(FetchMode.JOIN)
//    Set<Page> pages =new HashSet<Page>();
//    @OneToMany(mappedBy = "tag",targetEntity = Tag.class,cascade = {CascadeType.ALL})
//    @Fetch(FetchMode.JOIN)
//    Set<Tag> tags=new HashSet<Tag>();
//    @OneToMany(mappedBy = "comment",targetEntity = Comment.class,cascade = {CascadeType.ALL})
//    @Fetch(FetchMode.JOIN)
//    Set<Comment> comments=new HashSet<Comment>();

    
    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
          
                ", publishState=" + publishState +
                ", approvalState=" + approvalState +
                ", privateState=" + privateState +
                ", commentScope=" + commentScope +
//                ", pages=" + pages +
//                ", tags=" + tags +
//                ", comments=" + comments +
                '}';
    }

    public Author getAuthor() {
		return author;
	}

	protected void setAuthor(Author author) {
		this.author = author;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (!articleId.equals(article.articleId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return articleId.hashCode();
    }

    public DomainId getArticleId() {
        return articleId;
    }

    protected void setArticleId(DomainId articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    protected void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    protected void setCreateDate(String createDate) {
        this.createDate = createDate;
    }



    public int getPublishState() {
        return publishState;
    }

    protected void setPublishState(int publishState) {
        this.publishState = publishState;
    }

    public int getApprovalState() {
        return approvalState;
    }

    protected void setApprovalState(int approvalState) {
        this.approvalState = approvalState;
    }

    public int getPrivateState() {
        return privateState;
    }

    protected void setPrivateState(int privateState) {
        this.privateState = privateState;
    }

    public int getCommentScope() {
        return commentScope;
    }

    protected void setCommentScope(int commentScope) {
        this.commentScope = commentScope;
    }

//    public Set<Page> getPages() {
//        return pages;
//    }
//
//    protected void setPages(Set<Page> pages) {
//        this.pages = pages;
//    }
//
//    public Set<Tag> getTags() {
//        return tags;
//    }
//
//    protected void setTags(Set<Tag> tags) {
//        this.tags = tags;
//    }
//
//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    protected void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }

    /**
     * 发布文章的方法
     */
    public void publish(){
       //todo:
    }

    /**
     * 将文章保存为草稿
     */
    public void saveAsDraft(){

    }

    /**
     * 撤销发布的文章
     */
    public void withDraw(){

    }

    /**
     * 删除文章的方法
     */
    public void destory(){

    }

    /**
     * 删除到回收站
     */
    public void moveToRecycle(){

    }
    /**
     * 关闭评论
     */
    public void disableComment(){

    }

    /**
     * 运行匿名评论
     */
    public void allowCommentByAnonymous(){

    }

    /**
     * 只运行注册用户评论
     */
    public void allowCommentByRegister(){

    }

    /**
     * 添加所属栏目
     * @param page 所属栏目
     */
    public void addColumn(Page page){

    }

    /**
     * 添加标签
     * @param tag 包含的标签
     */
    public void addTag(Tag tag){

    }


}
