import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    println("Hey!")


    val readmeText : Iterator[String] = Source.fromResource("cmudict.0.7a.phones").getLines
    for (line <- readmeText) {
      val strings = line.split("\t")
//      println(strings)
      val b = a(strings(0), strings(1), null, null)
      println(b.ip)
    }


  }
}
