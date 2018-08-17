import collection.mutable.Stack
import org.scalatest._

class MainTest extends  FlatSpec {
  "is vowel" should "return true for passed Vovel" in {
    val isVowel = Main.isVovel("ay", Main.getPhones())
    assert(isVowel)
  }

  "is rhyme" should "return true for valid rhymes" in {
   val word = Word("text", List("T", "E", "X", "T"), List(false,true,false, false))
    assert(Main.isRhyming(word, word))
  }
//  "A Stack" should "pop values in last-in-first-out order" in {
//    val stack = new Stack[Int]
//    stack.push(1)
//    stack.push(2)
//    assert(stack.pop() == 2)
//    assert(stack.pop() == 3)
//  }
//
//  it should "throw NoSuchElementException if an empty stack is popped" in {
//    val emptyStack = new Stack[String]
//    assertThrows[NoSuchElementException] {
//      emptyStack.pop()
//    }
//  }


}