fun main() {
    fun part1(input: List<String>): Int {
        var mat = HashMap<Int, MutableList<Int>>()
        var xMax = -1
        var yMax = -1

        for(i in 0 until input.size){
            var inp = input[i].split(" -> ")
            var a = inp[0].split(",")
            var b = inp[1].split(",")

            if(a[0].toInt() > xMax) xMax = a[0].toInt()
            if(b[0].toInt() > xMax) xMax = b[0].toInt()
            if(a[1].toInt() > yMax) yMax = a[1].toInt()
            if(b[1].toInt() > yMax) yMax = b[1].toInt()
        }
        for(i in 0..yMax){
            mat[i] = mutableListOf<Int>()
            for(j in 0..xMax){
                mat[i]?.add(0)
            }
        }

        for(i in 0 until input.size){
            var inp = input[i].split(" -> ")
            var a = inp[0].split(",")
            var b = inp[1].split(",")

            if(a[1].toInt() == b[1].toInt()){
                var ini = a[0].toInt()
                var end = b[0].toInt()
                if(ini > end){
                    var temp = ini
                    ini = end
                    end = temp
                }
                for(j in ini..end){
                    mat[a[1].toInt()]!![j]++
                }
            }else if(a[0].toInt() == b[0].toInt()){
                var ini = a[1].toInt()
                var end = b[1].toInt()
                if(ini > end){
                    var temp = ini
                    ini = end
                    end = temp
                }
                for(j in ini..end){
                    mat[j]!![a[0].toInt()]++
                }
            }

        }
        var count = 0
        for(i in 0..yMax){
            for(j in 0..xMax){
                if(mat[i]?.get(j)!! >= 2){
                    count++
                }
            }
        }


        return count
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    /*val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)*/

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
