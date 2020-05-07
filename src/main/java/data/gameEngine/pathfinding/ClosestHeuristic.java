package data.gameEngine.pathfinding;

import data.movables.Movable;

public class ClosestHeuristic implements AStarHeuristic {

    @Override
    public float getCost(TileBasedMap map, Movable movable, int x, int y, int tx, int ty) {

        float dx = tx - x;
        float dy = ty - y;

        float result = (float) (Math.sqrt((dx*dx)+(dy*dy)));

        return result;
    }
}
