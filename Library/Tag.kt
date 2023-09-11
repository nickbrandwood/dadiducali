package Library

enum class TAGTYPE {
    IDENT,
    PLAYERS,
    GENRE,
    DURATION
}

class Tag private constructor(val tagType: TAGTYPE, val tagName: String, val tagValue: String) {

    companion object
    {
        val catalog : MutableSet<Tag> = mutableSetOf<Tag>()

        fun findTags (type:TAGTYPE?,name:String?,value:String?) :Set<Tag>
        {
            return catalog.filter{
                (type==null || it.tagType==type) && (name.isNullOrEmpty() || it.tagName.contains(name)) && (value.isNullOrEmpty() || it.tagValue.contains(value))
            }.toSet()
        }

        fun getTag (type:TAGTYPE, name:String, value:String) : Tag
        {

            //check catalog to see if tag exists already
            val findTag: Tag? = catalog.find{it.tagName==name && it.tagType==type && it.tagValue==value}
            if(findTag==null)
            {
                // not there, create it
                val tag:Tag = Tag(type,name,value)
                catalog.add(tag)
                println("Tag ${catalog.count()} created ${tag}")
                return tag
            }
            //return existing tag
            return findTag
        }

        fun generate(item:LibraryItem) : Set<Tag>
        {
            val lc:Tag=Tag.getTag(TAGTYPE.IDENT,"barcode",item.barcode)
            val qr:Tag=Tag.getTag(TAGTYPE.IDENT,"qrcode",item.qrCode)
            val ean13:Tag=Tag.getTag(TAGTYPE.IDENT,"ean13",item.qrCode)
            var tags: Set<Tag> = setOf(lc,qr,ean13)

            if(item is GameBox)
            {
                val gameBox:GameBox = item
                return tags + generate(gameBox.boardGame)
            }
            return tags
        }

        fun generate(item:BoardGame) : Set<Tag>
        {
            val bggId:Tag=Tag.getTag(TAGTYPE.IDENT,"bggId",item.bggId.toString())
            val title:Tag=Tag.getTag(TAGTYPE.IDENT,"title",item.title)
            val duration:Tag=Tag.getTag(TAGTYPE.DURATION,"Duration",item.duration.toString())
            var tags:Set<Tag> = setOf(bggId,title,duration)

            if(item.minPlayers+item.maxPlayers>0)
            {
                val numbers: IntRange = item.minPlayers.rangeTo(item.maxPlayers)
                val players: Set<Tag> = numbers.map{
                    Tag.getTag(TAGTYPE.PLAYERS,"players","${it} players")
                }.toSet()
                tags = tags + players
            }
            return tags
        }
    }

    override fun toString() : String
    {
        return "type:$tagType name:$tagName value:$tagValue"
    }
}