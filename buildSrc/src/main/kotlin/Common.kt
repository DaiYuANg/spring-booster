import java.util.*


fun year(date: Date): Int {
  val calendar = Calendar.getInstance()
  calendar.setTime(date)
  return calendar.get(Calendar.YEAR)
}