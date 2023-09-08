package Library

fun main(args: Array<String>) {
    val dadiDucali=Association("Dadi Ducali")
    var boardGame=BoardGame()

    boardGame.name[Language.IT]="21 Gioghi Minuti"
    boardGame.minPlayers=1
    boardGame.maxPlayers=12
    boardGame.duration=30
    boardGame.bggId=356999

    var gameBox=GameBox(boardGame)
    gameBox.libraryCode="DD1234"
    gameBox.ean13="1234567890123"
    gameBox.qrCode="https://www.dadiducali.it/game/DD1234"
    dadiDucali.library.add(gameBox)

    val myGame : LibraryItem? = dadiDucali.library.findByBarcode("1234567890123")
    if (myGame != null) {
        println("found item ${myGame.libraryCode}")
        println("ean13 is ${myGame.ean13}")
        if(myGame is GameBox)
        {
            println("This is a gamebox.")
            println("the BGG url is ${myGame.boardGame.bggId}")

        }
    } else {
        println("No item found")
    }

    println("--------------------------------")

    var bggXML : BoardGameGeekXML = BoardGameGeekXML.fromId("bggID1")
    println("this is the data:")
    println(bggXML.boardGameGeekId)
    println(bggXML.data1)
    println(bggXML.data2)
    var bggXML2 : BoardGameGeekXML = BoardGameGeekXML()
    bggXML2.boardGameGeekId = "bggID2"

}
