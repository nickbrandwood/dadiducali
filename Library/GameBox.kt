package Library

public class GameBox(_boardGame: BoardGame) : LibraryItem() {

    var boardGame:BoardGame
    override var ean13:String
        get() = boardGame.ean13
        set(value) {
            boardGame.ean13 = value
        }

    init {
        this.boardGame =_boardGame

    }
    override fun lend():Int {
        var loans:Int = boardGame.RegisterLoan()
        println("This game has been loaned $loans times.")
        return loans
    }

    override fun matchCode(code:String):Boolean
    {
        var retval :Boolean=false
        if(code == this.qrCode || code == this.ean13 || code == this.barcode)
        {
            retval=true
        }
        return retval
    }

    override fun tags():Set<Tag>
    {
        return Tag.generate(this)
    }
}