package ru.dolgosheev;

import ru.dolgosheev.board.Board;
import ru.dolgosheev.board.BoardConsoleRenderer;
import ru.dolgosheev.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardFactory().fromFEN(
                //"8/3p2P1/5n2/2N5/3B4/6P1/8/8 w - - 0 1"
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
        );
//        BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();
        Game game = new Game(board);
        game.gameLoop();

    }
}