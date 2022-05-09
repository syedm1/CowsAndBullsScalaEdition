package models

case class BullsAndCowsDisplayData(animalType: String, total: Int, values: List[Int]) {
  def display: String = {
    s"${animalType}: ${total} Values: ${values.mkString(",")}"
  }
}
