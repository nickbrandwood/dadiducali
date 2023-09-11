package Library

public abstract class LibraryItem (){

    var barcode:String=""
    var qrCode:String=""
    open var ean13:String=""
    private val image:String=""

    abstract fun lend() : Int
     abstract fun matchCode(code:String):Boolean

    abstract fun tags():Set<Tag>
}