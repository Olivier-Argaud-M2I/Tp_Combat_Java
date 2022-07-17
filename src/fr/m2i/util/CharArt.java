package fr.m2i.util;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CharArt {


    public CharArt(String text){
        text = text.replace(""," ");
        System.out.println("");
//        drawString(text,"°",new Settings(Font.getFont("Serif"),800,600));
//        drawString(text,"°",new Settings(new Font("TimesRoman", Font.BOLD, 12),800,600));
//        drawString(text,"°",new Settings(new Font("Serif", Font.PLAIN, 12),200,18));
        drawString(text,"°",new Settings(new Font("Arial", Font.BOLD, 12),200,18));

        System.out.println("");
    }




    public void drawString(String text, String artChar, Settings settings) {
        BufferedImage image = getImageIntegerMode(settings.width, settings.height);

        Graphics2D graphics2D = getGraphics2D(image.getGraphics(), settings);
        graphics2D.drawString(text, 0, ((int) (settings.height * 0.67)));


        FrontColor[] listeColors = FrontColor.values();

        for (int y = 0; y < settings.height; y++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int x = 0; x < settings.width; x++) {
                stringBuilder.append(image.getRGB(x, y) == -16777216 ? BackColor.ANSI_BLACK_BACKGROUND.getValue()+" " : artChar);
            }

            if (stringBuilder.toString()
                    .trim()
                    .isEmpty()) {
                continue;
            }

            int i = y%listeColors.length;
            System.out.println(listeColors[i].getValue()+stringBuilder);
        }

    }

    private BufferedImage getImageIntegerMode(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    private Graphics2D getGraphics2D(Graphics graphics, Settings settings) {
        graphics.setFont(settings.font);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        return graphics2D;
    }

    public class Settings {
        public Font font;
        public int width;
        public int height;

        public Settings(Font font, int width, int height) {
            this.font = font;
            this.width = width;
            this.height = height;
        }
    }


}
