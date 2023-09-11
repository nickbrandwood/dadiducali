package Library

enum class FINDMODIFIER
{
    ANY_TAG,
    ALL_TAGS
}

class LibraryList {

    var items = mutableSetOf<LibraryItem>()

    public fun findByTag(tags:Set<Tag>,logic:FINDMODIFIER) : Set<LibraryItem>
    {
        val retVal = when (logic){
            FINDMODIFIER.ANY_TAG ->  items.filter{org.apache.commons.collections4.CollectionUtils.containsAny(it.tags(),tags)}.toSet()
            FINDMODIFIER.ALL_TAGS -> items.filter{it.tags().containsAll(tags)}.toSet()
        }
        return retVal

    }
    public fun findByTag(tag:Tag) : Set<LibraryItem>
    {
        return items.filter{it.tags().contains(tag)}.toSet()

    }


}