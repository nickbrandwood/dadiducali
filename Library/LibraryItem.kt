package Library

public abstract class LibraryItem (){
    var libraryCode:String = ""
    var qrCode:String? = null
    abstract var ean13:String
    private val image:String? = null

    abstract fun Lend() : Int
     abstract fun matchCode(code:String):Boolean


}