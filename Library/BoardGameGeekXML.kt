package Library

import java.io.InputStream
import java.nio.file.Path


class BoardGameGeekXML(val bggId:String) {

    var name:Array<String> = emptyArray<String>()
    var thumbnail:String =""
    var image:String =""
    var description:String =""
    var year:Int =0
    var minplayers:Int =0
    var maxplayers:Int=0
    var suggestedPlayers:Array<Pair<Int,Int>> = emptyArray<Pair<Int,Int>>()
    var playingTime:Int=0
    var minPlayTime:Int=0
    var maxPlayTime:Int=0
    
    var xmlData:InputStream?=null
    val URL: String="https://api.geekdo.com/xmlapi2/thing?id=$bggId"


            init {

        //check local storage for datafile.
        if (false) //TODO check local store
        {
            println("loading BGG data from file")
        } else {
            println("loading BGG data from web")
            //TODO download from web.

        }

        println("cacheing to local store")
        //TODO cache XML to local store

        println("ParsingXML")
        //TODO download from web.
        // BGGItem=parse(xmlData)


    }

    private fun cacheToLocalStore(filePath:String) {
        try {
            val path = Path.of(filePath)

            // Write the XML content to the file using NIO
            // Files.write(path, xmlContent.toByteArray(), StandardOpenOption.CREATE)

            println("XML content successfully written to $filePath")
        } catch (e: Exception) {
            println("Error writing XML content to file: ${e.message}")
        }
    }


}