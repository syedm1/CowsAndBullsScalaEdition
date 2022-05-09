
import scala.util.Random

object GenerateSecret {
  def apply(size: Int = 4): Secret = {
    Secret(value = Seq.fill(size)(Random.between(1, 10)).toList)
  }
}
