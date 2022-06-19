package com.stanrunge.proj2;

import javafx.scene.image.ImageView;

public class ProfilePicture {
    private ImageView profilePic;

    public ProfilePicture(ImageView profilePic) {
        this.profilePic = profilePic;
    }

    public ImageView getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(ImageView profilePic) {
        this.profilePic = profilePic;
    }
}
