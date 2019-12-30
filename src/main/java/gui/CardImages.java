package gui;

import core.CardName;

import javax.imageio.ImageIO;
import javax.swing.UIManager;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.Graphics2D;
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
    private HashMap<CardName, BufferedImage> imageMap;
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
                CardName nameOfPath = CardName.nameFromString(p.toString().substring(19, p.toString().indexOf(".jpg")));
                BufferedImage img = ImageIO.read(new File(p.toString()));
                imageMap.put(nameOfPath, img);
            }


        }

    /**
     * Rotates an image by 90 degrees, n times
     * @param src of picture
     * @param n number of rotations
     * @return rotated image
     */
        public static BufferedImage rotateClockwise(BufferedImage src, int n) {
            int width = src.getWidth();
            int height = src.getHeight();

            AffineTransform at = AffineTransform.getQuadrantRotateInstance(n,width / 2.0,height / 2.0);
            double x = at.getTranslateX();
            double y = at.getTranslateY();
            if(n == 1) at.translate(-60,-60);
            else if(n == 3) at.translate(60,60);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);

            BufferedImage dest = new BufferedImage(height, width, src.getType());

            op.filter(src, dest);

            return dest;
        }

        /**
         *
         * @return list of tile images
         */
        public HashMap<CardName, BufferedImage> getImage(){
            return imageMap;
        }



}
