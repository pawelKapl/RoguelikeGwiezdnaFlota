package data.gui;

import data.gameEngine.Game;
import data.moveables.Player;
import data.other.Preferences;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameBoard extends JPanel implements Updatable {

    private Game game;
    private Player player;
    private char[][] location;

    public GameBoard(Game game) {
        this.game = game;
        this.player = this.game.getPlayer();
        this.location = this.game.getTerrain().getMap();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Preferences.windowWidth, Preferences.windowHeight);
        printFrames(g);
        printLocation(g);
        printPlayerStatus(g);
    }

    private void printPlayerStatus(Graphics g) {
        String profession = player.getClass().getSimpleName();

        Font font = new Font("legend", Font.BOLD, 15);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Location:  " + game.getTerrain().getName(), 35, 50);

        g.drawString("Player: " + player.getName() + "    Class: " + profession, 35, Preferences.windowHeight*2/3 + 50);
        g.setColor(Color.RED);
        g.drawString("HP: " + player.getHP(), 180 + player.getName().length()*7 + profession.length()*7,
                Preferences.windowHeight*2/3 + 50);
    }

    private void printLocation(Graphics g) {
        int dx = 35;
        int dy = 100;

        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < location[0].length; j++) {
                switch (location[i][j]) {
                    case '#':
                        g.setColor(Color.CYAN);
                        g.drawString(Character.toString(location[i][j]), dx, dy);
                        break;
                    case '.':
                        g.setColor(Color.WHITE);
                        g.drawString(Character.toString(location[i][j]), dx, dy);
                        break;
                    case 'd':
                        g.setColor(Color.PINK);
                        g.drawString(Character.toString(location[i][j]), dx, dy);
                        break;
                    case 'o':
                        g.setColor(Color.YELLOW);
                        g.drawString(Character.toString(location[i][j]), dx, dy);
                        break;
                    case 'u':
                        g.setColor(Color.BLUE);
                        g.drawString(Character.toString(location[i][j]), dx, dy);
                        break;
                    case 'f':
                        g.setColor(Color.GREEN);
                        g.drawString(Character.toString(location[i][j]), dx, dy);
                        break;
                }
                dx += 12;
            }
            dy += 20;
            dx = 35;
        }
        g.setColor(Color.BLUE);
        g.drawString("@", (player.getCoords().getX()*12)+30, (player.getCoords().getY()*20)+100);
    }

    private void printFrames(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(10,10, Preferences.windowWidth*4/5, Preferences.windowHeight*2/3);
        g.drawRect(Preferences.windowWidth*4/5 + 20, 10, Preferences.windowWidth/5 - 50, Preferences.windowHeight*2/3);
        g.drawRect(10, Preferences.windowHeight*2/3 + 20, Preferences.windowWidth - 40, Preferences.windowHeight/3 - 120);
        g.setColor(Color.RED);
        g.drawString("DarkOnion", Preferences.windowWidth/2 - 30, Preferences.windowHeight - 70);
    }

    @Override
    public void update() {
        super.repaint();
    }
}