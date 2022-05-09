import models.UserInput


object Emulator {
  private val MAX_SIZE = 4

  def runEmulator(secret: Secret): Unit = {

    var continue = true
    var userGuessList = List[Int]()
    while (continue) {

      println("take a guess:")


      while (userGuessList.size < MAX_SIZE) {
        val input = scala.io.StdIn.readInt()
        userGuessList = userGuessList :+ input
        if (input == -1) {
          continue = false;
          println("Bye!");
          sys.exit
        }
        if (input == 0) {
          println(userGuessList)
        }
      }

      val outcome = InputToCowsAndBullsTransformer(secret, UserInput(input = userGuessList))

      println(InputToCowsAndBullsTransformer.getDataByAnimalType(outcome, "Cows").display)
      println(InputToCowsAndBullsTransformer.getDataByAnimalType(outcome, "Bulls").display)

      println("Try again ?")
      val input = scala.io.StdIn.readInt()


      if (input == 0) {
        sys.exit
      }
      else {
        userGuessList = List.empty
      }
    }

  }
}
