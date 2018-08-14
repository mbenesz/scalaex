import scala.io.Source

object Main {

  def isVovel(phone: String, phones: Map[String,Boolean]) :Boolean = {
    phones.contains(phone.toUpperCase())
  }

  def main(args: Array[String]): Unit = {
    println("Hey!")
    var phones = Map[String, Boolean]()

    val phonesText : Iterator[String] = Source.fromResource("cmudict.0.7a.phones").getLines
    for (line <- phonesText) {
      val strings = line.split("\t")
      phones += (strings(0) -> strings(1).equals("vowel"))
    }

    print(isVovel("ay",phones) + "\n")

    print(phones.mkString("\n "))


  }
}
