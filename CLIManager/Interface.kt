package CLIManager

import Library.Association
import Library.BoardGame
import Library.BoardGameItem
import Library.GameBox
import Library.LibraryItem
import Library.LocalFileStore
import Library.Tag

fun main(args: Array<String>) {

    //create association
    val dadiDucali= Association("Dadi Ducali")

    //process csv file
    val libraryCSV : List<BoardGameItem> = LocalFileStore().readLibraryCSV()

    //generate in memory objects
    for(boardGameItem : BoardGameItem in libraryCSV)
    {
        //board game (definition)
        val boardGame : BoardGame = BoardGame.loadGame(boardGameItem)

        //game box (instance)
        val gameBox : GameBox = GameBox(boardGame)

        //set individual barcode
        gameBox.barcode=boardGameItem.barcode

        //add it to the library
        dadiDucali.library.items.add(gameBox)
        //println("Game ${gameBox.boardGame.title} (Game ID ${gameBox.boardGame.gameId}) added to library as barcode ${gameBox.barcode}" )
    }



    /*
    println("${dadiDucali.library.items.count()} games present in library.")
    println("-------------------------")

    //search for games by barcode tag:
    val tag1:Tag =Tag.getTag(TAGTYPE.IDENT,"barcode","DD100")
    displayGames(dadiDucali.library.findByTag(tag1))
    println("-----------------------------------------------")

    //search for games by bggID tag:
    val tag2:Tag = Tag.getTag(TAGTYPE.IDENT,"bggId","346101")
    displayGames(dadiDucali.library.findByTag(tag2))
    println("-----------------------------------------------")


    //search for multiple games by tag:

    println("look for anything including \"Zombie\" in the title")
    val zombieTags:Set<Tag> =Tag.findTags(TAGTYPE.IDENT,"title","Zombie")
    println("Tags found ${zombieTags.count()}")
    val tags:Set<Tag> = zombieTags
    displayGames(dadiDucali.library.findByTag(tags,FINDMODIFIER.ANY_TAG))

 */

}

fun displayGames(myGames:Set<LibraryItem>) : Unit {
    if( myGames.count()==0)
        println("no games found for tags.")

    else {
        for(myGame in myGames){
            if(myGame is GameBox)
            {
                println("++")
                println("item ${myGame.barcode} is a gamebox.")
                println("the game is ${myGame.boardGame.title}")
                println("tags:${Tag.generate(myGame)}")
            }
        }
    }
}