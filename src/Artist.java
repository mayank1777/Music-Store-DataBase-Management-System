import java.lang.*;
import java.util.*;

public class Artist {
    int ArtistId;
    String ArtistName;
    String ArtistCountry;

    public int getArtID() {
        return ArtistId;
    }

    public String getArtName() {
        return ArtistName;
    }

    public String getArtCountry() {
        return ArtistCountry;
    }

    public void setArtistId(int id) {
        ArtistId = id;
    }

    public void setArtistName(String name) {
        ArtistName = name;
    }

    public void setArtistCountry(String country) {
        ArtistCountry = country;
    }

}