<h1>Structure:</h1>
<h3>Gameboard</h3><p>Use BFS of get the shortest path of the user selected destination. Feed this information to pieces to decipher if the sequence of vertices are a valid movement.</p>
<h3>Graveyard</h3><p>Interactivity between pieces, ie. removing a piece from the board.</p>
<h3>Player</h3><p>In Player class we define input / controls. White moves first, black moves second.</p>
<h3>Pieces</h3><p>Define valid movement patterns, particular rules, etc.</p>
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

<a href="https://lucid.app/lucidchart/8d007253-9e4e-4fce-937f-f7dc9522de22/edit?viewport_loc=-390%2C13%2C3114%2C1364%2C0_0&invitationId=inv_7478996f-21a6-46a9-bbcd-94528af1011d">UML DIAGRAM</a>
