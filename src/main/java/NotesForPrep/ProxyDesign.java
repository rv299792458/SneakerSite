package NotesForPrep;

import java.util.Objects;

interface Image {
    void display();
}

class RealImage implements  Image{
    String imageName;
    void setImageName(String imageName){
        this.imageName=imageName;
    }
    @Override
    public void display() {
        System.out.println(imageName);
    }
}

class ProxyImage implements Image{
    private RealImage realImage;
    String imageName;

    public ProxyImage(String imageName)
    {
        this.imageName=imageName;
    }
    @Override
    public void display() {
        if(Objects.isNull(realImage))
        {
            realImage = new RealImage();
            realImage.setImageName(imageName);
            realImage.display();
        }
        else
            realImage.display();
    }
}
public class ProxyDesign {
    public static void main(String[] args) {
        Image image = new ProxyImage("Real Image 1");
        image.display();
        image.display();
    }


}
