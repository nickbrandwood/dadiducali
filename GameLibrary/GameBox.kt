package GameLibrary

class GameBox (name: String){

    private var code: String? = null
        get() = field
        set(value) {
            field = value
        }
    private var ean13: String? = null
        get() = field
        set(value) {
            field = value
        }

    public fun getTags(): String {

    }
}