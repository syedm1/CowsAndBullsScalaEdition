import models.{BullsAndCows, BullsAndCowsDisplayData, UserInput}

object InputToCowsAndBullsTransformer {

  def apply(secret: Secret, data: UserInput): BullsAndCows = {
    val bullsAndCowsData = data.input.flatMap(num => getCowOrBull(num, data.input.indexOf(num), secret))
    BullsAndCows(bullsAndCowsData)
  }

  def getCowOrBull(num: Int, indexLocation: Int, secret: Secret): Option[(String, Int)] = {
    if (!secret.value.contains(num)) {
      None
    }
    else {
      if (secret.value.contains(num) && (secret.value.indexOf(num) == indexLocation)) {
        Some("Bulls", num)
      }
      else {
        Some("Cows", num)
      }
    }
  }

  def getDataByAnimalType(input: BullsAndCows, animalType: String): BullsAndCowsDisplayData = {
    val onlyAnimalsOfGivenType = input.value.filter(x => x._1 == animalType)
    val totalAnimalsOfGivenType = onlyAnimalsOfGivenType.size
    val animalsOfGivenTypeLocations = onlyAnimalsOfGivenType.map(_._2)
    BullsAndCowsDisplayData(animalType, totalAnimalsOfGivenType, animalsOfGivenTypeLocations)
  }
}
