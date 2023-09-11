package Library

class BoardGame {

    companion object {
        private val catalog : MutableList<BoardGame> = mutableListOf<BoardGame>()

        private var nextId:Int = 0

        fun loadGame(boardGameItem:BoardGameItem) : BoardGame
        {
            var catalogItem = findByGameId(boardGameItem.bggId)

            catalogItem=findByBggId(boardGameItem.bggId)
            if(boardGameItem.bggId!=0 && catalogItem!=null) return catalogItem

            catalogItem= findByTitle(boardGameItem.title)
            if(boardGameItem.title!="" && catalogItem!=null) return catalogItem

            //not found, create it.
            var boardGame=BoardGame()
            boardGame.bggId=boardGameItem.bggId
            boardGame.title=boardGameItem.title
            var players = boardGameItem.players.split(",").toList()
            boardGame.minPlayers=3 //TODO Parse CSV values
            boardGame.maxPlayers=5 //TODO Parse CSV values
           /* boardGame.duration=boardGameItem.minutes.toInt() */
            boardGame.gameId= addToCatalog(boardGame)
            return boardGame

        }
        fun addToCatalog(boardGame:BoardGame) : Int
        {
            // game not found
            nextId++
            boardGame.gameId = nextId
            catalog.add(boardGame)
            return nextId
        }

        fun findByGameId(gameId:Int) : BoardGame? {
            return catalog.firstOrNull {game ->game.gameId==gameId}
        }

        fun findByBggId(bggId:Int) : BoardGame? {
            return catalog.firstOrNull {game -> game.bggId==bggId}
        }

        fun findByTitle(title:String) : BoardGame? {
            return catalog.firstOrNull {game -> game.title==title}
        }

    }

    var gameId:Int = 0
    var title:String=""
    var name = mutableMapOf<Library.Language,String>()
    var minPlayers:Int = 0
    var maxPlayers:Int = 0
    var genre:List<String>? = null
    var duration:Int? = null
    var minAge:Int? = null
    var complexity:String? = null
    var videoLinks = mutableMapOf<Library.Language,String>()
    var manualPDF = mutableMapOf<Library.Language,String>()
    var qrCode:String? = null
    var bggId:Int = 0
    var languageDependence:Boolean? = null
    var loans:Int=0
    var ean13:String=""

    private constructor()
    {

    }


    public fun GetTags() : List<String>
    {
        var tags:List<String> = listOf("")
        /* To Do */
        return tags
    }

    public fun RegisterLoan() : Int
    {
        loans++
        return loans
    }

    fun boardGameGeekLink() : String
    {
        var link:String=""
        bggId ?.let{
            link = "https://boardgamegeek.com/boardgame/${bggId}/"
        }
        return link
    }

    fun boardGameGeekXML() : String
    {
        var link:String=""
        bggId ?.let{
            link = "https://boardgamegeek.com/xmlapi2/thing?versions=1&stats=1&id=${bggId}"
        }
        return link
    }

}

data class BoardGameItem(
    var title:String,
    var barcode:String,
    var minutes:String,
    var language:String,
    val notes:String,
    var players:String,
    var bggId: Int,
    var bggImage:String,
    var bggThumb:String)
