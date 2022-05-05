package entity;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class Review {
    private int productId;
    private String email;
    private String name;
    private String review;
    private String timestamp;
    private int vote;

    public Review(int productId, String email, String name, String review, String timestamp, int vote) {
        this.productId = productId;
        this.email = email;
        this.name = name;
        this.review = review;
        this.timestamp = timestamp;
        this.vote = vote;
    }

    public Review() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    
}
