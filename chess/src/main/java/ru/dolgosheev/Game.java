package ru.dolgosheev;

public class Game {

    private final Board board;

    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void game() {
        boolean isWhiteToMove = true;

        while (true) {
            // render
            renderer.render(board);
            // input

            // make move

            // pass move
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
