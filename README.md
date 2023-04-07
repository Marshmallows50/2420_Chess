TODO:

Classes:
    Gameboard -> Algs4 graph
        - Use BFS of get the shortest path of the user selected destination. Feed this information to pieces to decipher if the sequence of vertices are a valid movement.

    Graveyard -> Interactivity between pieces, ie. removing a piece from the board

    Player -> In Player class we define input / controls. White moves first, black moves second.

    Pieces -> define valid movement patterns, particular rules, etc.
        - Pawn
            - Moving 2 spaces if first move.
            - Promotion to another piece.
            - En passant? -> Literally the last thing if we have time.
        - Rook
            - Castling
        - Knight
        - Bishop
        - Queen
        - King
            - Castling
