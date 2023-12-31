package Library

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.io.BufferedReader
import java.nio.file.Files
import java.nio.file.Paths


class LocalFileStore {

    fun readLibraryCSV(): List<BoardGameItem>
    {
        val bufferedReader:BufferedReader = Files.newBufferedReader(Paths.get("CLIManager/library.csv"))
        val csvFormat: CSVFormat = CSVFormat.RFC4180.builder().setTrim(true).setHeader().setSkipHeaderRecord(true).build()
        val csvParser = CSVParser(bufferedReader, csvFormat)
        val csvRecords:List<CSVRecord> = csvParser.records
        val transform: (CSVRecord) -> BoardGameItem = {
            BoardGameItem(
                it.get("Titolo"),
                it.get("Barcode"),
                it.get("Minuti"),
                it.get("Lingue"),
                it.get("Note"),
                it.get("Giocatori"),
                if(it.get("BGG_ID")=="") 0 else it.get("BGG_ID").toInt(),
                it.get("BGG_Image"),
                it.get("BGG_Thumb")
            )
        }
        var library : List<BoardGameItem> = csvRecords.map(transform)
        return library
    }
}

