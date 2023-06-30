package services

import org.scalatestplus.play.PlaySpec

class HelloWorldSpec  extends PlaySpec {

  "HelloWorld.helloWorld" should {
    """return string "Hello, [name], to the world!"""" in {
      HelloWorld.helloWorld("Alexis") mustBe "Hello, Alexis, to the world!"
    }
  }

}
