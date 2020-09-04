package pl.jaz.jazapp.requests;

import pl.jaz.jazapp.UserContext;
import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.UserEntity;
import pl.jaz.jazapp.services.user.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionRequest {
    @Inject
    UserSearchService userSearchService;
    @Inject
    UserContext userContext;

    private int id;
    private String title;
    private String description;
    private int price;
    private String image1;
    private String image2;
    private String image3;
    private String param1;
    private String param2;
    private String param3;
    private CategoryEntity category_id;
    private UserEntity owner_id;
    private int version;

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public CategoryEntity getCategory_id() {
        return category_id;
    }

    public void setCategory_id(CategoryEntity category_id) {
        this.category_id = category_id;
    }

    public UserEntity getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(UserEntity owner_id) {
        this.owner_id = owner_id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
