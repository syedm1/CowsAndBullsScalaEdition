object Main extends App {

  val secret = GenerateSecret()

  println(secret)

  Emulator.runEmulator(secret)
}
