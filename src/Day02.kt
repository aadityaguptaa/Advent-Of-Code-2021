fun main() {
    fun part1(input: List<String>): Int {
        var x = 0;
        var d = 0;
        for(i in 0..input.size-1){
            var li = input[i].split(" ")
            when(li[0]){
                "forward" -> x+=li[1].toInt()
                "down" -> d+=li[1].toInt()
                "up" -> d-=li[1].toInt()
            }
        }
        return x*d
    }

    fun part2(input: List<String>): Int {
        var x = 0;
        var d = 0;
        var aim = 0;
        for(i in 0..input.size-1){
            var li = input[i].split(" ")
            when(li[0]){
                "forward" -> {
                    x+=li[1].toInt()
                    d+= (aim*li[1].toInt())
                }
                "down" -> aim+=li[1].toInt()
                "up" -> aim-=li[1].toInt()
            }
        }
        return x*d
    }

    // test if implementation meets criteria from the description, like:
    /*val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)*/

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
