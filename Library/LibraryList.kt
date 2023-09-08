package Library

class LibraryList {

    private var items = mutableSetOf<LibraryItem>()


    public fun add(item:LibraryItem)
    {
        items.add(item)
    }

    public fun findByBarcode(code:String) : LibraryItem?
    {
        var retval: LibraryItem? = null
        for(item in items)
        {
            if(item.matchCode(code))
            {
                retval = item
                break
            }

        }
        return retval
    }

}