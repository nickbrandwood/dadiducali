package Library

class BoardGame {

    var gameId:Int? = null
    var name = mutableMapOf<Library.Language,String>()
    var minPlayers:Int? = null
    var maxPlayers:Int? = null
    var genre:List<String>? = null
    var duration:Int? = null
    var minAge:Int? = null
    var complexity:String? = null
    var videoLinks = mutableMapOf<Library.Language,String>()
    var manualPDF = mutableMapOf<Library.Language,String>()
    var qrCode:String? = null
    var bggId:Int? = null
    var languageDependence:Boolean? = null
    var loans:Int=0
    var ean13:String=""


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