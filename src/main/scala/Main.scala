import scala.collection.mutable.ListBuffer
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {
    println("Hey!")

    val phones = getPhones()
    val words = getWords(phones)

    print(isVovel("ay", phones) + "\n")
    print(phones.mkString("\n "))

    words.slice(30, 50).foreach(example => print("\nsymbols " + example.text + example.symbols.mkString(" "), example.vovels.mkString(" ")))
    //    val example = words(20)
    //    print("\nsymbols " + example.text + example.symbols.mkString(" "), example.vovels.mkString(" "))
  }

  def isVovel(phone: String, phones: Map[String, Boolean]): Boolean = {
    phones.contains(phone.toUpperCase())
  }

  def getWords(phones: Map[String, Boolean]): ListBuffer[Word] = {
    var wordsLines = ListBuffer[Word]()
    val wordsText: Iterator[String] = Source.fromResource("cmudict.0.7a").getLines.drop(140).take(100)
    for (line <- wordsText) {
      val strings = line.split("\\s+")
      val letters = strings.drop(1).toList
      wordsLines :+= Word(strings(0), letters, wordToVovels(letters, phones))
    }
    wordsLines
  }


  def wordToVovels(symbols: List[String], phones: Map[String, Boolean]): List[Boolean] = {
    symbols.map(s => isVovel(s, phones))
  }

  def isRhyming(word1: Word, word2: Word): Boolean = {
    val index1 = word1.vovels.reverse.indexOf(true)
    val index2 = word2.vovels.reverse.indexOf(true)

    val leftSymbols1 = word1.symbols.reverse.take(index1)
    val leftSymbols2 = word2.symbols.reverse.take(index2)
    index1 == index2 && leftSymbols1.zip(leftSymbols2).count(x => x._1 == x._2) == index1
  }

  def getPhones(): Map[String, Boolean] = {
    var phones = Map[String, Boolean]()
    val phonesText: Iterator[String] = Source.fromResource("cmudict.0.7a.phones").getLines
    for (line <- phonesText) {
      val strings = line.split("\t")
      phones += (strings(0) -> strings(1).equals("vowel"))
    }
    phones
  }
}