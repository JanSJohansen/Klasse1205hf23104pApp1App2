package dk.tec.customizedlist;

public class Elev
{
    String name;
    String description;
    int pictureId;

    public Elev() { }

    public Elev(String name, String description, int pictureId) {
        this.name = name;
        this.description = description;
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
