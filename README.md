<h1>Classes:</h1>
    <h3>Gameboard</h3><br><p>Use BFS of get the shortest path of the user selected destination. Feed this information to pieces to decipher if the sequence of vertices are a valid movement.</p><br>

    <h3>Graveyard</h3><br><p>-> Interactivity between pieces, ie. removing a piece from the board</p><br>

    <h3>Player</h3><br><p>-> In Player class we define input / controls. White moves first, black moves second.</p><br>

    <h3>Pieces</h3><br><p>-> define valid movement patterns, particular rules, etc.</p>
        <ul>
            <li>Pawn
                <ul>
                    <li>Move two spaces if it's the first move.</li>
                    <li>Promotion to another piece at the end of the board.</li>
                    <li>En passant. -> Only if we have time.</li>
                </ul>
            </li>
            <li>Knight</li>
            <li>Bishop</li>
            <li>Queen</li>
            <li>King
                <ul>
                    <li>Castling with Rook</li>
                    <li>Game over if captured.</li>
                </ul>
            </li>
            <li>Rook</li>
        </ul>
