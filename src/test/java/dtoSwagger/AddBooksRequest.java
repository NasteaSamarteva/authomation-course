package dtoSwagger;

import java.util.List;

public class AddBooksRequest {
    private String userID;
    private List<Isbns> collectionOfIsbns;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Isbns> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<Isbns> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
