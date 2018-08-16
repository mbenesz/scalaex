import scala.collection.mutable.ListBuffer
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {
    println("Hey!")

    val phones = getPhones()
    val words = getWords()

    print(isVovel("ay", phones) + "\n")
    print(phones.mkString("\n "))

    print("symbols " + words.head + words.head.symbols.mkString(" "))
  }

  def isVovel(phone: String, phones: Map[String, Boolean]): Boolean = {
    phones.contains(phone.toUpperCase())
  }

  def getWords():ListBuffer[Word] = {
    var wordsLines = ListBuffer[Word]()
    val wordsText: Iterator[String] = Source.fromResource("cmudict.0.7a").getLines.drop(118).take(100)
    for (line <- wordsText) {
      val strings = line.split("\t")
      val a = Word(strings(0), strings.drop(1))
      wordsLines :+= a
    }
    wordsLines
  }


  def wordToVovels(word: Word) : List[Boolean] = ???

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
