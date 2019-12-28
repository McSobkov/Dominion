package gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Importer for images in resources
 */
public class CardImages {
    private static final int NUM_TILES = 24;
    private static final int ROWS = 6;
    private static final int TILE_SIZE = 90;
    private HashMap<String, BufferedImage> imageMap;
    //private BufferedImage image = ImageIO.read(new File("src/main/resources/CardImages.png"));

        /**
         * Creates a representation of tile images to be used as individuals
         * @throws IOException file not found
         */
        public CardImages() throws IOException {
            imageMap = new HashMap<>();
            ArrayList<Path> fileNames;
            try (Stream<Path> paths = Files.walk(Paths.get("src/main/resources"))) {
                fileNames =
                        (ArrayList<Path>) paths
                        .filter(Files::isRegularFile)
                        .collect(Collectors.toList());
            }

            for(Path p: fileNames){
                String nameOfPath = p.toString().substring(19, p.toString().indexOf(".jpg"));
                BufferedImage img = ImageIO.read(new File(p.toString()));
                imageMap.put(nameOfPath, img);
            }


        }

        /**
         *
         * @return list of tile images
         */
        public HashMap<String, BufferedImage> getImage(){
            return imageMap;
        }



}
