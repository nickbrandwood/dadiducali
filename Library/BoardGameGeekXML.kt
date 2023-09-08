package Library

class BoardGameGeekXML() {

    companion object {

        fun fromId(id:String) : BoardGameGeekXML {
            val xml:String = fetchXML(id)
            val bggXML:BoardGameGeekXML = fromXML(xml)
            bggXML.boardGameGeekId=id
            return bggXML
        }

        fun fromXML(xml:String) : BoardGameGeekXML {
            val bggXML:BoardGameGeekXML = processXML(xml)
            bggXML.boardGameGeekId="not set"
            return bggXML
        }

        private fun fetchXML(xml:String) : String
        {
            val retval:String = "Lets pretend we got some XML here."
            return retval
        }

        private fun processXML(xml:String) : BoardGameGeekXML
        {
            // To Do
            val bggXML=BoardGameGeekXML()
            bggXML.data1=xml
            bggXML.data2="don't tell anyone!"
            return bggXML
        }
    }

    var boardGameGeekId:String = ""
    var data1 : String =""
    var data2 : String =""





}
