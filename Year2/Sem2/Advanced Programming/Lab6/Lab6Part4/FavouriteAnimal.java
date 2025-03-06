package Lab6Part4;

import javax.swing.*;

public class FavouriteAnimal extends AlbumItem {
    private String originOfAnimal;
    private String yearsOfExistence;
    private ImageIcon image;

    public FavouriteAnimal(String originOfAnimal, String yearsOfExistence, ImageIcon image) {
        this.originOfAnimal = originOfAnimal;
        this.yearsOfExistence = yearsOfExistence;
        this.image = image;
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public String getFacts() {
        return "Origin: " + originOfAnimal + "\nYears of Existence: " + yearsOfExistence;
    }
}
