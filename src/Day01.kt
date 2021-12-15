fun main() {
    fun part1(input: List<String>): Int {
        var ini = input[0].toInt()
        var  count = 0
        for(i in 1..input.size-1){
            var num = input[i].toInt()
            if(num > input[i-1].toInt()){
                count++;
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var prev = 0;
        prev += input[0].toInt()
        prev += input[1].toInt()
        prev += input[2].toInt()
        var count = 0;
        for(i in 1..input.size-3){
            var new = input[i].toInt()
            new+= input[i+1].toInt()
            new+= input[i+2].toInt()
            if(new > prev){
                count++
            }
            prev = new
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    /*val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)*/

    val input = readInput("Day01_test")
    println(part1(input))
    println(part2(input))
}
