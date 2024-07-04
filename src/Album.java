import java.lang.*;
import java.util.*;

public class Album {
    int AlbumId;// pk
    int ArtistId;// fk
    String Title;
    String ReleaseDate;
    int Price;
    String Genre;
    int Quantity;

    public int getAlbumID() {
        return AlbumId;
    }

    public int getAlbumArtistID() {
        return ArtistId;
    }

    public String getAlbumTitle() {
        return Title;
    }

    public String getAlbumReleaseDate() {
        return ReleaseDate;
    }

    public int getAlbumPrice() {
        return Price;
    }

    public String getAlbumGenre() {
        return Genre;
    }

    public void setAlbumID(int id) {
        AlbumId = id;
    }

    public void setAlbumArtistID(int id) {
        ArtistId = id;
    }

    public void setAlbumTitle(String title) {
        Title = title;
    }

    public void setReleaseDate(String date) {
        ReleaseDate = date;
    }

    public void setAlbumPrice(int price) {
        Price = price;
    }

    public void setAlbumGenre(String genre) {
        Genre = genre;
    }

    public int getAlbumQuantity() {
        return Quantity;
    }

    public void setAlbumQuantity(int quantity) {
        Quantity = quantity;
    }

}