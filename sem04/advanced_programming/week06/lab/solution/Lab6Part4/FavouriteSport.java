package Lab6Part4;

import javax.swing.*;

public class FavouriteSport extends AlbumItem {
    private String originOfSport;
    private String mainScoreType;
    private ImageIcon image;

    public FavouriteSport(String originOfSport, String mainScoreType, ImageIcon image) {
        this.originOfSport = originOfSport;
        this.mainScoreType = mainScoreType;
        this.image = image;
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public String getFacts() {
        return "Origin: " + originOfSport + "\nMain Score Type: " + mainScoreType;
    }
}
